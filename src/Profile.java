import org.json.JSONArray;

import java.util.Vector;

//The Profile of a character
public class Profile {

    private int id = 0;
    private String name = "";
    private int hDice = 6;
    private String startEquipement = "Nothing";
    private Vector<Path> paths = new Vector<Path>();
    private JSONArray path_json;

    //Default constructor
    public Profile() {
    }

    //Getter and Setter ID
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    //Getter and Setter name
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //Getter and Setter hDice
    public int gethDice() {
        return hDice;
    }

    public void sethDice(int hDice) {
        this.hDice = hDice;
    }

    //Getter and Setter Equipement
    public String getStartEquipement() {
        return startEquipement;
    }

    public void setStartEquipement(String startEquipement) {
        this.startEquipement = startEquipement;
    }

    //Getter and Setter Path
    public Vector<Path> getPaths() {
        return paths;
    }

    public void addPath (Path path) {
        this.paths.add(path);
    }

    //Get a JSON with the ID of all the path
    public JSONArray getPath_json() {
        return path_json;
    }

    //Calculate the Health of the character based on it's level and the hDice of the Profile
    public int calculateHealth (int level) {
        return level * this.hDice;
    }

    //Return the name of the Profile
    @Override
    public String toString() {
        return this.getName();
    }
}
