
public class MinutesFilter implements Filter {
    private int myMin, myMax;

    public MinutesFilter(int min, int max) {
        myMin = min;
        myMax = max;
    }

    @Override
    public boolean satisfies(String id) {
        int minutes = MovieDatabase.getMinutes(id);
        return (minutes >= myMin && minutes <= myMax);
    }
}
