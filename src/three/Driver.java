package three;

public class Driver {
    public static void main(String[] args) {
//        FirstRatings fr = new FirstRatings();
//        fr.testLoadRaters();

//        MovieRunnerAverage mra = new MovieRunnerAverage();
//        mra.printAverageRatings();
//        mra.getAverageRatingOneMovie();

        MovieRunnerWithFilters mrf = new MovieRunnerWithFilters();
//        mrf.printAverageRatings();
//        mrf.printAverageRatingsByYear();
//        mrf.printAverageRatingsByGenre();
//        mrf.printAverageRatingsByMinutes();
//        mrf.printAverageRatingsByDirectors();
//        mrf.printAverageRatingsByYearAfterAndGenre();
        mrf.printAverageRatingsByDirectorsAndMinutes();
    }
}
