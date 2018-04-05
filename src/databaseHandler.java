import java.sql.*;
import java.util.List;
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
                String query_str = "SELECT name, attributs, capacity FROM cooRace WHERE id = " + id;
                ResultSet query_res = query_stmt.executeQuery(query_str);
                Race new_race = new Race();
                while (query_res.next()) {
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
            String query_str = "SELECT name, attributs, capacity FROM cooRace";
            ResultSet query_res = query_stmt.executeQuery(query_str);
            Vector<Race> new_race = new Vector<Race>();
            while (query_res.next()) {
                Race race_tmp = new Race();
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
            String query_string = "SELECT name, hDice, startEquipement, paths FROM Profile WHERE id = " + id;
            ResultSet query_res = query_stmt.executeQuery(query_string);
            Profile new_profile = new Profile();
            while (query_res.next()) {
                new_profile.setName(query_res.getString("name"));
                new_profile.sethDice(query_res.getInt("hDice"));
                new_profile.setStartEquipement(query_res.getString("startEquipement"));
                new_profile.setPath(query_res.getString("paths"));
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
            String query_string = "SELECT name, hDice, startEquipement, paths FROM Profile";
            ResultSet query_res = query_stmt.executeQuery(query_string);
            Vector<Profile> new_profiles = new Vector<Profile>();
            while (query_res.next()) {
                Profile new_profile = new Profile();
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
}
