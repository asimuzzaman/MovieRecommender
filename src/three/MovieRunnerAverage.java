package three;

import one.Rating;

import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerAverage {
    public void printAverageRatings () {
        String moviefile = "data/one/ratedmovies_short.csv";
        String ratingsfile = "data/one/ratings_short.csv";
        SecondRatings sr = new SecondRatings(moviefile, ratingsfile);

        System.out.println("Movie# " + sr.getMovieSize());
        System.out.println("Rater# " + sr.getRaterSize());

        //printing average rating for all movies with minimal rating count
        ArrayList<Rating> ratings = sr.getAverageRatings(3);
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            System.out.println(rating.getValue() + " " + sr.getTitle(rating.getItem()));
        }
    }

    public void getAverageRatingOneMovie() {
        String moviefile = "data/one/ratedmovies_short.csv";
        String ratingsfile = "data/one/ratings_short.csv";
        SecondRatings sr = new SecondRatings(moviefile, ratingsfile);

        String title = "The Godfather";
        //should have at least "minimalRaters" number of ratings
        ArrayList<Rating> ratings = sr.getAverageRatings(2);
        String ID = sr.getID(title);

        for (Rating rating : ratings) {
            if (rating.getItem().equals(ID))
                System.out.println(title + " " + rating.getValue());
        }
    }
}
