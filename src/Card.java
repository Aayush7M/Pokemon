import java.util.Arrays;
import java.util.Collections;

public class Card implements Comparable <Card> {
    String name;
    int HP;
    String type;
    Date date;
    Attack[] attacks;

    public String getName () {
        return name;
    }

    public int getHP () {
        return HP;
    }

    public String getType () {
        return type;
    }

    public Date getDate () {
        return date;
    }

    public Attack[] getAttacks () {
        return attacks;
    }

    public String nameDateToString () {
        return String.format ("Name: %s%nDate: %s%n",name,date);
    }
    public String toString() {
        StringBuilder returnString = new StringBuilder(String.format("Name: %s%nHP: %d%nType: %s%nDate: %s%nAttacks: %n", name, HP, type, date));
        for (Attack attack : attacks) {
            returnString.append(attack.toString()).append("\n");
        }
        return returnString.toString();
    }
    public Card (String name, int HP, String type, Date date, Attack[] attacks) {
        this.name = name;
        this.HP = HP;
        this.type = type;
        this.date = date;
        this.attacks = attacks;
    }
    public Card (String name) {
        this.name = name;
    }
    public Card (int HP) {
        this.HP = HP;
    }
    public int compareTo (Card c) {
        int compareResult;
        if ((compareResult = this.name.compareToIgnoreCase(c.name)) == 0) {
            return this.HP-c.getHP();
        } else {
            return compareResult;
        }
    }

    public void sortAttacks () {
        Arrays.sort(attacks);
    }
}
