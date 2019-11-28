package control;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Exercise;
import model.User;
import view.mainView;

public class DDBBConection {

    public static Connection con;
    public static DatabaseMetaData dbmd;

    public boolean connect() {
        try {
            DDBBConection.con = DriverManager.getConnection("jdbc:sqlite:Base de datos GS1.db");

            DDBBConection.dbmd = con.getMetaData();
            return true;

        } catch (SQLException ex) {
            System.out.println("[ERROR]: " + ex);
        }
        return false;
    }

    public void closeConnection() {
        if (DDBBConection.con != null) {
            try {
                DDBBConection.con.close();
                DDBBConection.con = null;
            } catch (SQLException ex) {
                Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public static void addUser(String name, String lastname, int age, double weight, double height, String genre, String mail, String rol, String password) throws SQLException {
        String sql = "INSERT INTO User(name, lastname, age, weight, height, genre, mail, rol, passwordkey) VALUES (?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, lastname);
        ps.setInt(3, age);
        if (weight > 0.0) {
            ps.setDouble(4, weight);
        } else {
            ps.setNull(4, java.sql.Types.NULL);
        }
        if (height > 0.0) {
            ps.setDouble(5, height);
        } else {
            ps.setNull(5, java.sql.Types.NULL);
        }
        ps.setString(6, genre);
        ps.setString(7, mail);
        ps.setString(8, rol);
        ps.setString(9, password);
        ps.executeUpdate();
        ps.close();

    }

    public void deleteUserByMail(String mail) {
        String sql = "DELETE FROM User WHERE Mail=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mail);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DDBBConection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public User getUserByMail(String mail) {
        String sql = "SELECT * FROM User WHERE Mail=\"" + mail + "\"";
        User u = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                u = new User(rs.getString("name"), rs.getString("lastname"), rs.getInt("age"),
                        rs.getFloat("weight"), rs.getFloat("height"), rs.getString("genre"),
                        rs.getString("mail"), rs.getString("rol"), rs.getString("passwordkey"));
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DDBBConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public static void addExercise(String title, String description, String category, String owner) throws SQLException{
        String sql = "INSERT INTO Exercise(Title, Description, Category, Owner) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, description);
            ps.setString(3, category);
            ps.setString(4, owner);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DDBBConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Exercise getExeciseByTitle(String title) {
        String sql = "SELECT * FROM Exercise WHERE Title=\"" + title + "\"";
        Exercise e = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                e = new Exercise(rs.getString("title"), rs.getString("description"), rs.getString("category"), rs.getString("owner"));
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DDBBConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public void deleteExerciseTitle(String title) {
        String sql = "DELETE FROM Exercise WHERE Title=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DDBBConection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public List<String> getTables() {
        List<String> tablas = new ArrayList<>();
        try {
            String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables(null, null, "%", types);
            while (rs.next()) {
                String nombreTabla = rs.getString("TABLE_NAME");
                //System.out.println("Tabla: " + nombreTabla);
                tablas.add(nombreTabla);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tablas;
    }

    public List<String> getColumnsByTable(String tabla) {
        List<String> columnas = new ArrayList<>();
        try {
            ResultSet rs = dbmd.getColumns(null, null, tabla, null);
            while (rs.next()) {
                String nombreCampo = rs.getString("COLUMN_NAME");
                //System.out.println("   Campo: " + nombreCampo);
                columnas.add(tabla + "." + nombreCampo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columnas;
    }

}
