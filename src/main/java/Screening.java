import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Screening {
    private final Movie movie;
    private final Hall hall;
    private final LocalDateTime dateTime;
    private final ScreeningType screeningType;
    private final Set<String> reservedSeats;
    private final List<Ticket> soldTickets;

    public Screening(Movie movie, Hall hall, LocalDateTime dateTime, ScreeningType screeningType) {
        this.movie = movie;
        this.hall = hall;
        this.dateTime = dateTime;
        this.screeningType = screeningType;
        this.reservedSeats = new LinkedHashSet<>();
        this.soldTickets = new ArrayList<>();
    }

    public Movie getMovie() {
        return movie;
    }

    public void reserveSeats(String... seats) {
        for (String seat : seats) {
            if (isValidSeat(seat)) {
                reservedSeats.add(seat);
            }
        }
    }

    public void reserveSeats(Customer customer, String... seats) {
        reserveSeats(seats);
    }

    public void buyTickets(Customer customer, String... seats) {
        for (String seat : seats) {
            if (isValidSeat(seat)) {
                boolean alreadySold = soldTickets.stream()
                        .anyMatch(t -> t.getSeatNumber().equals(seat));
                if (alreadySold) {
                    System.out.println("Seat already sold: " + seat);
                    continue;
                }
                reservedSeats.add(seat);
                Ticket ticket = new Ticket(this, seat, customer);
                soldTickets.add(ticket);
                if (customer != null) {
                    customer.addTicket(ticket);
                }
            }
        }
    }

    public void printInfo() {
        String formatted = dateTime.format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.println(movie + " | " + formatted + " | " + hall.getName() + " | " + screeningType);
    }

    private boolean isValidSeat(String seat) {
        if (!hall.getSeats().contains(seat)) {
            System.out.println("Seat does not exist: " + seat);
            return false;
        }
        return true;
    }
}
