//This file is API layer fro system
package dev.somya.movies;

import java.util.*;
//import java.util.List;
//import java.util.Optional;

import org.bson.types.ObjectId;
//import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//here in RequestMapping("/api/v1/movies") it means any repuest made to the api which is ending with "/api/v1/movies" 
//will be hadled by this controller
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    //accessing complete data/all movies
    @GetMapping
    // public String getAllMovies(){
    //     return "All Movies";
    // }

    // public ResponseEntity<String> getAllMovies(){
    //     return new ResponseEntity<String>("All Movies haha!", HttpStatus.OK);
    // }

    public ResponseEntity<List<Movie>> getAllMovies(){
        //return movieService.AllMovies()
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    // //accessing single movie by its Objectid
    // @GetMapping("/{id}")
    // public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
    //     return new ResponseEntity<Optional<Movie>>(movieService.singleMovieById(id),HttpStatus.OK);
    // }

    //accessing single movie by its Objectid
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovieById( id),HttpStatus.OK);
    }

    //accessing single movie by its imdbId
    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovieByImdbId(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByImdbId(imdbId),HttpStatus.OK);
    }

    //list movies by there titles or any word
    @GetMapping("/title/{keyword}")
    public ResponseEntity<List<Movie>> getMovieByName(@PathVariable String keyword){
        return new ResponseEntity<List<Movie>>(movieService.MovieByTitle(keyword),HttpStatus.OK);
    }

    //list movies by there geners
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre){
        //return new ResponseEntity<List<Movie>>(movieService.MovieByGenre(genre),HttpStatus.OK);
        List<Movie> movies = movieService.MovieByGenre(genre);
        return new ResponseEntity<>(movies, HttpStatus.OK);

    }


    //Add new movie
    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        Movie newMovie = new Movie(
            movie.getTitle(),
            movie.getReleaseDate(),
            movie.getTrailerLink(),
            movie.getPoster(),
            movie.getGenres(),
            movie.getBackdrops()
        );
        Movie savedMovie = movieService.addMovie(newMovie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

}
