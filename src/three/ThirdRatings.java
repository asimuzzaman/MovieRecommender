package three;

import one.Movie;
import one.Rating;

import java.util.ArrayList;

public class ThirdRatings {
    private ArrayList<Rater> myRaters;

    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }

    public ThirdRatings(String ratingsfile) {
        FirstRatings fr = new FirstRatings();
        myRaters = fr.loadRaters(ratingsfile);
    }


    public int getRaterSize() {
        return myRaters.size();
    }

    private double getAverageByID(String id, int minimalRaters) {
        int count = 0;
        double sum = 0.0;

        for (Rater rater : myRaters) {
            if (rater.hasRating(id)) {
                sum += rater.getRating(id);
                count++;
            }
        }
        if (count >= minimalRaters)
            return sum/count;
        return 0.0;
    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter()); //get all movies
        ArrayList<Rating> ratings = new ArrayList<>();

        for (String movie : movies) {
            double average = getAverageByID(movie, minimalRaters);
            if (average > 0.0) {
                Rating rating = new Rating(movie, average);
                ratings.add(rating);
            }
        }
        return ratings;
    }

    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria) {
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        ArrayList<Rating> ratings = new ArrayList<>();

        for (String movie : movies) {
            double average = getAverageByID(movie, minimalRaters);
            if (average > 0.0) {
                Rating rating = new Rating(movie, average);
                ratings.add(rating);
            }
        }
        return ratings;
    }
}
