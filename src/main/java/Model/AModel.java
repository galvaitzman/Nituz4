package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AModel {

    protected static User current_user;

    protected Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:avoda4DB.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<String> getAllCategories(){
        String sql = "SELECT * from Categories";
        List<String> catDerails = new ArrayList<>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)){
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next())
            {
                for (int col=1; col <= colCount; col++)
                {
                    Object value = rs.getObject(col);
                    if (value != null)
                    {
                        catDerails.add(value.toString());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(!catDerails.isEmpty())
            return catDerails;
        return null;
    }


    public List<String> getAllOrganization(){
        String sql = "SELECT * from Organizations";
        List<String> orgDetails = new ArrayList<>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)){
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next())
            {
                for (int col=1; col <= colCount; col++)
                {
                    Object value = rs.getObject(col);
                    if (value != null)
                    {
                        orgDetails.add(value.toString());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(!orgDetails.isEmpty())
            return orgDetails;
        return null;
    }

}
