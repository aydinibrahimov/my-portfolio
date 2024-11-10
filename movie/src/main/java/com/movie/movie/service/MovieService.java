package com.movie.movie.service;

import com.movie.movie.dto.MovieDto;
import com.movie.movie.entity.Movie;
import com.movie.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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


    public MovieDto addMovie(MovieDto movieDto, MultipartFile file) {
        var movie = movieRepository.save(buildMovie(movieDto));
        return buildMovieDto(movie);
    }

    public MovieDto getMovie(Integer id) {
        var movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        return buildMovieDto(movie);
    }


    public List<MovieDto> getMovie() {
        var movieList = movieRepository.findAll();
        var movieDtoList = movieList.stream()
                .map(x -> buildMovieDto(x))
                .collect(Collectors.toList());
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
