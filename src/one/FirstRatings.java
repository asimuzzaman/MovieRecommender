package one;

import edu.duke.FileResource;
import org.apache.commons.csv.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FirstRatings {
    public ArrayList<Movie> loadMovies(String fileName) {
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser();
        ArrayList<Movie> movies = new ArrayList<>();

        for (CSVRecord rec : parser) {
            Movie mv = new Movie(rec.get("id"), rec.get("title"), rec.get("year"), rec.get("genre")
                , rec.get("director"), rec.get("country"), rec.get("poster"), Integer.parseInt(rec.get("minutes")));

            movies.add(mv);
        }
        return movies;
    }

    public void testLoadMovies() {
//        String fileName = "data/one/ratedmovies_short.csv";
        String fileName = "data/one/ratedmoviesfull.csv";
        ArrayList<Movie> movies = loadMovies(fileName);

//        for (Movie mv : movies) {
//            System.out.println(mv.toString());
//        }

        System.out.println("Total movies# "+ movies.size());

        //Counting # of comedy movies
//        int comedy = 0;
//        for (Movie mv : movies) {
//            if (mv.getGenres().contains("Comedy"))
//                comedy++;
//        }
//        System.out.println("Comedy movie# " + comedy);

        //Counting movies longer than 150 mins
//        int longer = 0;
//        for (Movie mv : movies) {
//            if (mv.getMinutes() > 150)
//                longer++;
//        }
//        System.out.println("Longer than 150 mins# " + longer);

        //Director counting
        HashMap<String,Integer> directorMap = new HashMap<>();
        for (Movie mv : movies) {
            String[] directors = mv.getDirector().split(",");

            for (int i=0; i<directors.length; i++) {
                String direc = directors[i].trim();
                if (directorMap.containsKey(direc))
                    directorMap.put(direc, directorMap.get(direc)+1);
                else
                    directorMap.put(direc, 1);
            }
        }
        int max = -1;
        for (String s : directorMap.keySet()) {
            if (directorMap.get(s) > max)
                max = directorMap.get(s);
        }
        System.out.println("Max movie# directed: "+ max);
        for (String s : directorMap.keySet()) {
            if (directorMap.get(s) == max)
                System.out.println(s);
        }
    }

    public ArrayList<Rater> loadRaters(String fileName) {
        ArrayList<Rater> raters = new ArrayList<>();
        FileResource fr = new FileResource(fileName);
        CSVParser parser = fr.getCSVParser();

        for (CSVRecord rec : parser) {
            String raterId = rec.get("rater_id");

            //checking whether it's a new rater or not
            int idx = -1;
            for (int i=0; i<raters.size(); i++) {
                if (raters.get(i).getID().equals(raterId)) {
                    idx = i;
                    break;
                }
            }
            //new Rater
            if (idx == -1) {
                Rater rater = new Rater(raterId);
                rater.addRating(rec.get("movie_id"), Double.parseDouble(rec.get("rating")));
                raters.add(rater);
            } else { //old Rater
                raters.get(idx).addRating(rec.get("movie_id"), Double.parseDouble(rec.get("rating")));
            }
        }
        return  raters;
    }

    public void testLoadRaters() {
//        String fileName = "data/one/ratings_short.csv";
        String fileName = "data/one/ratings.csv";
        ArrayList<Rater> raters = loadRaters(fileName);

        System.out.println("Total rater# " + raters.size());

//        for (Rater r : raters) {
//            System.out.println("Rater: " + r.getID() + ", Rating# " + r.numRatings());
//
//            ArrayList<String> items = r.getItemsRated();
//            for (String item : items) {
//                System.out.println("Item ID: " + item + ", rating: " + r.getRating(item));
//            }
//        }

        //number of ratings for a rater
//        String raterId = "193";
//        for (Rater r : raters) {
//            if (r.getID().equals(raterId)) {
//                System.out.println(raterId + " rated " + r.numRatings() + " movies.");
//            }
//        }

        //Rater counting
//        int maxCount = -1;
//        String maxRater = "";
//        for (Rater r : raters) {
//            if (r.numRatings() > maxCount) {
//                maxCount = r.numRatings();
//                maxRater = r.getID();
//            }
//        }
//
//        System.out.println("Max rating# "+ maxCount);
//        for (Rater r : raters) {
//            if (r.numRatings() == maxCount)
//                System.out.println("Rater ID: " + r.getID());
//        }

        //count total rating# for specific movie
//        String movieId = "1798709";
//        int countRatings = 0;
//        for (Rater r : raters) {
//            if (r.hasRating(movieId))
//                countRatings++;
//        }
//        System.out.println(movieId + " has " + countRatings + " ratings.");

        //counting total rated movie#
        HashSet<String> movieSet = new HashSet<>();
        for (Rater r : raters) {
            ArrayList<String> movies = r.getItemsRated();
            for (String movie : movies) {
                if (!movieSet.contains(movie))
                    movieSet.add(movie);
            }
        }
        System.out.println("Total movies rated: " + movieSet.size());
    }
}
