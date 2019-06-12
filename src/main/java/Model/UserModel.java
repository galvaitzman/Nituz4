package Model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;


public class UserModel extends AModel {

    User current_user;

    public UserModel(){
        current_user = new User();
    }

    public User searchUserByUserName(String user_name){
        String sql = "SELECT * from Users where userName = ?";
        List<String> userDetails = new ArrayList<String>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, user_name);
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
                        userDetails.add(value.toString());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(!userDetails.isEmpty())
            return new User(userDetails);
        return null;
    }

    public User login(String userName, String password){
        User searchResult = searchUserByUserName(userName);

        if(searchResult == null)
            return null;
        if (!password.equals(searchResult.getpassword()))
            return null;
        current_user = searchResult;
        return searchResult;
    }

    public List<User> getAllUsersFromOrganization(String organization)
    {
        String sql = "SELECT * from Users where org_name = ?";
        List<User> userList = new ArrayList<User>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, organization);
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next())
            {
                List<String> userDetails = new ArrayList<String>();
                for (int col=1; col <= colCount; col++)
                {
                    Object value = rs.getObject(col);
                    if (value != null)
                    {
                        userDetails.add(value.toString());
                    }
                }
                User tempUser = new User(userDetails);
                userList.add(tempUser);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(!userDetails.isEmpty())
            return userList;
        return null;
    }

}
