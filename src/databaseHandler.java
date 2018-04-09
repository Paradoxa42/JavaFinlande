    import org.json.JSONArray;

    import java.sql.*;
import java.util.Vector;

public class databaseHandler {
    private Connection connection;

    public databaseHandler() {
        String className = "com.mysql.jdbc.Driver";
        try {
            Class.forName(className).newInstance();
        } catch(ClassNotFoundException ex) {
            System.out.println("Error : SQL driver " + className + " not found");
        } catch (InstantiationException ex) {
            System.out.println("Error : SQL driver " + className + " instanciation error");
        } catch (IllegalAccessException ex) {
            System.out.println("Error : SQL driver " + className + " illegal access");
        }
        String serverName = "localhost";
        String mydatabase = "cooCharacterBuilder";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useSSL=false";

        String username = "root";
        String password = "dfghj";
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("unable to connect to database : " + ex.getMessage());
        }
    }

    public void finalize() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            System.out.println("Error SQL : disconection error");
        }
    }

    //GET Race by ID
    public Race getRace(int id) {
        try {
                Statement query_stmt = this.connection.createStatement();
                String query_str = "SELECT id, name, attributs, capacity FROM cooRace WHERE id = " + id;
                ResultSet query_res = query_stmt.executeQuery(query_str);
                Race new_race = new Race();
                while (query_res.next()) {
                    new_race.setId(query_res.getInt("id"));
                    new_race.setName(query_res.getString("name"));
                    new_race.setCapacity(query_res.getString("capacity"));
                    new_race.setSet(query_res.getString("attributs"));
                }
                return new_race;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return null;
        }
    }

    //GET all Races
    public Vector<Race> getRaces() {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "SELECT id, name, attributs, capacity FROM cooRace";
            ResultSet query_res = query_stmt.executeQuery(query_str);
            Vector<Race> new_race = new Vector<Race>();
            while (query_res.next()) {
                Race race_tmp = new Race();
                race_tmp.setId(query_res.getInt("id"));
                race_tmp.setName(query_res.getString("name"));
                race_tmp.setCapacity(query_res.getString("capacity"));
                race_tmp.setSet(query_res.getString("attributs"));
                new_race.add(race_tmp);
            }
            return new_race;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return null;
        }
    }

    //POST new Race
    public boolean postRace(Race new_race) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "INSERT INTO cooRace (id, name, attributs, capacity) VALUES (NULL, '" + new_race.getName() + "', '" + new_race.getSet().toJSON() + "', '" + new_race.getCapacity() + "');";
            query_stmt.execute(query_str);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return false;
        }
    }

    //GET Profile by ID
    public Profile getProfile(int id) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_string = "SELECT id, name, hDice, startEquipement, paths FROM Profile WHERE id = " + id;
            ResultSet query_res = query_stmt.executeQuery(query_string);
            Profile new_profile = new Profile();
            while (query_res.next()) {
                new_profile.setId(query_res.getInt("id"));
                new_profile.setName(query_res.getString("name"));
                new_profile.sethDice(query_res.getInt("hDice"));
                new_profile.setStartEquipement(query_res.getString("startEquipement"));
                JSONArray path_json = new JSONArray(query_res.getString("paths"));
                for (int i = 0; i < path_json.length(); i++) {
                    new_profile.addPath(this.getPath(path_json.getInt(i)));
                }
            }
            return new_profile;
        } catch(SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return null;
        }
    }

    //GET Profiles
    public Vector<Profile> getProfiles() {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_string = "SELECT id, name, hDice, startEquipement, paths FROM Profile";
            ResultSet query_res = query_stmt.executeQuery(query_string);
            Vector<Profile> new_profiles = new Vector<Profile>();
            while (query_res.next()) {
                Profile new_profile = new Profile();
                new_profile.setId(query_res.getInt("id"));
                new_profile.setName(query_res.getString("name"));
                new_profile.sethDice(query_res.getInt("hDice"));
                new_profile.setStartEquipement(query_res.getString("startEquipement"));
                new_profile.setPath(query_res.getString("paths"));
                new_profiles.add(new_profile);
            }
            return new_profiles;
        } catch(SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return null;
        }
    }

    //POST Profile
    public boolean postProfile(Profile new_profile) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "INSERT INTO `Profile` (`id`, `name`, `hDice`, `startEquipement`, `paths`) VALUES (NULL, '" + new_profile.getName() + "', '" + new_profile.gethDice() + "', '" + new_profile.getStartEquipement() + "', '" + new_profile.getPath_json().toString() + "');";
            query_stmt.execute(query_str);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return false;
        }
    }

    //GET Character by ID
    public Character getCharacter(int id) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "SELECT * FROM cooCharacter WHERE id = " + id;
            ResultSet query_res = query_stmt.executeQuery(query_str);
            Character new_character = new Character();
            while (query_res.next()) {
                new_character.setId(query_res.getInt("id"));
                new_character.setName(query_res.getString("name"));
                new_character.setHealth(query_res.getInt("health"));
                new_character.setLevel(query_res.getInt("level"));
                new_character.setRace(this.getRace(query_res.getInt("race")));
                new_character.setProfile(this.getProfile(query_res.getInt("profile")));
                new_character.setEquipement(query_res.getString("equipement"));
                new_character.setPaths(this.getCharacterPath(new_character.getId()));
            }
            return new_character;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return null;
        }
    }

    //GET Entity ID By Name (Obviously work with only sql entity who has a name field)
    public int getEntityIDByName(String name, String EntityName) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "SELECT id FROM " + EntityName + " WHERE name LIKE '" + name + "'";
            ResultSet query_res = query_stmt.executeQuery(query_str);
            if (query_res.next()) {
                return query_res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return -1;
        }
    }


    //GET Characters
    public Vector<Character> getCharacters() {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "SELECT * FROM cooCharacter";
            ResultSet query_res = query_stmt.executeQuery(query_str);
            Vector<Character> new_characters = new Vector<Character>();
            while (query_res.next()) {
                Character new_character = new Character();
                new_character.setId(query_res.getInt("id"));
                new_character.setName(query_res.getString("name"));
                new_character.setHealth(query_res.getInt("health"));
                new_character.setLevel(query_res.getInt("level"));
                new_character.setRace(this.getRace(query_res.getInt("race")));
                new_character.setProfile(this.getProfile(query_res.getInt("profile")));
                new_character.setEquipement(query_res.getString("equipement"));
                new_character.setPaths(this.getCharacterPath(new_character.getId()));
                new_characters.add(new_character);
            }
            return new_characters;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return null;
        }
    }

    //POST character
    public Character postCharacter(Character character) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "INSERT INTO cooCharacter (id, name, carac, race, profile, health, level, equipement) VALUES (NULL, '" + character.getName() + "', '" + character.getSet().toString() + "', '" + character.getRace().getId() + "', '" + character.getProfile().getId() + "', '" + character.getHealth() + "', '" + character.getLevel() + "', '" + character.getEquipement() + "');";
            query_stmt.execute(query_str);
            character.setId(this.getEntityIDByName(character.getName(), "character"));
            this.postCharacterPaths(character.getId(), character.getPaths());
            return character;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return character;
        }
    }

    //PUT character
    public boolean putCharacter(Character character) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "UPDATE cooCharacter SET name = " + character.getName() + ", carac = " + character.getSet().toString() + ", race = " + character.getRace().getId() + ", profile = " + character.getProfile().getId() + ", health = " + character.getHealth() + ", level = " + character.getLevel() + ", equipement = " + character.getEquipement() + " WHERE id = " + character.getId();
            query_stmt.execute(query_str);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return false;
        }
    }

    //DELETE character
    public boolean deleteCharacter(Character character) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "DELETE FROM cooCharacter WHERE id = " + character.getId();
            query_stmt.execute(query_str);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return false;
        }
    }

    //GET path from ID
    public Path getPath(int id) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "SELECT * FROM path WHERE id = " + id;
            ResultSet query_res = query_stmt.executeQuery(query_str);
            Path path = new Path();
            while (query_res.next()) {
                path.setId(query_res.getInt("id"));
                path.setLevel(0);
                Vector<String> powers = new Vector<String>();
                powers.add(query_res.getString("powerOne"));
                powers.add(query_res.getString("powerTwo"));
                powers.add(query_res.getString("powerThree"));
                powers.add(query_res.getString("powerFour"));
                powers.add(query_res.getString("powerFive"));
                path.setPowers(powers);
            }
            return path;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return null;
        }
    }

    public Vector<Path> getCharacterPath(int id) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "SELECT * FROM path_character WHERE idCharacter = " + id;
            ResultSet query_res = query_stmt.executeQuery(query_str);
            Vector<Path>  paths = new Vector<Path>();
            while (query_res.next()) {
                Path new_path = this.getPath(query_res.getInt("idPath"));
                new_path.setLevel(query_res.getInt("level"));
                paths.add(new_path);
            }
            return paths;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return null;
        }
    }

    //POST path
    public boolean postPath(Path path) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "INSERT INTO path (id, name, idClass, idRace, powerOne, powerTwo, powerThree, powerFour, powerFive) VALUE (NULL, '" + path.getName() + "', '" + path.getIdClass() + "', '" + path.getIdRace() + "', " + path.getPowers().get(0) + ", " + path.getPowers().get(1) + ", " + path.getPowers().get(2) + ", " + path.getPowers().get(3) + ", " + path.getPowers().get(4) + ")";
            query_stmt.execute(query_str);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return false;
        }
    }

    //POST Character path
    public boolean postCharacterPath(int id, Path path) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "INSERT INTO path_character (id, idCharacter, idPath, level) VALUE (NULL, '" + id + "', '" + path.getId() + "', '" + 0 + "')";
            query_stmt.execute(query_str);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
            return false;
        }
    }

    //PUT Character path level
    public void putCharacterPathLevel(int idCharacter, int idPath, int level) {
        try {
            Statement query_stmt = this.connection.createStatement();
            String query_str = "UPDATE path_character SET level = '" + level + "' WHERE idCharacter = " + idCharacter + " AND idPath = " + idPath;
            query_stmt.execute(query_str);
        } catch (SQLException ex) {
            System.out.println("Error SQL : " + ex.getMessage());
        }
    }

    //POST Character paths
    public void postCharacterPaths(int id, Vector<Path> paths) {
        int i = 0;
        while (i < paths.size()) {
            this.postCharacterPath(id, paths.get(i));
            i++;
        }
    }
}
