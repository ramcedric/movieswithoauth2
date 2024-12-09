package com.example.movieproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

}


//Method: Use Postman to send a POST request to http://localhost:8080/movies/create.
//Body: Select raw and JSON format. Provide JSON data for the movie you want to create, for example:
//
//
//{
//		"name": "Movie X",
//		"yearReleased": 2023,
//		"isSequel": false,
//		"genre": "ACTION",
//		"castList": ["Actor A", "Actress B"]
//		}

//GET Request for Genres: Send a GET request to
//http://localhost:8080/movies/genres/ACTION/sequel/false

