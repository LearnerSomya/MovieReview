//first RestAPI Controller
package dev.MovieReviewBySomya.MovieReview;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.bson.types.ObjectId;
//import org.apache.catalina.connector.Response;

//import org.springframework.http.HttpStatus;

//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
//import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
//here in RequestMapping("/api/v1/movies") it means any repuest made to the api which is ending with "/api/v1/movies" 
//will be hadled by this controller
@RequestMapping("/api/v1/movies")
public class MovieControllers {
    //@Autowired
    private MoviewService movieService;
    //accessing complete data/all movies
    @GetMapping
    public String getAllMovies(){
        return "All Movies";
    }
    // public ResponseEntity<List<Movie>> getAllMovies(){
    //     //return movieService.AllMovies()
    //     return new ResponseEntity<List<Movie>>(movieService.AllMovies(), HttpStatus.OK);
    // }

    // //accessing single movie by its Objectid
    // @GetMapping("/{id}")
    // public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
    //     return new ResponseEntity<Optional<Movie>>(movieService.singleMovieById(id),HttpStatus.OK);

    // }

    // //accessing single movie by its imdbId
    // @GetMapping("/{imdbId}")
    // public ResponseEntity<Optional<Movie>> getSingleMovieByImdbId(@PathVariable String imdbId){
    //     return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByImdbId(imdbId),HttpStatus.OK);
 
    // }
}
