import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class Event {
    private String title;
    private String date;
    private String description;
    private List<Person> attendees = new ArrayList<>();


    public Event(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public Event(String title) {
        this.title = title;
        this.date = "";
        this.description = "";
    }

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + '.';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) &&
                Objects.equals(date, event.date) &&
                Objects.equals(description, event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, description);
    }

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
        this.description = "";
    }

    public Event(Event ev) {
        this.title = ev.getTitle();
        this.description = ev.getDescription();
        this.date = ev.getDate();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public List<Person> getAttendees() {
        return this.attendees;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addPerson(Person per) {
        ListIterator<Person> it = attendees.listIterator();

        while (it.hasNext()) {
            if (it.next().getName() == per.getName()) {
                return;
            }
        }

        attendees.add(per);
    }

    public int getAudienceCount() {
        return this.attendees.size();
    }
}
