//first RestAPI Controller
package dev.MovieReviewBySomya.MovieReview;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//here in RequestMapping("/api/v1/movies") it means any repuest made to the api which is ending with "/api/v1/movies" 
//will be hadled by this controller
@RequestMapping("/api/v1/movies")
public class MovieControllers {
    @GetMapping
    public String allMovies(){
        return "All Movies!";
    }

}
 