public class Date {
    int month;
    int day;
    int year;
    public Date (String date) {
        int firstSlash = date.indexOf("/");
        int secondSlash = date.lastIndexOf("/");
        month = Integer.parseInt(date.substring(0,firstSlash));
        day = Integer.parseInt(date.substring(firstSlash+1,secondSlash));
        year = Integer.parseInt(date.substring(secondSlash+1));

    }
    public String toString () {
        return String.format("%02d/%02d/%d",month,day,year);
    }
}
