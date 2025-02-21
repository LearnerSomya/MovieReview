package dev.somya.movies;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    //creating endpoints to put/get reviews of the movie
    @Autowired
    private ReviewService reviewService;


    @PostMapping
    //method
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        //here we are saying to the framework, whateve we are giving you, 
        //as request body convert it into Map of Key string and value string
        
        //Created gives status 201 while OK gives 200
        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")),HttpStatus.CREATED);

    }
}
