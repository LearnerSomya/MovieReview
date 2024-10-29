package dev.MovieReviewBySomya.MovieReview;

//import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //for finding movie by objectId we created No Method
    
    //building method that lets us find movie by its imdb ids
    //Optional<Movie> findMovieByImdbId(String imdbId);
}
