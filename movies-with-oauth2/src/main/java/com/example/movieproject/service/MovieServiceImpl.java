package com.example.movieproject.service;

import com.example.movieproject.entity.Genre;
import com.example.movieproject.entity.Movie;
import com.example.movieproject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getMoviesByYear(int year) {
        return movieRepository.findByYearReleased(year);
    }

    @Override
    public List<Movie> getAllMoviesByOrderByYearReleased() {
        return movieRepository.findAllByOrderByYearReleased();
    }

//    @Override
//    public List<Movie> getMoviesByGenreAndIsSequel(Genre genre, boolean isSequel) {
//        return List.of();
//    }

    @Override
    public List<Movie> getMoviesByGenresAndIsSequel(List<Genre> genres, boolean isSequel) {
        return movieRepository.findByGenreInAndIsSequel(genres, isSequel);
    }

    @Override
    public String getSecurity() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "" + auth;
    }


    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
