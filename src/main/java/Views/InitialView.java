package Views;

import Controllers.InitialController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//import java.awt.*;

public class InitialView{

    @FXML
    public Button signInButton;
    public TextField usernameTextBox;
    public TextField passwordTextBox ;
    public Label invalidLoginLabel ;

    public void start(InitialController.ButtonSignInClickedHandler buttonSignInClickedHandler){
        signInButton.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,buttonSignInClickedHandler);
        invalidLoginLabel.setVisible(false);
    }

    public boolean checkFieldsEmpty(){
        if(usernameTextBox.getText().equals("") || passwordTextBox.getText().equals(""))
            return true;
        return false;
    }





}
