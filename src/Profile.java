import org.json.JSONArray;

import java.util.Vector;

public class Profile {

    private String name = "";
    private int hDice = 6;
    private String startEquipement = "Nothing";
    private Vector<Number> path = new Vector<Number>();
    private JSONArray path_json;

    public Profile() {
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

    public Vector<Number> getPath() {
        return path;
    }

    public JSONArray getPath_json() {
        return path_json;
    }

    public void setPath(String json_path) {
        JSONArray json_tmp = new JSONArray(json_path);
        this.path_json = json_tmp;
    }
}
