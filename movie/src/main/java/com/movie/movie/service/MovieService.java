package com.movie.movie.service;

import com.movie.movie.dto.MovieDto;
import com.movie.movie.entity.Movie;
import com.movie.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieDto getMovie(Integer id) {
        var movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        return buildMovieDto(movie);
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
