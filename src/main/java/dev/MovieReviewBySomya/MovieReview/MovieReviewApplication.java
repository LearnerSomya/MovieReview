
package dev.MovieReviewBySomya.MovieReview;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
//@RestController
public class MovieReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewApplication.class, args);
	}

	// @GetMapping("/root")
	// //if we add anything in @GetMapping it will change the address and we need to add that very word in our http to navigate to the desired page
	// public String apiRoot(){
	// 	return "Hello world";
	// }
}
 