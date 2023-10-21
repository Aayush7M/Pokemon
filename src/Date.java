public class Date {
    int month;
    int day;
    int year;
    public Date (int[] parsedDate) {
        month = parsedDate[0];
        day = parsedDate[1];
        year = parsedDate[2];

    }

    public int getMonth () {
        return month;
    }

    public int getDay () {
        return day;
    }

    public int getYear () {
        return year;
    }

    public static boolean validMonthDayYearTriplet (int[] parsedDate) {
        int month = parsedDate[0];
        int day = parsedDate[1];
        int year = parsedDate[2];
        if (month < 1 || month > 12 || year < 1 || year > 2023) {
            return false;
        }
                            //JA,FE,MA,AP,MA,JN,JL,AU,SE,OC,NO,DE
        int[] daysInMonths = {31,28,31,30,31,30,31,31,30,31,30,31};
        return day <= daysInMonths[month - 1] && day >= 1;
    }
    public String toString () {
        return String.format("%02d/%02d/%d",month,day,year);
    }
}
