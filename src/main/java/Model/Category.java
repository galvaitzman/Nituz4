package Model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    List<Integer> events = new ArrayList<>();
    String category;

    public Category(int eventID, String category) {
        this.events.add(eventID);
        this.category = category;
    }
}
