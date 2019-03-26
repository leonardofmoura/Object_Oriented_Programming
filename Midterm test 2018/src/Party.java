import java.util.List;
import java.util.ListIterator;

public class Party extends Event{

    public Party(String title, String date, String description) {
        super(title, date, description);
    }

    public void addEvent(Event e){
        List<Person> toAdd = e.getAttendees();
        ListIterator<Person> it = toAdd.listIterator();

        while (it.hasNext()) {
            super.addPerson(it.next());
        }
    }
}

