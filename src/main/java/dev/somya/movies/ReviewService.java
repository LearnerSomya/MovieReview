package dev.somya.movies;

//import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query; 
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId){
        // Review review =  reviewRepository.insert(new Review(reviewBody));
        
        // mongoTemplate.update(Movie.class)
        //     .matching(Criteria.where("imdbId").is(imdbId))
        //     .apply(new Update().push("reviewIds").value(review))
        //     .first();

        // return review;


        // Fetch the movie title based on imdbId
        Query query = Query.query(Criteria.where("imdbId").is(imdbId));
        Movie movie = mongoTemplate.findOne(query, Movie.class);
        
        if (movie == null) {
            throw new RuntimeException("Movie not found for IMDb ID: " + imdbId);
        }

        String movieTitle = movie.getTitle(); // Assuming Movie has a getTitle() method

        // Create a Review object with the movie title
        Review review = reviewRepository.insert(new Review(reviewBody, movieTitle));

        // Push the review into movie's reviewIds array
        mongoTemplate.update(Movie.class)
            .matching(Criteria.where("imdbId").is(imdbId))
            .apply(new Update().push("reviewIds").value(review))
            .first();

        return review;
    }
}
