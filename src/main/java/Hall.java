import java.util.LinkedHashSet;
import java.util.Set;

public class Hall {
    private final String name;
    private final Set<String> seats;

    public Hall(String name, int numberOfSeats) {
        this.name = name;
        this.seats = new LinkedHashSet<>();
        for (int i = 1; i <= numberOfSeats; i++) {
            seats.add("S" + i);
        }
    }

    public String getName() {
        return name;
    }

    public Set<String> getSeats() {
        return seats;
    }
}
