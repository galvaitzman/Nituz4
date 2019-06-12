package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventModel extends AModel {


    public void insertEventToDB(
            String title, String time, String initialUpdate, String status,List<String> categoriesList,String organization,String manager) {

        String sql_eventID = "SELECT max(eventID) FROM Events";
        int eventID = 0;
        try (Connection conn1 = connect();
             Statement stmt = conn1.createStatement();
             ResultSet rs = stmt.executeQuery(sql_eventID)) {
            if (rs.getObject(1) != null)
                eventID = Integer.parseInt(rs.getObject(1).toString()) + 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }

        String sql = "INSERT INTO Events(eventID," +
                "title," +
                "time," +
                "initialUpdate," +
                "status," +
                "userName) VALUES(?,?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, eventID);
            pstmt.setString(2, title);
            pstmt.setString(3, time);
            pstmt.setString(4, initialUpdate);
            pstmt.setString(5, status);
            pstmt.setString(6, current_user.getuserName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



        for( int i = 0; i <categoriesList.size();i = i + 1) {
            String sql2 = "INSERT INTO CategoriesInEvent(eventID," +
                    "cat_name) VALUES(?,?)";
            try (Connection conn3 = connect();
                 PreparedStatement pstmt = conn3.prepareStatement(sql2)) {
                pstmt.setInt(1, eventID);
                pstmt.setString(2, categoriesList.get(i));
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }


        String sqlmanager = "INSERT INTO ManagersInEvents(eventID," +
                "reportTo," +
                "org_name," +
                "reportBy," +
                "information) VALUES(?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sqlmanager)) {
            pstmt.setInt(1, eventID);
            pstmt.setString(2, manager);
            pstmt.setString(3, organization);
            pstmt.setString(4, current_user.getuserName());
            pstmt.setString(5, initialUpdate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public List<String> getAllEvents(){
        String sql = "SELECT eventID,title from ManagersInEvents AS MIE INNER JOIN Events AS E ON MIE.eventID=E.eventID INNER JOIN Users AS U ON U.userName=MIE.reportTo WHERE U.rank<= CAST(? AS INTEGER) AND E.status='Open'";
        List<String> eventList = new ArrayList<>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, current_user.getrank());
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
                        eventList.add(value.toString());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(!eventList.isEmpty())
            return eventList;
        return null;
    }

    public void insertUpdateToDB( int eventID, String originleUp, String currUp) {

        String sql_upID = "SELECT max(upID) FROM UpdateInEvent";
        int upID = 0;
        try (Connection conn1 = connect();
             Statement stmt = conn1.createStatement();
             ResultSet rs = stmt.executeQuery(sql_upID)) {
            if (rs.getObject(1) != null)
                upID = Integer.parseInt(rs.getObject(1).toString()) + 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return;
        }

        String sql = "INSERT INTO UpdateInEvent(upID," +
                "eventID," +
                "userName," +
                "originalUpdate," +
                "currentUpdate) VALUES(?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, upID);
            pstmt.setInt(2, eventID);
            pstmt.setString(3, current_user.getuserName());
            pstmt.setString(4, originleUp);
            pstmt.setString(5, currUp);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public List<String> getSecurityForceToAdd(int eventID){
        String sql = "SELECT * from Organizations where Organizations.name NOT IN (SELECT org_name FROM ManagersInEvents WHERE ManagersInEvents.eventID=?)";
        List<String> securityList = new ArrayList<String>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1, eventID);
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
                        securityList.add(value.toString());
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(!securityList.isEmpty())
            return securityList;
        return null;
    }


}



