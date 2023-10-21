import java.util.Comparator;

public class SortByHP implements Comparator <Card> {
    public int compare (Card a, Card b) {
        int hpDifference;
        if ((hpDifference = a.getHP()-b.getHP()) == 0) {
            return a.getName().compareToIgnoreCase(b.getName());
        } else {
            return hpDifference;
        }
    }
}