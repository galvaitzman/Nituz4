package Model;

public class Update {
    String participantInEvent;
    String date;
    String originalUpdate;
    String currentUpdate;
    int updateID;
    Update previousUpdate;

    public Update(String participantInEvent, String date, String originalUpdate, String currentUpdate, int updateID) {
        this.participantInEvent = participantInEvent;
        this.date = date;
        this.originalUpdate = originalUpdate;
        this.currentUpdate = currentUpdate;
        this.updateID = updateID;
    }
}
