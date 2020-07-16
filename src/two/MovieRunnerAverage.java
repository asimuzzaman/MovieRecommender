package two;

import one.Rating;

import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerAverage {
    public void printAverageRatings () {
//        String moviefile = "data/one/ratedmovies_short.csv";
//        String ratingsfile = "data/one/ratings_short.csv";
        String moviefile = "data/one/ratedmoviesfull.csv";
        String ratingsfile = "data/one/ratings.csv";
        SecondRatings sr = new SecondRatings(moviefile, ratingsfile);

        System.out.println("Movie# " + sr.getMovieSize());
        System.out.println("Rater# " + sr.getRaterSize());

        //printing average rating for all movies with minimal rating count
        ArrayList<Rating> ratings = sr.getAverageRatings(12);
        Collections.sort(ratings);

        double lowestRating = 100.0;
        String lowest = "";

        for (Rating rating : ratings) {
            double rate = rating.getValue();

            if (lowestRating > rate) {
                lowestRating = rate;
                lowest = sr.getTitle(rating.getItem());
            }
            System.out.println(rating.getValue() + " " + sr.getTitle(rating.getItem()));
        }
        System.out.println("Total resulting movies: " + ratings.size());

        System.out.println("Movie with lowest rating: " + lowest + ", " + lowestRating);
    }

    public void getAverageRatingOneMovie() {
//        String moviefile = "data/one/ratedmovies_short.csv";
        String moviefile = "data/one/ratedmoviesfull.csv";
//        String ratingsfile = "data/one/ratings_short.csv";
        String ratingsfile = "data/one/ratings.csv";
        SecondRatings sr = new SecondRatings(moviefile, ratingsfile);

        String title = "Vacation";
        //should have at least "minimalRaters" number of ratings
        ArrayList<Rating> ratings = sr.getAverageRatings(2);
        String ID = sr.getID(title);

        for (Rating rating : ratings) {
            if (rating.getItem().equals(ID))
                System.out.println(title + " " + rating.getValue());
        }
    }
}
