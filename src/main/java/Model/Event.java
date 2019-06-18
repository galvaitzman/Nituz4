package Model;

import java.util.ArrayList;
import java.util.List;

public class Event {
    int eventID;
    String title;
    String date;
    String primaryUpdate;
    String status;
    String userName;
    List<String> categories;
    List <EventAlarm> eventAlarms = new ArrayList<>();

    public Event(int eventID, String title, String date, String primaryUpdate, String status, String userName, List<String> categories) {
        this.eventID = eventID;
        this.title = title;
        this.date = date;
        this.primaryUpdate = primaryUpdate;
        this.status = status;
        this.userName = userName;
        this.categories = categories;
    }

    public void addEventAlarm(EventAlarm eventAlarm){
        eventAlarms.add(eventAlarm);
    }


}
