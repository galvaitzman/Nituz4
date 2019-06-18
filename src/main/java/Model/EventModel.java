package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventModel extends AModel {


    public void makeNewEvent(
            String date,String title,String primaryUpdate, String status,String organization,String managerName,List<String> categories) {

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
        Event event = new Event(eventID,title,date,primaryUpdate,status,current_user.getuserName(),categories);
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
            pstmt.setString(3, date);
            pstmt.setString(4, primaryUpdate);
            pstmt.setString(5, status);
            pstmt.setString(6, current_user.getuserName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



        for( int i = 0; i <categories.size();i = i + 1) {
            Category category = new Category(eventID,categories.get(i));
            String sql2 = "INSERT INTO CategoriesInEvent(eventID," +
                    "cat_name) VALUES(?,?)";
            try (Connection conn3 = connect();
                 PreparedStatement pstmt = conn3.prepareStatement(sql2)) {
                pstmt.setInt(1, eventID);
                pstmt.setString(2, categories.get(i));
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }

        makeNewEventAlarm(eventID,organization,managerName,primaryUpdate);
    }

    public void makeNewEventAlarm(int eventID,String organization,String managerName,String primaryUpdate){
        EventAlarm eventAlarm = new EventAlarm(eventID,primaryUpdate,current_user.getuserName(),managerName);
        String sqlmanager = "INSERT INTO ManagersInEvents(eventID," +
                "reportTo," +
                "org_name," +
                "reportBy," +
                "information) VALUES(?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sqlmanager)) {
            pstmt.setInt(1, eventID);
            pstmt.setString(2, managerName);
            pstmt.setString(3, organization);
            pstmt.setString(4, current_user.getuserName());
            pstmt.setString(5, primaryUpdate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public List<String> getAllEvents(){
        String sql;
        if (current_user.getorg_name().equals("DISPACH")){
            sql = "SELECT eventID,title from Events WHERE status='open'";
        }
        else{
            sql = "SELECT E.eventID,title from ManagersInEvents AS MIE INNER JOIN Events AS E ON MIE.eventID=E.eventID INNER JOIN Users AS U ON U.userName=MIE.reportTo WHERE U.rank<= ? AND E.status='open' AND MIE.org_name=?";

        }
        List<String> eventList = new ArrayList<>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)){
            if (!current_user.getorg_name().equals("DISPACH")) {
                statement.setInt(1, Integer.parseInt(current_user.getrank()));
                statement.setString(2, current_user.getorg_name());
            }
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






    public void addUpdateToEvent( int eventID, String date, String originleUpdate) {

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
        Update update = new Update(current_user.getuserName(),date,originleUpdate,originleUpdate,upID);
        String sql = "INSERT INTO UpdateInEvent(upID," +
                "eventID," +
                "userName," +
                "originalUpdate," +
                "currentUpdate," +
                "date) VALUES(?,?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, upID);
            pstmt.setInt(2, eventID);
            pstmt.setString(3, current_user.getuserName());
            pstmt.setString(4, originleUpdate);
            pstmt.setString(5, originleUpdate);
            pstmt.setString(6, date);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public List<String> getSecurityForceToAdd(int eventID){
        String sql = "SELECT * from Organizations where Organizations.name NOT IN (SELECT org_name FROM ManagersInEvents WHERE ManagersInEvents.eventID=?) AND Organizations.name != 'DISPACH' ";
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



