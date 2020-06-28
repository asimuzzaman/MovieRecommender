package three;

import java.util.ArrayList;

public class GenreFilter implements Filter {
    private String[] myGenres;

    public GenreFilter(String genre) {
        myGenres = genre.split(",");
    }
    @Override
    public boolean satisfies(String id) {
        String genres = MovieDatabase.getGenres(id);

        for (int i=0; i<myGenres.length; i++) {
            if (!genres.contains(myGenres[i].trim()))
                return false;
        }
        return true;
    }
}
