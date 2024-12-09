package com.example.movieproject.repository;

import com.example.movieproject.entity.Genre;
import com.example.movieproject.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    List<Movie> findByYearReleased(int year);

    List<Movie> findAllByOrderByYearReleased();

    List<Movie> findByGenreInAndIsSequel(List<Genre> genre, boolean isSequel);

}
