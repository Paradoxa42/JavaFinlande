import java.util.Vector;

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

    public Character() {
        this.set = new caracSet(10,10,10,10,10,10);
    }

    public Character(int _str, int _dex, int _con, int _intel, int _wis, int _cha, String _name, Race _race, Profile _profile, int _level, String _equipement) {
        this.set = new caracSet(_str, _dex, _con, _intel, _wis, _cha);
        this.name = _name;
        this.race = _race;
        this.profile = _profile;
        this.level = _level;
        this.equipement = _equipement;
        this.health = this.profile.calculateHealth(this.health);
    }

    public Vector<Path> getPaths() {
        return paths;
    }

    public void addPath(Path path) {
        this.paths.add(path);
    }

    public void removePath(int pos) {
        paths.remove(pos);
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

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public Profile getProfile() {
        return profile;
    }

    public Race getRace() {
        return race;
    }

    public String getEquipement() {
        return equipement;
    }

    public void setEquipement(String equipement) {
        this.equipement = equipement;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void setRace(Race race) {
        this.race = race;
        this.set.add(this.race.getSet());
    }

    public caracSet getSet() {
        return set;
    }

    public void setSet(caracSet set) {
        this.set = set;
    }

    public void setPaths(Vector<Path> paths) {
        this.paths = paths;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
