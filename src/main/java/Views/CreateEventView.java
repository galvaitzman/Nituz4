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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateEventView extends AView{
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

//        staying_place_name.setText("none");
//        stayingPlaceRanking.setValue("1");
        back.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,new ButtonBack());
    }

    public void setOrganizations(List<String> allOrganizations){
        ObservableList<String> organizationsList = FXCollections.observableArrayList();
        organizations.setItems(organizationsList);
        for(int i=0; i<allOrganizations.size();i++){
            if (!allOrganizations.get(i).equals("DISPACH")) {
                organizationsList.add(allOrganizations.get(i));
            }
        }
    }

    public void setCategories(List<String> allCategories){
        List<CheckMenuItem> items = new ArrayList<>();
        for(int i=0; i<allCategories.size();i++){
            items.add(new CheckMenuItem(allCategories.get(i)));
        }

        Categories.getItems().addAll(items);
        for (CheckMenuItem item : items) {
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
    }

    public void setUsersFromOrganization(List<String> organizationUsersByName){
        ObservableList<String> usersList = FXCollections.observableArrayList();
        users.setItems(usersList);
        for (int i=0; i<organizationUsersByName.size(); i++){
            usersList.add(organizationUsersByName.get(i));
        }
    }



    public boolean isAllFieldsFull() {

        if (selectedItems.getItems().size() == 0 ||
                users.getValue() == null ||
                title.getText().equals("") ||
                organizations.getValue()==null ||
                firstUpdate.getText().equals("")) {
            alert("all fields are required");
            return false;
        }
        return true;
    }


}
