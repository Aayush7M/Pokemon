import java.util.ArrayList;

public class Album implements Comparable <Album> {
    int albumNum;
    ArrayList <Card> cards;
    ArrayList <Card> cardsSortedByName;
    ArrayList <Card> cardsSortedByHP;
    ArrayList <Card> cardsSortedByDate;
    int maxCapacity;
    Date date;
    int HP;
    static int totalNumOfCards;
    static int totalCapacity;
    static int totalHP;

    public Album (ArrayList <Card> cards, int maxCapacity, Date date) {
        this.cards = cards;
        this.maxCapacity = maxCapacity;
        this.date = date;
        for (Card card : cards) {
            this.HP += card.getHP();
        }
        totalHP += HP;
        totalNumOfCards+=cards.size();
        totalCapacity+=maxCapacity;
    }
    public Album (int albumNum) {
        this.albumNum = albumNum;
    }
    public String averageHP () { // average HP of THIS ALBUM
        return ("Average HP: " + ((double) HP /cards.size()));
    }
    public static String averageHPOfCollection () {
        return ("Average HP: " + ((double) totalHP /totalNumOfCards));
    }
    // The total number of cards out of the max capacity of this collection.
    public static String cardsOutOfCapacityCollection () {
        return (totalNumOfCards + " cards out of " + totalCapacity);
    }
    public String cardsOutOfCapacity () { // cards inside this album as compared to max capacity of this album.
        return (cards.size() + " cards out of " + maxCapacity);
    }
    public void printAllCards () {
        for (Card card : cards) {
            System.out.println(card + "\n");
        }
    }
    public void printCard () {

    }
    public boolean isCardInAlbum(String s) {

    }
    public void addCard (Card c) {

    }
    public void removeCard (Card c) {

    }
    public void removeCard (int index) {

    }
    public boolean isAttackInCard (String s) {

    }
    public ArrayList <Card> sortAlbum (String sortBy) {

    }
    public int compareTo (Album a) {
        return (this.albumNum - a.albumNum);
    }
    public String toString () {
        return String.format("Album Number: %d%n" +
                "Date: %s%n" +
                "Max Capacity: %d%n" +
                "Number of Cards: %d%n" +
                "Total HP: %d%n", albumNum, date, maxCapacity, cards.size(), HP);
    }

}
