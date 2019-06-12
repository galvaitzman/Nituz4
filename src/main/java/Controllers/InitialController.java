package Controllers;

import Model.User;
import Model.UserModel;
import Views.*;
import javafx.event.Event;
import javafx.event.EventHandler;

public class InitialController extends Controller {
    private InitialView initialView;


    public InitialController(){
        super("Initial.fxml");
        initialView = fxmlLoader.getController();
        initialView.start(new ButtonSignInClickedHandler());

    }


    public void start(){
        window.show();
        window.setTitle("Vacation4U");
    }

    public class ButtonSignInClickedHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            initialView.invalidLoginLabel.setVisible(false);
            if (initialView.checkFieldsEmpty() || userModel.login(initialView.usernameTextBox.getText(),initialView.passwordTextBox.getText()) == null)
            {
                initialView.invalidLoginLabel.setVisible(true);
            }
            else
            {
                mainController.activeSignInSuccessfuly();
                initialView.usernameTextBox.setText("");
                initialView.passwordTextBox.setText("");
                window.close();
            }
            //mainController.activeSignInSuccessfuly();
            //window.close();
        }
    }




}
