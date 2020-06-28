package three;

import one.Rating;

import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerWithFilters {
    public void printAverageRatings () {
        String moviefile = "one/ratedmovies_short.csv";
        String ratingsfile = "data/one/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);

        System.out.println("Rater# " + tr.getRaterSize());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        //printing average rating for all movies with minimal rating count
        ArrayList<Rating> ratings = tr.getAverageRatings(1);
        System.out.println("Ratings found# " + ratings.size());
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByYear() {
        String moviefile = "one/ratedmovies_short.csv";
        String ratingsfile = "data/one/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);

        System.out.println("Rater# " + tr.getRaterSize());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(1,new YearAfterFilter(2000));
        System.out.println("Ratings found# " + ratings.size());
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getYear(rating.getItem())
                    + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByGenre() {
        String moviefile = "one/ratedmovies_short.csv";
        String ratingsfile = "data/one/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);

        System.out.println("Rater# " + tr.getRaterSize());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(1,new GenreFilter("Crime"));
        System.out.println("Ratings found# " + ratings.size());
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            System.out.println(rating.getValue() + " "
                    + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("\t" + MovieDatabase.getGenres(rating.getItem()));
        }
    }

    public void printAverageRatingsByMinutes() {
        String moviefile = "one/ratedmovies_short.csv";
        String ratingsfile = "data/one/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);

        System.out.println("Rater# " + tr.getRaterSize());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(1,new MinutesFilter(110,170));
        System.out.println("Ratings found# " + ratings.size());
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            System.out.println(rating.getValue() + " Time: " + MovieDatabase.getMinutes(rating.getItem())
                    + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByDirectors() {
        String moviefile = "one/ratedmovies_short.csv";
        String ratingsfile = "data/one/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);

        System.out.println("Rater# " + tr.getRaterSize());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(1,new DirectorsFilter("Charles Chaplin,Michael Mann,Spike Jonze"));
        System.out.println("Ratings found# " + ratings.size());
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("\t"+MovieDatabase.getDirector(rating.getItem()));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        String moviefile = "one/ratedmovies_short.csv";
        String ratingsfile = "data/one/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);

        System.out.println("Rater# " + tr.getRaterSize());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        AllFilters filters = new AllFilters();
        filters.addFilter(new YearAfterFilter(1980));
        filters.addFilter(new GenreFilter("Romance"));

        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(1,filters);
        System.out.println("Ratings found# " + ratings.size());
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            String item = rating.getItem();

            System.out.println(rating.getValue() + " " + MovieDatabase.getYear(item) + " "
                    + MovieDatabase.getTitle(item));
            System.out.println("\t"+MovieDatabase.getGenres(item));
        }
    }

    public void printAverageRatingsByDirectorsAndMinutes() {
        String moviefile = "one/ratedmovies_short.csv";
        String ratingsfile = "data/one/ratings_short.csv";

        ThirdRatings tr = new ThirdRatings(ratingsfile);

        System.out.println("Rater# " + tr.getRaterSize());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        AllFilters filters = new AllFilters();
        filters.addFilter(new MinutesFilter(30,170));
        filters.addFilter(new DirectorsFilter("Spike Jonze,Michael Mann,Charles Chaplin,Francis Ford Coppola"));

        ArrayList<Rating> ratings = tr.getAverageRatingsByFilter(1,filters);
        System.out.println("Ratings found# " + ratings.size());
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            String item = rating.getItem();

            System.out.println(rating.getValue() + " " + MovieDatabase.getMinutes(item) + " "
                    + MovieDatabase.getTitle(item));
            System.out.println("\t"+MovieDatabase.getDirector(item));
        }
    }
}
