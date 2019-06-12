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

        window.show();
//        if (userModel.getCurrent_user().getUser_name().equals("")){
//            signInSuccessfulyView.myVacations.setVisible(false);
//            signInSuccessfulyView.manageMyUser.setVisible(false);
//            signInSuccessfulyView.createNewVacation.setVisible(false);
//        }
//        else {
//            signInSuccessfulyView.myVacations.setVisible(true);
//            signInSuccessfulyView.manageMyUser.setVisible(true);
//            signInSuccessfulyView.createNewVacation.setVisible(true);
//        }
//        if (ordersModel.getOrdersInCaseSeller("waiting for approval of purchase offer").size()>0 && !userModel.getCurrent_user().getUser_name().equals("")){
//            signInSuccessfulyView.requestButton.setVisible(true);
//            signInSuccessfulyView.alert("You have new purchase requests for your vacations");
//        }
//        else{
//            signInSuccessfulyView.requestButton.setVisible(false);
//        }
//        if (ordersModel.getOrdersInCaseBuyer().size()>0 && !userModel.getCurrent_user().getUser_name().equals("")){
//            signInSuccessfulyView.approvalButton.setVisible(true);
//            signInSuccessfulyView.alert("You have new approvals for your vacation purchases requests");
//        }
//        else{
//            signInSuccessfulyView.approvalButton.setVisible(false);
//        }
//        if (ordersModel.getOrdersInCaseSeller("waiting for payment").size()>0 && !userModel.getCurrent_user().getUser_name().equals("")){
//            signInSuccessfulyView.moneyRecievedButton.setVisible(true);
//            signInSuccessfulyView.alert("Please approve receiving the money for your vacation");
//        }
//        else{
//            signInSuccessfulyView.moneyRecievedButton.setVisible(false);
//        }
//        if (tradeModel.getTradesInCaseSeller().size()>0 && !userModel.getCurrent_user().getUser_name().equals("")){
//
//            signInSuccessfulyView.tradeButton.setVisible(true);
//            signInSuccessfulyView.alert("You have new requests for trade for your vacations");
//        }
//        else{
//            signInSuccessfulyView.tradeButton.setVisible(false);
//        }
//        if (tradeModel.getTradesInCaseBuyer().size()>0 && !userModel.getCurrent_user().getUser_name().equals("")){
//            signInSuccessfulyView.approvedfOrRejectedTradeButton.setVisible(true);
//            signInSuccessfulyView.alert("You have new updates for your requests to trades");
//        }
//        else{
//            signInSuccessfulyView.approvedfOrRejectedTradeButton.setVisible(false);
//        }



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
            //vacationModel.searchVacationsByUser_Id();
            window.close();
            mainController.activateAddSecurityForce();//
        }
    }




}
