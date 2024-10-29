package dev.MovieReviewBySomya.MovieReview;

//import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
//import java.util.Optional;
@Service
public class MoviewService {
    //AutoWired will let the frame work know that we want to instanciate the following class here like here "MovieRepository"
    @Autowired
    private MovieRepository movieRepository;
    //Database access methods
    public List<Movie> AllMovies(){
        return movieRepository.findAll();
    }
    // //for getting single movie by its objectid
    // public Optional<Movie> singleMovieById(ObjectId id){
    //     return movieRepository.findById(id);
    // }

    //for getting single movie by its imdbid
    // public Optional<Movie> singleMovieByImdbId(String imdbId){
    //     return movieRepository.findMovieByImdbId(imdbId);
    // }
    
}
 