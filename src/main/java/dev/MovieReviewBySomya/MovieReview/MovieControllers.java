//first RestAPI Controller
package dev.MovieReviewBySomya.MovieReview;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
//here in RequestMapping("/api/v1/movies") it means any repuest made to the api which is ending with "/api/v1/movies" 
//will be hadled by this controller
@RequestMapping("/api/v1/movies")
public class MovieControllers {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        //this "allMovies" are in MovieService.java
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

}
