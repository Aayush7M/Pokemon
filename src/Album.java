import java.util.ArrayList;

public class Album {
    ArrayList <Card> cards;
    ArrayList <Card> cardsSortedByName;
    ArrayList <Card> cardsSortedByHP;
    ArrayList <Card> cardsSortedByDate;
    int maxCapacity;
    Date date;
    int totalHP;
    boolean lastCard;
    static int totalNumOfCards;

    public Album (ArrayList <Card> cards, int maxCapacity, Date date, int totalHP, boolean lastCard) {
        this.cards = cards;
        this.maxCapacity = maxCapacity;
        this.date = date;
        this.totalHP = totalHP;
        this.lastCard = lastCard;
        totalNumOfCards++;
    }

    public String toString () {

    }
    public double averageHP () {

    }
    public void printAllCards () {

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

}
