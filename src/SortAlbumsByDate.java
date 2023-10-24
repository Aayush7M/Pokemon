import java.util.Comparator;

public class SortAlbumsByDate implements Comparator <Album> {
    public int compare (Album a, Album b) {
        if (a.getDate() == null || b.getDate() == null) {
            return 0;
        }
        int yearDifference;
        if ((yearDifference = a.getDate().getYear()-b.getDate().getYear())==0) {
            int monthDifference;
            if ((monthDifference = a.getDate().getMonth()-b.getDate().getMonth())==0) {
                int dayDifference;
                if ((dayDifference = a.getDate().getDay()-b.getDate().getDay())==0) {
                    return a.getAlbumNum()-b.getAlbumNum();
                } else {
                    return dayDifference;
                }
            } else {
                return monthDifference;
            }
        } else {
            return yearDifference;
        }
    }
}
