package Views;

import Controllers.ButtonBack;
import Controllers.CreateEventController;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CreateEventView{
    @FXML
    public Label ticket1;
    public Label ticket2;
    public Label ticket3;
    public Label ticket4;
    public Label ticket5;
    public ChoiceBox sellAllTickets;
    public ChoiceBox stayingPlaceRanking;
    public ChoiceBox vacationType;
    public ChoiceBox ticketType1;
    public ChoiceBox ticketType2;
    public ChoiceBox ticketType3;
    public ChoiceBox ticketType4;
    public ChoiceBox ticketType5;
    public ChoiceBox organization;
    public TextField departure_city;
    public DatePicker flight_date_1;
    public TextField departure_time_1;
    public TextField destination_time_1;
    public TextField airLineName_1;
    public TextField flight_number_1;
    public TextField flight_baggage_1;
    public ChoiceBox connection1;
    public TextField destination_city;
    public DatePicker flight_date_2;
    public TextField departure_time_2;
    public TextField destination_time_2;
    public TextField airLineName_2;
    public TextField flight_number_2;
    public TextField flight_baggage_2;
    public ChoiceBox connection2;
    public TextField price;
    public TextField staying_place_name;
    public CheckBox flightBack;
    public Button back;
    public Button createEvent;


    public void start(
            CreateEventController.ButtonCreateEvent buttonCreateEvent,
            ChangeListener changeListener) {
        organization.getSelectionModel().selectedIndexProperty().addListener(changeListener);
        createEvent.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, buttonCreateEvent);
        //ObservableList<String> sellAllTicketsItems = FXCollections.observableArrayList();
        //ObservableList<String> vacationTypeItems = FXCollections.observableArrayList();
        ObservableList<String> organizations = FXCollections.observableArrayList();
        //ObservableList<String> ticketTypeItems = FXCollections.observableArrayList();
        //ObservableList<String> connectionItems = FXCollections.observableArrayList();
        //sellAllTicketsItems.add("Yes");
        //sellAllTicketsItems.add("No");
        //sellAllTickets.setItems(sellAllTicketsItems);
        //vacationTypeItems.add("Urban");
//        vacationTypeItems.add("Exotic");
//        vacationType.setItems(vacationTypeItems);
//        rankingOfStayingPlaceItems.add("5");
//        rankingOfStayingPlaceItems.add("4");
//        rankingOfStayingPlaceItems.add("3");
//        rankingOfStayingPlaceItems.add("2");
//        rankingOfStayingPlaceItems.add("1");
//        stayingPlaceRanking.setItems(rankingOfStayingPlaceItems);
        organization.setItems(organizations);
        organizations.add("Police");
        organizations.add("MDA");
        organizations.add("Fire Department");
//        connection2.setValue("");
//        ticketType1.setItems(ticketTypeItems);
//        ticketType2.setItems(ticketTypeItems);
//        ticketType3.setItems(ticketTypeItems);
//        ticketType4.setItems(ticketTypeItems);
//        ticketType5.setItems(ticketTypeItems);
//        ticketType2.setValue("Adult");
//        ticketType3.setValue("Adult");
//        ticketType4.setValue("Adult");
//        ticketType5.setValue("Adult");
//        numberOfTickets.setValue("1");
//        connectionItems.add("Connection");
//        connectionItems.add("Direct");
//        connection1.setItems(connectionItems);
//        connection2.setItems(connectionItems);
//
//        departure_time_2.setDisable(true);
//        destination_time_2.setDisable(true);
//        airLineName_2.setDisable(true);
//        flight_number_2.setDisable(true);
//        flight_baggage_2.setDisable(true);
//        connection2.setDisable(true);
//        departure_time_2.setText("");
//        destination_time_2.setText("");
//        airLineName_2.setText("");
//        flight_number_2.setText("");
//        flight_baggage_2.setText("");
//        connection2.setValue("");
//
//        staying_place_name.setText("none");
//        stayingPlaceRanking.setValue("1");
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());


    }



    public boolean isAllFieldsFull() {
        if (sellAllTickets.getValue() == null ||
                stayingPlaceRanking.getValue() == null ||
                vacationType.getValue() == null ||
                ticketType1.getValue() == null ||
                departure_city.getText().equals("") ||
                departure_time_1.getText().equals("") ||
                destination_time_1.getText().equals("") ||
                airLineName_1.getText().equals("") ||
                flight_number_1.getText().equals("") ||
                flight_baggage_1.getText().equals("") ||
                destination_city.getText().equals("") ||
                price.getText().equals("") ||
                staying_place_name.getText().equals("") ||
                connection1.getValue() == null) {
            //alert("mandatory fields missing");
            return false;
        }
       if (flightBack.isSelected() && (departure_time_2.getText().equals("") ||
                destination_time_2.getText().equals("") ||
                airLineName_2.getText().equals("") ||
                flight_number_2.getText().equals("") ||
                flight_baggage_2.getText().equals("") ||
                (connection2.getValue() == null || connection2.getValue().toString().equals("")))){
           //alert("mandatory fields missing");
           return false;
        }
        return true;
    }

    public void enableOrDisableFlightBackDetails(){
        if (departure_time_2.isDisable()) {
            departure_time_2.setDisable(false);
            destination_time_2.setDisable(false);
            airLineName_2.setDisable(false);
            flight_number_2.setDisable(false);
            flight_baggage_2.setDisable(false);
            connection2.setDisable(false);
        }
        else {
            departure_time_2.setDisable(true);
            destination_time_2.setDisable(true);
            airLineName_2.setDisable(true);
            flight_number_2.setDisable(true);
            flight_baggage_2.setDisable(true);
            connection2.setDisable(true);
        }
    }
}
