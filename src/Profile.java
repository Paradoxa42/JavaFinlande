import org.json.JSONArray;

import java.util.Vector;

public class Profile {

    private int id = 0;
    private String name = "";
    private int hDice = 6;
    private String startEquipement = "Nothing";
    private Vector<Integer> path = new Vector<Integer>();
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

    public Vector<Integer> getPath() {
        return path;
    }

    public JSONArray getPath_json() {
        return path_json;
    }

    public void setPath(String json_path) {
        this.path_json = new JSONArray(json_path);
        for (int i = 0; i < this.path_json.length(); i++) {
            this.path.add(this.path_json.getInt(i));
        }
    }

    public int calculateHealth (int level) {
        return level * this.hDice;
    }


}
