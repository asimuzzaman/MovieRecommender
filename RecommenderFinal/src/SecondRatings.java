/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }

    public SecondRatings(String moviefile, String ratingsfile) {
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies(moviefile);
        myRaters = fr.loadRaters(ratingsfile);
    }

    public int getMovieSize() {
        return myMovies.size();
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
        ArrayList<Rating> ratings = new ArrayList<>();

        for (Movie movie : myMovies) {
            double average = getAverageByID(movie.getID(),minimalRaters);
            if (average > 0.0) {
                Rating rating = new Rating(movie.getID(), average);
                ratings.add(rating);
            }
        }
        return ratings;
    }

    public String getTitle(String id) {
        for (Movie movie : myMovies) {
            if (movie.getID().equals(id))
                return movie.getTitle();
        }
        return "NO SUCH ID.";
    }

    public String getID(String title) {
        for (Movie movie : myMovies) {
            if (movie.getTitle().equals(title))
                return movie.getID();
        }
        return "NO SUCH TITLE.";
    }
}
