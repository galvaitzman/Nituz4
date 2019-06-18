package Model;

public class EventAlarm {
    int eventID;
    String primaryUpdate;
    String from;
    String manager;

    public EventAlarm(int eventID, String primaryUpdate, String from, String manager) {
        this.eventID = eventID;
        this.primaryUpdate = primaryUpdate;
        this.from = from;
        this.manager = manager;
    }
}
