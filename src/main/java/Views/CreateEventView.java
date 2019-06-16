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
        firstUpdate.setTextFormatter(new TextFormatter<String>(change ->
                change.getControlNewText().length() <= 255 ? change : null));
        organizations.getSelectionModel().selectedIndexProperty().addListener(changeListener);
        createEvent.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, buttonCreateEvent);
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
            return false;
        }
        return true;
    }


}
