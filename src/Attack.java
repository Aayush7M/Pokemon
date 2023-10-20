public class Attack {
    String name;
    String description;
    String damage;
    public Attack (String name, String description, String damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
    }
    public void setName (String name) {
        this.name = name;
    }
    public void setDescription (String description) {
        this.description = description;
    }
    public void setDamage (String damage) {
        this.damage = damage;
    }
    public String toString () {
        return String.format("Name: %s%nDescription: %s%nDamage: %s%n",name,description,damage);
    }
}
