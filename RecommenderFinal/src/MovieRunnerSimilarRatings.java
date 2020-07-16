import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerSimilarRatings {
    public void printAverageRatings () {
//        String moviefile = "ratedmovies_short.csv";
//        String ratingsfile = "ratings_short.csv";
        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";

        FourthRatings fr = new FourthRatings();

        RaterDatabase.initialize(ratingsfile);
        System.out.println("Rater# " + RaterDatabase.size());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        //printing average rating for all movies with minimal rating count
        ArrayList<Rating> ratings = fr.getAverageRatings(35);
        System.out.println("Ratings found# " + ratings.size());
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        String moviefile = "ratedmovies_short.csv";
        String ratingsfile = "ratings_short.csv";
//        String moviefile = "ratedmoviesfull.csv";
//        String ratingsfile = "ratings.csv";

        FourthRatings fr = new FourthRatings();

        RaterDatabase.initialize(ratingsfile);
        System.out.println("Rater# " + RaterDatabase.size());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        AllFilters filters = new AllFilters();
        filters.addFilter(new YearAfterFilter(1990));
        filters.addFilter(new GenreFilter("Drama"));

        ArrayList<Rating> ratings = fr.getAverageRatingsByFilter(8,filters);
        System.out.println("Ratings found# " + ratings.size());
        Collections.sort(ratings);

        for (Rating rating : ratings) {
            String item = rating.getItem();

            System.out.println(rating.getValue() + " " + MovieDatabase.getYear(item) + " "
                    + MovieDatabase.getTitle(item));
            System.out.println("\t"+MovieDatabase.getGenres(item));
        }
    }

    public void printSimilarRatings() {
//        String moviefile = "ratedmovies_short.csv";
//        String ratingsfile = "ratings_short.csv";
        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";

        FourthRatings fr = new FourthRatings();

        RaterDatabase.initialize(ratingsfile);
        System.out.println("Rater# " + RaterDatabase.size());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        ArrayList<Rating> ratings = fr.getSimilarRatings("71",20,5);
        System.out.println("Ratings found# " + ratings.size());

        for (Rating rating : ratings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printSimilarRatingsByGenre() {
//        String moviefile = "ratedmovies_short.csv";
//        String ratingsfile = "ratings_short.csv";
        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";

        FourthRatings fr = new FourthRatings();

        RaterDatabase.initialize(ratingsfile);
        System.out.println("Rater# " + RaterDatabase.size());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter("964",20,5,
            new GenreFilter("Mystery"));
        System.out.println("Ratings found# " + ratings.size());

        for (Rating rating : ratings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Genre: " + MovieDatabase.getGenres(rating.getItem()));
        }
    }

    public void printSimilarRatingsByDirector() {
//        String moviefile = "ratedmovies_short.csv";
//        String ratingsfile = "ratings_short.csv";
        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";

        FourthRatings fr = new FourthRatings();

        RaterDatabase.initialize(ratingsfile);
        System.out.println("Rater# " + RaterDatabase.size());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter("120",10,2,
                new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh"));
        System.out.println("Ratings found# " + ratings.size());

        for (Rating rating : ratings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Directors: " + MovieDatabase.getDirector(rating.getItem()));
        }
    }

    public void printSimilarRatingsByGenreAndMinutes() {
//        String moviefile = "ratedmovies_short.csv";
//        String ratingsfile = "ratings_short.csv";
        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";

        FourthRatings fr = new FourthRatings();

        RaterDatabase.initialize(ratingsfile);
        System.out.println("Rater# " + RaterDatabase.size());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        AllFilters filter = new AllFilters();
        filter.addFilter(new GenreFilter("Drama"));
        filter.addFilter(new MinutesFilter(80,160));

        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter("168",10,3,
                filter);
        System.out.println("Ratings found# " + ratings.size());

        for (Rating rating : ratings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Genres: " + MovieDatabase.getGenres(rating.getItem()));
            System.out.println("Duration: " + MovieDatabase.getMinutes(rating.getItem()));
        }
    }

    public void printSimilarRatingsByYearAfterAndMinutes() {
//        String moviefile = "ratedmovies_short.csv";
//        String ratingsfile = "ratings_short.csv";
        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";

        FourthRatings fr = new FourthRatings();

        RaterDatabase.initialize(ratingsfile);
        System.out.println("Rater# " + RaterDatabase.size());

        MovieDatabase.initialize(moviefile);
        System.out.println("Movie# " + MovieDatabase.size());

        AllFilters filter = new AllFilters();
        filter.addFilter(new YearAfterFilter(1975));
        filter.addFilter(new MinutesFilter(70,200));

        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter("314",10,5,
                filter);
        System.out.println("Ratings found# " + ratings.size());

        for (Rating rating : ratings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Year: " + MovieDatabase.getYear(rating.getItem()));
            System.out.println("Duration: " + MovieDatabase.getMinutes(rating.getItem()));
        }
    }
}
