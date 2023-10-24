import java.util.ArrayList;
import java.util.Collections;

public class Album implements Comparable <Album> {
    // instance variables
    private final int albumNum;
    private ArrayList <Card> cards;
    private int maxCapacity;
    private final Date date;
    private int albumHP;

    // static variables
    private static int totalNumOfCards;
    private static int totalCapacity;
    private static int totalHP;

    // constructors
    public Album (int albumNum, ArrayList <Card> cards, int maxCapacity, Date date) {
        this.albumNum = albumNum;
        this.cards = cards;
        this.maxCapacity = maxCapacity;
        this.date = date;
        for (Card card : cards) {
            this.albumHP += card.getHP();
        }
        totalHP += albumHP;
        totalNumOfCards += cards.size();
        totalCapacity += maxCapacity;
    }

    public Album (int albumNum, Date date) {
        this.albumNum = albumNum;
        this.date = date;
    }

    // getters
    public Date getDate () {
        return date;
    }
    public ArrayList <Card> getCards () {
        return cards;
    }

    // methods
    public String averageHP () { // average HP of THIS ALBUM
        return ("Average HP: " + ((double) albumHP / cards.size()));
    }
    public static String averageHPOfCollection () {
        return ("Average HP: " + ((double) totalHP / totalNumOfCards));
    }

    public String cardsOutOfCapacity () { // cards inside this album as compared to max capacity of this album.
        return (cards.size() + " cards out of " + maxCapacity);
    }
    public static String cardsOutOfCapacityCollection () {
        return (totalNumOfCards + " cards out of " + totalCapacity);
    }

    public void printNameDateAllCards () {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println((i + 1) + ": ");
            System.out.println(cards.get(i).nameDateToString() + "\n");
        }
    }

    public void printAllInfoAllCards () {
        for (Card card : cards) {
            System.out.println(card + "\n");
        }
    }

    public void addCard (Card c) {
        cards.add(c);
        albumHP += c.getHP();
        totalHP += albumHP;
        totalNumOfCards++;
    }
    public void removeCard (int index) {
        totalNumOfCards--;
        int thisCardHP = cards.get(index).getHP();
        totalHP-=thisCardHP;
        albumHP-=thisCardHP;
        cards.remove(index);

    }

    public void sortCardsByName () {
        Collections.sort(cards);
    }

    public void sortCardsByHP () {
        cards.sort(new SortCardsByHPNameDate());
    }

    public void sortCardsByDate () {
        cards.sort(new SortCardsByDateNameHP());
    }

    public int getCardIndexOfName (String name) {
        return cards.indexOf(new Card(name));
    }
    public int getCardIndexOfHP (int hp) {
        return cards.indexOf(new Card(hp));
    }

    public Card getCard (int index) {
        return cards.get(index);
    }

    public int getCardsSize () {
        return cards.size();
    }

    public boolean atMaxCapacity () {
        return cards.size() == maxCapacity;
    }

    //comparable
    public int compareTo (Album a) {
        return (this.albumNum - a.albumNum);
    }

    // to string methods
    public String toString () {
        return String.format("Album Number: %d%n" + "Date: %s%n" + "Max Capacity: %d%n" + "Number of Cards: %d%n" + "Total HP: %d%n", albumNum, date, maxCapacity, cards.size(), albumHP);
    }

    public String nameDateToString () {
        return String.format("Album Number: %d%nDate: %s%n", albumNum, date);
    }

    // equals method
    public boolean equals (Object o) {
        if (!(o instanceof Album a)) {
            return false;
        }
        return this.date.equals(a.date) || this.albumNum == a.albumNum;

    }
}
