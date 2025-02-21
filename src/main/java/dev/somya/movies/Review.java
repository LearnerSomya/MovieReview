package dev.somya.movies;
import java.rmi.server.ObjID;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review { 

    @Id
    private ObjectId id;

    private String body;
    
    private String movieTitle;
    
    //customConstructor - for review and id only
    public Review(String body){
        this.body = body;
    }

    //customeConstructor - for review and movie title as well
    public Review(String body, String movieTitle){
        this.body = body;
        this.movieTitle = movieTitle;
    }
    
}
