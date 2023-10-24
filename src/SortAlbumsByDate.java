import java.util.Comparator;

public class SortAlbumsByDate implements Comparator <Album> {
    public int compare (Album a, Album b) {
        return a.getDate().compareTo(b.getDate());
    }
}
