package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacationModel extends AModel {


    public void insertEventToDB(
            String title, String time, String initialUpdate, String status, String userName,List<String> categoriesList) {
        String post_type;
     
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
            pstmt.setString(6, userName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

/*
    public boolean updateVacation(int eventID, String title, String time, String initialUpdate, String status, String userName, String destination_time_2,
                                  String flight_number_1, String flight_number_2, String flight_date_1, String flight_date_2, String flight_baggage_1, String flight_baggage_2,
                                  int number_of_tickets, String departure_city, String destination_city, String tickets_type, String vacation_type, String stying_place_name, String stying_place_rank,
                                  String price, String connection1, String connection2, String sell_all_tickets, String bank_acount_number, String number_snif, String bank_number, String paypal) {
        //   if (!searchVacationByVacationID(eventID).isEmpty()){
        String sql = "UPDATE Vacation SET title=?," +
                "time=?," +
                "initialUpdate=?," +
                "status=?," +
                "userName=?," +
                "destination_time_2=?," +
                "flight_number_1=?," +
                "flight_number_2 =?," +
                "flight_date_1=?," +
                "flight_date_2=?," +
                "flight_baggage_1=?," +
                "flight_baggage_2=?," +
                "number_of_tickets=?," +
                "departure_city=?," +
                "destination_city=?," +
                "tickets_type=?," +
                "vacation_type=?," +
                "stying_place_name=?," +
                "stying_place_rank=?," +
                "price=?," +
                "connection1=?," +
                "connection2=?," +
                "sell_all_tickets=?, " +
                "bank_acount_number=?," +
                "number_snif=?," +
                "bank_number=?, " +
                "paypal=?"
                + "WHERE eventID  = ?";


        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, title);
            pstmt.setString(2, time);
            pstmt.setString(3, initialUpdate);
            pstmt.setString(4, status);
            pstmt.setString(5, userName);
            pstmt.setString(6, destination_time_2);
            pstmt.setString(7, flight_number_1);
            pstmt.setString(8, flight_number_2);
            pstmt.setString(9, flight_date_1);
            pstmt.setString(10, flight_date_2);
            pstmt.setString(11, flight_baggage_1);
            pstmt.setString(12, flight_baggage_2);
            pstmt.setInt(13, number_of_tickets);
            pstmt.setString(14, departure_city);
            pstmt.setString(15, destination_city);
            pstmt.setString(16, tickets_type);
            pstmt.setString(17, vacation_type);
            pstmt.setString(18, stying_place_name);
            pstmt.setString(19, stying_place_rank);
            pstmt.setString(20, price);
            pstmt.setString(21, connection1);
            pstmt.setString(22, connection2);
            pstmt.setString(23, sell_all_tickets);
            pstmt.setString(24, bank_acount_number);
            pstmt.setString(25, number_snif);
            pstmt.setString(26, bank_number);
            pstmt.setString(27, paypal);
            pstmt.setInt(28, eventID);

            // update
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //  }
        return false;
    }


    public Vacation searchVacationByVacationID(int eventID) {
        Vacation vacation = new Vacation();
        String sql = "SELECT * from Vacation where eventID = ?";
        List<String> VacationDetails = new ArrayList<String>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, eventID);
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next()) {
                for (int col = 1; col <= colCount; col++) {
                    Object value = rs.getObject(col);
                    if (value != null) {
                       // VacationDetails.add(value.toString());
                        vacation.vacation_details[col - 1] = value.toString();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vacation;
    }


    public void updateVacationStatus(int eventID, String status) {
            String sql = "UPDATE Vacation SET status=?"
                    + "WHERE eventID  = ?";
            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // set the corresponding param
                pstmt.setString(1, status);
                pstmt.setInt(2, eventID);
                // update
                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    public boolean deleteVacation(int eventID) {
        String sql = "DELETE FROM Vacation WHERE eventID = ? AND status =?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // set the corresponding param
            pstmt.setInt(1, eventID);
            pstmt.setString(2, "valid");
            // execute the delete statement
            int x = pstmt.executeUpdate();
            return (x==1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }



    public List<Vacation> searchValidVacationsByUser_Id() {
        String sql = "SELECT * from Vacation where user_name = ? AND status = ?";
        List<Vacation> VacationDetails = new ArrayList<>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, current_user.getUser_name());
            statement.setString(2, "valid");
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next()) {
                Vacation vac = new Vacation();
                for (int col = 1; col <= colCount; col++) {
                    Object value = rs.getObject(col);
                    if (value != null) {
                        vac.vacation_details[col - 1] = value.toString();
                        // VacationDetails.add(value.toString());
                    }
                }
                VacationDetails.add(vac);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        currentListOfVacations.clear();
        currentListOfVacations = VacationDetails;
        return VacationDetails;
    }


    public List<Vacation> searchVacationsByUser_Id() {
        String sql = "SELECT * from Vacation where user_name = ?";
        List<Vacation> VacationDetails = new ArrayList<>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, current_user.getUser_name());
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next()) {
                Vacation vac = new Vacation();
                for (int col = 1; col <= colCount; col++) {
                    Object value = rs.getObject(col);
                    if (value != null) {
                        vac.vacation_details[col - 1] = value.toString();
                        // VacationDetails.add(value.toString());
                    }
                }
                VacationDetails.add(vac);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        currentListOfVacations.clear();
        currentListOfVacations = VacationDetails;
        return VacationDetails;
    }


    public List<Vacation> searchVacationsByParameters(String flight_date_1, String flight_date_2, String departure_city, String destination_city) {
        String sql;
        List<Vacation> VacationDetails = new ArrayList<>();

        sql = ("SELECT * from Vacation where status = ? AND ");

        if (flight_date_1.equals(""))
            sql += ("flight_date_1 is not NULL AND ");
        else
            sql += ("flight_date_1 = ? AND ");

        if (flight_date_2.equals(""))
            sql += ("flight_date_2 is not null AND ");
        else
            sql += ("flight_date_2 = ? AND ");

        if (departure_city.equals(""))
            sql += ("departure_city is not null AND ");
        else
            sql += ("departure_city = ? AND ");

        if (destination_city.equals(""))
            sql += ("destination_city is not null");
        else
            sql += ("destination_city = ?");

        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            int i = 1;
            statement.setString(i++, "valid");
            if (!flight_date_1.equals(""))
                statement.setString(i++, flight_date_1);
            if (!flight_date_2.equals(""))
                statement.setString(i++, flight_date_2);
            if (!departure_city.equals(""))
                statement.setString(i++, departure_city);
            if (!destination_city.equals(""))
                statement.setString(i, destination_city);
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next()) {
                Vacation vac = new Vacation();
                for (int col = 1; col <= colCount; col++) {
                    Object value = rs.getObject(col);
                    if (value != null) {
                        vac.vacation_details[col - 1] = value.toString();
                    }
                }
                VacationDetails.add(vac);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        currentListOfVacations.clear();
        currentListOfVacations = VacationDetails;
        return VacationDetails;
    }

    public List<Vacation> searchAllVacation() {
        String sql = "SELECT * from Vacation WHERE status = ?";
        List<Vacation> VacationDetails = new ArrayList<>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, "valid");
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next()) {
                Vacation vac = new Vacation();
                for (int col = 1; col <= colCount; col++) {
                    Object value = rs.getObject(col);
                    if (value != null) {
                        vac.vacation_details[col - 1] = value.toString();
                    }
                }
                VacationDetails.add(vac);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        currentListOfVacations.clear();
        currentListOfVacations = VacationDetails;
        return VacationDetails;
    }

    public List<Vacation> searchVacationsByStatus(String status){
        String sql = "SELECT * from Vacation where user_name = ? AND status = ?";
        List<Vacation> VacationDetails = new ArrayList<>();
        try (Connection conn = this.connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, current_user.getUser_name());
            statement.setString(2, status);
            ResultSet rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next()) {
                Vacation vac = new Vacation();
                for (int col = 1; col <= colCount; col++) {
                    Object value = rs.getObject(col);
                    if (value != null) {
                        vac.vacation_details[col - 1] = value.toString();
                        // VacationDetails.add(value.toString());
                    }
                }
                VacationDetails.add(vac);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        currentListOfVacations.clear();
        currentListOfVacations = VacationDetails;
        return VacationDetails;
    }
*/
}



