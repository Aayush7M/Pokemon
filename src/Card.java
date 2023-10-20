import java.util.Arrays;

public class Card implements Comparable <Card> {
    String name;
    int HP;
    String type;
    Date date;
    Attack[] attacks;

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

    }
    public void changeAttack (int indexOfAttack, String attributeToChange, String changeTo) {
        if (attributeToChange.equals("name")) {
            attacks[indexOfAttack].setName(changeTo);
        } else if (attributeToChange.equals("description")) {
            attacks[indexOfAttack].setDescription(changeTo);
        } else { // damage
            attacks[indexOfAttack].setDamage(changeTo);
        }
    }
}
