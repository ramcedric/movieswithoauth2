package com.example.movieproject.controller;

import com.example.movieproject.entity.Genre;
import com.example.movieproject.entity.Movie;
import com.example.movieproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Fetch movies by year
    @GetMapping("/year/{year}")
    public List<Movie> getMoviesByYear(@PathVariable int year) {
        return movieService.getMoviesByYear(year);
    }

    // Fetch all movies ordered by year
    @GetMapping("/all")
    public List<Movie> getAllMoviesByOrderByYearReleased() {
        return movieService.getAllMoviesByOrderByYearReleased();
    }

    // Fetch movies by genre and sequel status
    @GetMapping("/genres/{genre}/sequel/{isSequel}")
    public List<Movie> getMoviesByGenresAndIsSequel(
            @PathVariable String genre,
            @PathVariable boolean isSequel) {

        return movieService.getMoviesByGenresAndIsSequel(List.of(Genre.valueOf(genre)), isSequel);
    }

    // Create a new movie (public)
    @PostMapping("/create")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    // Fetch the current logged-in user (if required)
    @GetMapping("/user")
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Logged in user: " + authentication.getName();
    }
}
