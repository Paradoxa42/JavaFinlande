import java.util.Vector;

//Characters for the "Chronique oubliee" Roleplaying game
public class Character {

    private int id = 0;
    private caracSet set;
    private String name = "default";
    private Race race = null;
    private Profile profile = null;
    private int health = 0;
    private int level = 0;
    private String equipement = ".";
    private Vector<Path> paths = new Vector<Path>();

    //Constructor by default
    public Character() {
        this.set = new caracSet(10,10,10,10,10,10);
    }

    //Constructor where you provide all the attributs
    public Character(int _str, int _dex, int _con, int _intel, int _wis, int _cha, String _name, Race _race, Profile _profile, int _level, String _equipement) {
        this.set = new caracSet(_str, _dex, _con, _intel, _wis, _cha);
        this.name = _name;
        this.race = _race;
        this.profile = _profile;
        this.level = _level;
        this.equipement = _equipement;
        this.health = this.profile.calculateHealth(this.health);
    }

    //Path getter and setter
    public Vector<Path> getPaths() {
        return paths;
    }

    public void setPaths(Vector<Path> paths) {
        this.paths = paths;
    }

    //Add Path to the paths Vector
    public void addPath(Path path) {
        this.paths.add(path);
    }

    //Remove Path from path vector by position
    public void removePath(int pos) {
        paths.remove(pos);
    }

    //Getter and setter ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Getter and setter Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getter and setter Level
    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    //Getter and setter Health
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //Getter and setter Profile
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    //Getter and setter Race, when race set the carac are added
    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
        this.set.add(this.race.getSet());
    }

    //Getter and setter Equipement
    public String getEquipement() {
        return equipement;
    }

    public void setEquipement(String equipement) {
        this.equipement = equipement;
    }

    public caracSet getSet() {
        return set;
    }

    public void setSet(caracSet set) {
        this.set = set;
    }

    //Return the name of the character
    @Override
    public String toString() {
        return this.name;
    }
}
