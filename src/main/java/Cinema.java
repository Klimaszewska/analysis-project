import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final String name;
    private final String address;
    private final List<Hall> halls;
    private final List<Screening> screenings;

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.halls = new ArrayList<>();
        this.screenings = new ArrayList<>();
    }

    public void addHall(Hall hall) {
        halls.add(hall);
    }

    public void addScreening(Screening screening) {
        screenings.add(screening);
    }

    public void printProgramme() {
        System.out.println("Programme for " + name + " (" + address + "):");
        for (Screening screening : screenings) {
            screening.printInfo();
        }
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public Movie findMovie(String title) {
        for (Screening screening : screenings) {
            if (screening.getMovie().getTitle().equalsIgnoreCase(title)) {
                return screening.getMovie();
            }
        }
        return null;
    }
}
