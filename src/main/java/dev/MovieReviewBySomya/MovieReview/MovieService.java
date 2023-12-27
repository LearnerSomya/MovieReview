package dev.MovieReviewBySomya.MovieReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    //Database access methods
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }
}
