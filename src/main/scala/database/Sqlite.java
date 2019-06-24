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
        String url = "jdbc:sqlite:/home/nathan/databases/bitcoin.db";
        Connection conn = null;

        try {
            DriverManager.registerDriver(new JDBC());
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * Insert a new row into the warehouses table
     *
     * @param date
     * @param rate
     */
    public void insert(long date, float rate) {
        String sql = "INSERT INTO bitcoinprice(time,price) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, date);
            pstmt.setFloat(2, rate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}
