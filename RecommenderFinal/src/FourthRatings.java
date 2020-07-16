import java.util.ArrayList;
import java.util.Collections;

public class FourthRatings {

    private double getAverageByID(String id, int minimalRaters) {
        int count = 0;
        double sum = 0.0;

        for (Rater rater : RaterDatabase.getRaters()) {
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

    private double dotProduct(Rater me, Rater r) {
        double sumProduct = 0.0;

        for (String movie : me.getItemsRated()) {
            if (!r.hasRating(movie))
                continue;
            double myRating = me.getRating(movie) - 5;
            double rRating = r.getRating(movie) - 5;
            sumProduct += myRating * rRating;
        }
        return sumProduct;
    }

    private ArrayList<Rating> getSimilarities(String id) {
        ArrayList<Rating> similarities = new ArrayList<>();
        Rater me = RaterDatabase.getRater(id);

        for (Rater rater : RaterDatabase.getRaters()) {
            if (rater.getID().equals(id))
                continue;

            Rating rating = new Rating(rater.getID(),dotProduct(me,rater));
            similarities.add(rating);
        }

        Collections.sort(similarities,Collections.reverseOrder());

        return similarities;
    }

    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalRaters) {
        ArrayList<Rating> ratings = new ArrayList<>();
        ArrayList<Rating> similars = getSimilarities(id);

        //avoiding bad indexing
        if (similars.size() < numSimilarRaters)
            numSimilarRaters = similars.size();

        for (String movie : MovieDatabase.filterBy(new TrueFilter())) {
            double total = 0.0;
            int ratingCount = 0;

            //getting top 'numSimilarRaters' raters
            for (int i=0; i<numSimilarRaters; i++) {
                Rating similarityRating = similars.get(i);
                Rater rater = RaterDatabase.getRater(similarityRating.getItem());

                double rating = -1.0;
                if (!rater.hasRating(movie))
                    continue;

                rating = rater.getRating(movie);
                ratingCount++;

                total += similarityRating.getValue() * rating;
            }
            if (ratingCount >= minimalRaters) {
                ratings.add(new Rating(movie,total/ratingCount));
            }
        }

        Collections.sort(ratings);
        return ratings;
    }

    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalRaters, Filter filter) {
        ArrayList<Rating> ratings = new ArrayList<>();
        ArrayList<Rating> similars = getSimilarities(id);

        //avoiding bad indexing
        if (similars.size() < numSimilarRaters)
            numSimilarRaters = similars.size();

        for (String movie : MovieDatabase.filterBy(filter)) {
            double total = 0.0;
            int ratingCount = 0;

            //getting top 'numSimilarRaters' raters
            for (int i=0; i<numSimilarRaters; i++) {
                Rating similarityRating = similars.get(i);
                Rater rater = RaterDatabase.getRater(similarityRating.getItem());

                double rating = -1.0;
                if (!rater.hasRating(movie))
                    continue;

                rating = rater.getRating(movie);
                ratingCount++;

                total += similarityRating.getValue() * rating;
            }
            if (ratingCount >= minimalRaters) {
                ratings.add(new Rating(movie,total/ratingCount));
            }
        }

        Collections.sort(ratings);
        return ratings;
    }
}
