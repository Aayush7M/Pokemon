public class Attack implements Comparable <Attack>{
    private String name;
    private String description;
    private String damage;
    public Attack (String name, String description, String damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
    }
    public String getName () {
        return name;
    }
    public String toString () {
        return String.format("Name: %s%nDescription: %s%nDamage: %s%n",name,description,damage);
    }
    public int compareTo (Attack a) {
        return this.name.compareToIgnoreCase(a.name);
    }
    public void edit (String attributeToChange, String changeTo) {
        if (attributeToChange.equals("name")) {
            this.name = changeTo;
        } else if (attributeToChange.equals("description")) {
            this.description = changeTo;
        } else { // damage
            this.damage = changeTo;
        }
    }
}
