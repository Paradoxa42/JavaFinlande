import org.json.JSONArray;

import java.util.Vector;

public class Profile {

    private int id = 0;
    private String name = "";
    private int hDice = 6;
    private String startEquipement = "Nothing";
    private Vector<Path> paths = new Vector<Path>();
    private JSONArray path_json;

    public Profile() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int gethDice() {
        return hDice;
    }

    public void sethDice(int hDice) {
        this.hDice = hDice;
    }

    public String getStartEquipement() {
        return startEquipement;
    }

    public void setStartEquipement(String startEquipement) {
        this.startEquipement = startEquipement;
    }

    public Vector<Path> getPaths() {
        return paths;
    }

    public void addPath (Path path) {
        this.paths.add(path);
    }

    public JSONArray getPath_json() {
        return path_json;
    }

    public int calculateHealth (int level) {
        return level * this.hDice;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
