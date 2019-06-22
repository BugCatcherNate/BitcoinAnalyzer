package database;

import org.sqlite.JDBC;
import fetchers.ParseURL;

import java.sql.*;

/**
 *
 * @author sqlitetutorial.net
 */
public class Sqlite {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/home/nate/bitcoin.db";
        Connection conn = null;

        try {
            DriverManager.registerDriver(new JDBC());
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void get(){

        String sql = "select * from bitcoin";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql))
            ResultSet rs    = pstmt.executeQuery(sql)){

                // loop through the result set
                while (rs.next()) {
                    System.out.println(rs.getInt("id") +  "\t" +
                            rs.getString("name") + "\t" +
                            rs.getDouble("capacity"));
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insert(String name, double capacity) {
        String sql = "INSERT INTO bitcoin(date,rate) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {

        Sqlite app = new Sqlite();
        // insert three new rows
        app.insert("Raw Materials", 3000);
        app.insert("Semifinished Goods", 4000);
        app.insert("Finished Goods", 5000);
    }
    */

}
