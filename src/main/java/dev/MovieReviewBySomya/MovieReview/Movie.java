package dev.MovieReviewBySomya.MovieReview;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//this is a class,
@Document(collation = "movies")
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
    private List<String> geners;
    private List<String> backdrops;
}
