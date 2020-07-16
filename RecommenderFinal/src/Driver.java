public class Driver {
    public static void main(String[] args) {
        MovieRunnerSimilarRatings mrs = new MovieRunnerSimilarRatings();

//        mrs.printAverageRatings();
//        mrs.printSimilarRatings();
//        mrs.printSimilarRatingsByGenre();
//        mrs.printSimilarRatingsByDirector();
//        mrs.printSimilarRatingsByGenreAndMinutes();
//        mrs.printSimilarRatingsByYearAfterAndMinutes();

//        MovieRunnerWithFilters mrf = new MovieRunnerWithFilters();
//        mrf.printAverageRatings();

        RecommendationRunner rr = new RecommendationRunner();
        rr.printRecommendationsFor("65");
    }
}
