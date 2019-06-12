package Controllers;

//import Model.OrdersModel;
//import Model.TradeModel;
//import Model.UserModel;
//import Model.EventModel;
import Model.User;
import Model.UserModel;
import Model.EventModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.MainController;

import java.io.IOException;

public abstract class Controller {

    protected static MainController mainController;
    protected static UserModel userModel;
    protected static EventModel eventModel;
    protected static User currentUser;
    public Stage window = new Stage();
    Parent root = null;
    FXMLLoader fxmlLoader = new FXMLLoader();
    Scene scene;

    public static void setMainUserModel (){
        userModel = new UserModel();
    }

    public static void setMainEventModel (){
        eventModel = new EventModel();
    }


    public static void setMainController (MainController other){
        mainController = other;
    }


    public abstract void start();

    public Controller(String fxml){
        try {
            root = fxmlLoader.load(getClass().getResource("/" + fxml).openStream());
            scene = new Scene (root);
            window.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();}
    }

}
