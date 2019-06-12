package Models;

import java.sql.*;

public class UserModel {

    String dbName;

    public UserModel(String dbName) {
        this.dbName = dbName;
    }

    public boolean isEmailExist(String email){
        String selectStatement = "Select * from Users where email = ?";
        String url = "jdbc:sqlite:" + this.dbName + ".db";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(selectStatement)) {
            // set the corresponding param
            pstmt.setString(1, email);
            ResultSet rs  = pstmt.executeQuery();
            if (rs.next()){
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean isUsernameExits(String username){
        String selectStatement = "Select * from Users where userName = ?";
        String url = "jdbc:sqlite:" + this.dbName + ".db";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(selectStatement)) {
            // set the corresponding param
            pstmt.setString(1, username);
            ResultSet rs  = pstmt.executeQuery();
            if (rs.next()){
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void insertUser(){

    }

}
