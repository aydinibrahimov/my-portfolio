package com.movie.movie.service;

import com.movie.movie.dto.MovieDto;
import com.movie.movie.entity.Movie;
import com.movie.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final FileService fileService;

    @Value("${project.poster}")
    private String path;

    @Value("${base.url}")
    private String baseUrl;


    public MovieDto addMovie(MovieDto movieDto, MultipartFile file) throws IOException {
        var uploadedFileName = fileService.uploadFile(path, file);
        movieDto.setPoster(uploadedFileName);
        var posterUrl = baseUrl + uploadedFileName;
        movieDto.setPosterUrl(posterUrl);
        var movie = buildMovie(movieDto);
        movie.setStatus("I");
        movie = movieRepository.save(movie);
        return buildMovieDto(movie);
    }

    public MovieDto getMovie(Integer id) {
        var movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id=" + id));
        return buildMovieDto(movie);
    }

    public String deleteMovie(Integer movieId) throws IOException {
        var movieDto = getMovie(movieId);
        buildMovie(movieDto).setStatus("R");
        return "Movie deleted with id = " + movieId;
    }


    public List<MovieDto> getAllMovies() {
        var movieList = movieRepository.findByStatusNot("R");
        List<MovieDto> movieDtoList = new ArrayList<>();
        for (Movie movie : movieList) {
            var dto = buildMovieDto(movie);
            dto.setPosterUrl(baseUrl.concat(movie.getPoster()));
            movieDtoList.add(dto);
        }
        return movieDtoList;
    }


    private MovieDto buildMovieDto(Movie movie) {
        var movieDto = MovieDto.builder()
                .movieCast(movie.getMovieCast())
                .poster(movie.getPoster())
                .title(movie.getTitle())
                .director(movie.getDirector())
                .build();
        return movieDto;
    }

    private Movie buildMovie(MovieDto movieDto) {
        var movie = Movie.builder()
                .movieCast(movieDto.getMovieCast())
                .poster(movieDto.getPoster())
                .title(movieDto.getTitle())
                .director(movieDto.getDirector())
                .build();
        return movie;
    }
}