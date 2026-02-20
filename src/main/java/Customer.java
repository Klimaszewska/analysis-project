import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Ticket> tickets;

    public Customer(String name) {
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void printTickets() {
        System.out.println("Tickets for " + name + ":");
        for (Ticket ticket : tickets) {
            System.out.println(" - " + ticket);
        }
    }
}
