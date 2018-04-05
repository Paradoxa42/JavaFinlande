import org.json.JSONArray;

import java.util.Vector;

public class Path {
    private int id = 0;
    private String name = "";
    private int level = 0;
    private int idClass = -1;
    private int idRace = -1;
    private Vector<String> powers = new Vector<String>();

    public Path() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIdClass() {
        return idClass;
    }

    public int getIdRace() {
        return idRace;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public void setIdRace(int idRace) {
        this.idRace = idRace;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addPower(String power) {
        this.powers.add(power);
    }

    public Vector<String> getPowers() {
        return powers;
    }

    public void setPowers(Vector<String> powers) {
        this.powers = powers;
    }
}
