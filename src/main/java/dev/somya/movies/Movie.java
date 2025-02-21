package dev.somya.movies;

import java.util.List;
import java.util.Random;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//this is a class,
//this "@Data" handles all geters and setrs and toString methods
//this "@AllArgsConstructor" anotation for creating constructors that takes all below private fields as argument
//this "NoArgsConstructor" anotation for creating constructor that askes for no arguments
@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    //here this "@Id" will reperenst id of movies in this class
    @Id
    private ObjectId id;

    private String imdbId;
    
    private String title;
    
    private String releaseDate;
    
    private String trailerLink;
    
    private String poster;
    
    private List<String> genres;
    
    private List<String> backdrops;
    
    // here this "Reviews" is Reviwe.java file, this "@DocumentRefernce" will make sure that here in this "Movie.java" fill's
    // private List<Reviews> reviewIds will hold only ids of the reviwes and the actual reviwe lines will me saved in "Reviwes.java" file
    @DocumentReference
    private List<Review> reviewIds;


    //Constructor to auto-generate id and imdbId
    public Movie(String title, String releaseDate, String trailerLink, String poster, List<String> genres, List<String> backdropes, List<String> reviewIds){
        this.id = new ObjectId();
        this.imdbId = generateImdbId();
        this.title = title;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.genres = genres;
        this.backdrops = backdropes;
        this.reviewIds = reviewIds;
    }

    private String generateImdbId() {
        Random random = new Random();
        int randomNumber = 1000000 + random.nextInt(9000000);
        return "tt" + randomNumber;
    }
    
}
