package Views;

import Controllers.ButtonBack;
import Controllers.CreateEventController;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;

import java.util.Arrays;
import java.util.List;

public class CreateEventView{
    @FXML
    public ChoiceBox organizations;
    public ChoiceBox users;
    public TextField title;
    public Button back;
    public Button createEvent;
    public MenuButton Categories;
    public TextArea firstUpdate;
    public ListView<String> selectedItems = new ListView<>();


    public void start(
            CreateEventController.ButtonCreateEvent buttonCreateEvent,
            ChangeListener changeListener) {
        organizations.getSelectionModel().selectedIndexProperty().addListener(changeListener);
        createEvent.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, buttonCreateEvent);
        //ObservableList<String> sellAllTicketsItems = FXCollections.observableArrayList();
        //ObservableList<String> vacationTypeItems = FXCollections.observableArrayList();
        ObservableList<String> organizationsList = FXCollections.observableArrayList();
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
        organizations.setItems(organizationsList);
        organizationsList.add("Police");
        organizationsList.add("MDA");
        organizationsList.add("Fire Department");
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
        final List<CheckMenuItem> items = Arrays.asList(
                new CheckMenuItem("Homicide"),
                new CheckMenuItem("Robbery"),
                new CheckMenuItem("Kidnapping"),
                new CheckMenuItem("Car Accident"),
                new CheckMenuItem("Fire"),
                new CheckMenuItem("Medicine")
        );
        Categories.getItems().addAll(items);
        for (final CheckMenuItem item : items) {
            item.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
                if (newValue) {
                    selectedItems.getItems().add(item.getText());
                    System.out.println("add");
                } else {
                    selectedItems.getItems().remove(item.getText());
                    System.out.println("remove");
                }
            });
        }
//        staying_place_name.setText("none");
//        stayingPlaceRanking.setValue("1");
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());
    }

    public void setUsersFromOrganization(List<String> organizationUsersByName){
        ObservableList<String> usersList = FXCollections.observableArrayList();
        users.setItems(usersList);
        for (int i=0; i<organizationUsersByName.size(); i++){
            usersList.add(organizationUsersByName.get(i));
        }
    }



    public boolean isAllFieldsFull() {
//        if (sellAllTickets.getValue() == null ||
//                stayingPlaceRanking.getValue() == null ||
//                vacationType.getValue() == null ||
//                ticketType1.getValue() == null ||
//                departure_city.getText().equals("") ||
//                departure_time_1.getText().equals("") ||
//                destination_time_1.getText().equals("") ||
//                airLineName_1.getText().equals("") ||
//                flight_number_1.getText().equals("") ||
//                flight_baggage_1.getText().equals("") ||
//                destination_city.getText().equals("") ||
//                price.getText().equals("") ||
//                staying_place_name.getText().equals("") ||
//                connection1.getValue() == null) {
//            //alert("mandatory fields missing");
//            return false;
//        }
//       if (flightBack.isSelected() && (departure_time_2.getText().equals("") ||
//                destination_time_2.getText().equals("") ||
//                airLineName_2.getText().equals("") ||
//                flight_number_2.getText().equals("") ||
//                flight_baggage_2.getText().equals("") ||
//                (connection2.getValue() == null || connection2.getValue().toString().equals("")))){
//           //alert("mandatory fields missing");
//           return false;
//        }
        return true;
    }


}
