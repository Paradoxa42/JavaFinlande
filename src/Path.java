import org.json.JSONArray;

import java.util.Vector;

//Path of a character, provide him powers
public class Path {
    private int id = 0;
    private String name = "";
    private int level = 0;
    private int idClass = -1;
    private int idRace = -1;
    private Vector<String> powers = new Vector<String>();

    //Constructor by default
    public Path() {

    }

    //Getter and setter of the name
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Getter and setter of the id of the Race who give access to the path
    public int getIdClass() {
        return idClass;
    }

    public int getIdRace() {
        return idRace;
    }

    //Getter and setter of the id of the Class who give access to the path
    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public void setIdRace(int idRace) {
        this.idRace = idRace;
    }

    //Getter and setter of the id
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    //Getter and setter of the level of the path
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    //Add a power to the path
    public void addPower(String power) {
        this.powers.add(power);
    }

    //Getter and Setter of the powers
    public Vector<String> getPowers() {
        return powers;
    }

    public void setPowers(Vector<String> powers) {
        this.powers = powers;
    }

    //Return the name of the path
    @Override
    public String toString() {
        return this.getName();
    }
}
