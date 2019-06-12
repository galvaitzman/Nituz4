package Controllers;

import Views.CreateEventView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;

public class CreateEventController extends Controller {
    private CreateEventView createEventView;
    public CreateEventController(){
        super("CreateVacation.fxml");
        createEventView = fxmlLoader.getController();
        createEventView.start(new ButtonCreateEvent(), new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                String organization = createEventView.organization.getItems().get((Integer) number2).toString();
                System.out.println(organization);
            }
        });

    }

    @Override
    public void start() {
        window.setTitle("Create Vacation");
        window.show();
    }


    public class ButtonCreateEvent implements EventHandler {
        @Override
        public void handle(Event event) {
//                if (!createVacationDetailsView.isValidDate()) return;
//                else if (!createVacationDetailsView.isAllFieldsFull()) return;
//            vacationModel.insertVacationToDB(createVacationDetailsView.airLineName_1.getText(),
//                    createVacationDetailsView.airLineName_2.getText(),
//                    createVacationDetailsView.departure_time_1.getText(),
//                    createVacationDetailsView.destination_time_1.getText(),
//                    createVacationDetailsView.departure_time_2.getText(),
//                    createVacationDetailsView.destination_time_2.getText(),
//                    createVacationDetailsView.flight_number_1.getText(),
//                    createVacationDetailsView.flight_number_2.getText(),
//                    createVacationDetailsView.flight_date_1.getValue().toString(),
//                    createVacationDetailsView.flight_date_2.getValue().toString(),
//                    createVacationDetailsView.flight_baggage_1.getText(),
//                    createVacationDetailsView.flight_baggage_2.getText(),
//                    Integer.parseInt(createVacationDetailsView.numberOfTickets.getValue().toString()),
//                    createVacationDetailsView.departure_city.getText(),
//                    createVacationDetailsView.destination_city.getText(),
//                    createVacationDetailsView.ticketType1.getValue().toString()+","+
//                            createVacationDetailsView.ticketType2.getValue().toString()+","+
//                            createVacationDetailsView.ticketType3.getValue().toString()+","+
//                            createVacationDetailsView.ticketType4.getValue().toString()+","+
//                            createVacationDetailsView.ticketType5.getValue().toString(),
//                    createVacationDetailsView.vacationType.getValue().toString(),
//                    createVacationDetailsView.staying_place_name.getText(),
//                    createVacationDetailsView.stayingPlaceRanking.getValue().toString(),
//                    createVacationDetailsView.price.getText(),
//                    createVacationDetailsView.connection1.getValue().toString(),
//                    createVacationDetailsView.connection2.getValue().toString(),
//                    createVacationDetailsView.sellAllTickets.getValue().toString(),
//                    "",
//                    "",
//                    "",
//                    "");
//            createVacationDetailsView.alert("Vacation added successfuly");
            window.close();
            mainController.goBackToPreviousController();
        }
    }








}
