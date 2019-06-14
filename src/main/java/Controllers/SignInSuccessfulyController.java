package Controllers;

import Views.SignInSuccessfulyView;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.awt.*;

public class SignInSuccessfulyController extends Controller {
    SignInSuccessfulyView signInSuccessfulyView;

    public SignInSuccessfulyController(){
        super("SignInSuccessfuly.fxml");
        signInSuccessfulyView = fxmlLoader.getController();
        signInSuccessfulyView.start(new ButtonCreateEvent(), new ButtonAddUpdate(), new ButtonAddSecurityForce());
    }
    @Override
    public void start() {
        if (!currentUser.getorg_name().equals("DISPACH")){
            signInSuccessfulyView.createEvent.setDisable(true);
            signInSuccessfulyView.addUpdate.setDisable(false);
        }
        else {
            signInSuccessfulyView.createEvent.setDisable(false);
            signInSuccessfulyView.addUpdate.setDisable(true);
        }

        window.show();
//


    }

    public class ButtonCreateEvent implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            window.setTitle("Vacation4U");
            mainController.activateCreateEvent();

        }
    }

    public class ButtonAddUpdate implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activeAddUpdate();
        }
    }

    public class ButtonAddSecurityForce implements EventHandler{
        @Override
        public void handle(Event event) {
            window.close();
            mainController.activateAddSecurityForce();//
        }
    }




}
