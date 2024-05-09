package dev.MovieReviewBySomya.MovieReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MovieReviewService {
    @Autowired
    private MovieReviewRepository movieRepository;
    //Database access methods
    public List<MovieReview> allMovies(){
        return movieRepository.findAll();
    }
}
