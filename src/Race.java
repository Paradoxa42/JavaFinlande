import java.util.HashMap;

//The Race of a character
public class Race {
    private int id = 0;
    private String name = new String();
    private caracSet set;
    private String capacityName = new String();
    private String capacity = new String();

    //Default constructor
    public Race() {

    }

    //Getter and setter of ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Getter and setter of Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getter and setter of the set of bonus and malus on caracs. The set can be set with a caracSet and a JSON
    public void setSet(caracSet set) {
        this.set = set;
    }

    public void setSet(String json_set) {
        this.set = new caracSet(json_set);
    }

    public caracSet getSet() {
        return set;
    }

    public String getCapacity() {
        return capacity;
    }

    //Getter and setter of the discription of the Capacity
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    //Getter and setter of Capacity name
    public String getCapacityName() {
        return capacityName;
    }

    public void setCapacityName(String capacityName) {
        this.capacityName = capacityName;
    }

    //Return the name of the Race
    @Override
    public String toString() {
        return this.getName();
    }
}
