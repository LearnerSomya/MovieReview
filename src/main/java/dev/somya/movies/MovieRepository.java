package dev.somya.movies;

import java.util.*;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


//Repositories are interface type
//here in extends MongoRepository we are telling it what kind of data and id we are deling with and 
@Repository 
public interface MovieRepository extends MongoRepository<Movie, ObjectId>{
    //for finding movie by objectId we created there is No
    //building method that lets us find movie by its imdb ids so here we are 
    //making one queuery
    Optional<Movie> findMovieByImdbId(String imdbId);

    //method for listing movies based on there title or keyword of title
    @Query("{'title' : {$regex : ?0, $options : 'i'}}")
    List<Movie> findMovieByTitle(String keyword);

    //Optional<Movie> findMovieByTitle(String title);

    // //API shows movies just by name but to hide some fields
    // @Query(value = "{'title' : {$regex : ?0, $options : 'i'}}",
    // fields = "{'_id' : 0,'title' : 1, 'releaseDate' : 1, 'trailerLink' : 1, 'genres' : 1, 'poster' : 1, 'backdrops' : 1, 'reviewsIds' : 1}")
    // List<Movie> findMovieByTitle (String keyword);


    //method for listing movies based on there genres
    @Query("{'genres' : {$regex : ?0, $options : 'i'}}")
    List<Movie> findMovieByGenre(String genre); 
}
