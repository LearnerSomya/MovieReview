package dev.MovieReviewBySomya.MovieReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    
    @Autowired
    //Template to form dynamic quarrey and do jobs in data base
    private MongoTemplate mongoTemplate;


    public Reviews createReview(String reviewBody, String imdbId){
        //it is review content that writer writes
        Reviews review =  reviewRepository.insert(new Reviews(reviewBody));

        mongoTemplate.update(Movie.class)
        //this line will navigate or give imdb id of the movie we are giving review about
            .matching(Criteria.where("imdbId").is(imdbId))
            .apply(new Update().push("reviewIds").value(review))
            .first();

        return review;
    }
}
