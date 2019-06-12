package Controllers;

import Model.User;
import Views.CreateEventView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class AddSecurityForceController extends Controller {
    private CreateEventView createEventView;
    public AddSecurityForceController(){
        super("CreateEvent.fxml");
        createEventView = fxmlLoader.getController();


    }

    private List<String> getOrganizationUsersByName(List<User>organizationUsers ){
        List<String> organizationUsersByName = new ArrayList<>();
        for (int i=0; i<organizationUsers.size(); i++){
            organizationUsersByName.add(organizationUsers.get(i).getuserName());
        }
        return organizationUsersByName;
    }

    @Override
    public void start() {
        createEventView.setOrganizations(eventModel.getAllOrganization());
        createEventView.setCategories(eventModel.getAllCategories());
        window.setTitle("Create Vacation");
        window.show();
    }


    public class ButtonCreateEvent implements EventHandler {
        @Override
        public void handle(Event event) {
            List<String>allCategories = new ArrayList<>();
            for (int i=0; i<createEventView.selectedItems.getItems().size(); i++){
                allCategories.add(createEventView.selectedItems.getItems().get(i));
            }

            if (createEventView.isAllFieldsFull()){//new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()).toString(),
                eventModel.insertEventToDB(createEventView.title.getText(),
                        new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z").format(Calendar.getInstance().getTime()),
                        createEventView.firstUpdate.getText(),
                        "open",
                        allCategories);//createEventView.selectedItems.getItems()
                window.close();
                mainController.goBackToPreviousController();
            }

        }
    }








}
