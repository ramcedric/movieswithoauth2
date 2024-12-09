package com.example.movieproject.service;

import com.example.movieproject.entity.Genre;
import com.example.movieproject.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getMoviesByYear(int year);

    List<Movie> getAllMoviesByOrderByYearReleased();

//    List<Movie> getMoviesByGenreAndIsSequel(Genre genre, boolean isSequel);
List<Movie> getMoviesByGenresAndIsSequel(List<Genre> genres, boolean isSequel);
    String getSecurity();

    Movie createMovie(Movie movie);
}
