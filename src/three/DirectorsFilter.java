package three;

public class DirectorsFilter implements Filter {
    private String[] myDirectors;

    public DirectorsFilter(String directors) {
        myDirectors = directors.split(",");
    }

    @Override
    public boolean satisfies(String id) {
        String directors = MovieDatabase.getDirector(id);

        for (int i=0; i<myDirectors.length; i++) {
            if (directors.contains(myDirectors[i].trim()))
                return true;
        }
        return false;
    }
}
