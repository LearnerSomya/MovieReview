package dev.somya.movies;

import java.util.*;
//import java.util.List;
//import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    //inside this Service class we need reference of Repository
    @Autowired
    private MovieRepository movieRepository;
    // for getting whole data 
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovieById(ObjectId id){
        return movieRepository.findById(id);
    }
    
    public Optional<Movie> singleMovieByImdbId(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public List<Movie> MovieByTitle(String keyword){
        return movieRepository.findMovieByTitle(keyword);
    }

    public List<Movie> MovieByGenre(String genre){
        return movieRepository.findMovieByGenre(genre);
    }


    public Movie addMovie(Movie movieToAdd){
        return movieRepository.save(movieToAdd);
    }
}
