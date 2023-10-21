import java.util.ArrayList;
import java.util.Collections;

public class Album implements Comparable <Album> {
    private int albumNum;
    private ArrayList <Card> cards;
    private int maxCapacity;
    private Date date;
    private int albumHP;
    private static int totalNumOfCards;
    private static int totalCapacity;
    private static int totalHP;

    public Album (ArrayList <Card> cards, int maxCapacity, Date date) {
        this.cards = cards;
        this.maxCapacity = maxCapacity;
        this.date = date;
        for (Card card : cards) {
            this.albumHP += card.getHP();
        }
        totalHP += albumHP;
        totalNumOfCards+=cards.size();
        totalCapacity+=maxCapacity;
    }
    public Album (int albumNum) {
        this.albumNum = albumNum;
    }
    public String averageHP () { // average HP of THIS ALBUM
        return ("Average HP: " + ((double) albumHP /cards.size()));
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
    public void printNameDateAllCards () {
        for (int i = 0 ; i < cards.size() ; i++) {
            System.out.println((i+1) + ": ");
            System.out.println(cards.get(i).nameDateToString() + "\n");
        }
    }
    public ArrayList <Card> getCards() {
        return cards;
    }
    public void addCard (Card c) {
        cards.add(c);
        albumHP += c.getHP();
        totalHP += albumHP;
        totalNumOfCards++;
        Collections.sort(cards);
    }
    public void sortCardsByName () {
        Collections.sort(cards);
    }
    public void sortCardsByHP () {
        cards.sort(new SortByHP());
    }
    public void sortCardsByDate () {
        cards.sort(new SortByDate());
    }
    public void removeCard (int index) {
        cards.remove(index);
    }
    public int findCardGivenName (String name) {
        return Collections.binarySearch(cards, new Card(name));
    }
    public int compareTo (Album a) {
        return (this.albumNum - a.albumNum);
    }
    public String toString () {
        return String.format("Album Number: %d%n" +
                "Date: %s%n" +
                "Max Capacity: %d%n" +
                "Number of Cards: %d%n" +
                "Total HP: %d%n", albumNum, date, maxCapacity, cards.size(), albumHP);
    }
    public int getCardsSize () {
        return cards.size();
    }
    public boolean atMaxCapacity () {
        return cards.size() == maxCapacity;
    }
    public int findCardGivenHP (int hp) {
        return Collections.binarySearch(cards, new Card (hp), new SortByHP());
    }
}
