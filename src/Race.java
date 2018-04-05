import java.util.HashMap;

public class Race {
    private int id = 0;
    private String name = new String();
    private caracSet set;
    private String capacityName = new String();
    private String capacity = new String();

    public Race() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCapacityName() {
        return capacityName;
    }

    public void setCapacityName(String capacityName) {
        this.capacityName = capacityName;
    }

}
