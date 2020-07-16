import java.util.ArrayList;

public class RecommendationRunner implements Recommender {
    @Override
    public ArrayList<String> getItemsToRate() {
        ArrayList<String> list = new ArrayList<>();

        list.add("2756032");
        list.add("1220634");
        list.add("1188113");
        list.add("1649444");
        list.add("1074638");
        list.add("2473794");
        list.add("115685");
        list.add("175880");
        list.add("1453405");
        list.add("1646980");
        list.add("1790864");
        list.add("87803");
        list.add("2752688");
        return list;
    }

    @Override
    public void printRecommendationsFor(String webRaterID) {
        String moviefile = "ratedmoviesfull.csv";
        String ratingsfile = "ratings.csv";

        FourthRatings fr = new FourthRatings();

        RaterDatabase.initialize(ratingsfile);
//        System.out.println("Rater# " + RaterDatabase.size());

        MovieDatabase.initialize(moviefile);
//        System.out.println("Movie# " + MovieDatabase.size());

        ArrayList<Rating> ratings = fr.getSimilarRatings(webRaterID,10,5);
//        System.out.println("Ratings found# " + ratings.size());

        System.out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "table {\n" +
                "  border-collapse: collapse;\n" +
                "  width: 100%;\n" +
                "}\n" +
                "\n" +
                "th, td {\n" +
                "  text-align: left;\n" +
                "  padding: 8px;\n" +
                "}\n" +
                "\n" +
                "tr:nth-child(even) {background-color: #f2f2f2;}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>");
        if (ratings.size() == 0) {
            System.out.println("<h1>No movies to recommend!</h1><br><h2 style=\"align: center;\">No movies matched with web rater's preference. Have a great day!</h2>");
        }
        System.out.println("<table style=\"border: 5px;\">");
        System.out.println("<thead><th>Title</th><th>Rating</th><th>Genres</th></thead>");
        System.out.println("<tbody>");
        for (Rating rating : ratings) {
            System.out.println("<tr>");
            System.out.println("<td>"+MovieDatabase.getTitle(rating.getItem())+"</td>");
            System.out.println("<td>"+rating.getValue()+"</td>");
            System.out.println("<td>"+MovieDatabase.getGenres(rating.getItem())+"</td>");
            System.out.println("</tr>");
        }
        System.out.println("</tbody></table>");
        System.out.println("<h2>Developed by Md. Asimuzzaman</h2>");
        System.out.println("</body>\n" +
                "</html>");
    }
}
