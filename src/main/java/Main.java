import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("Multikino", "ul. Akademicka 5");
        Hall hall = new Hall("Hall 1", 100);
        cinema.addHall(hall);

        Movie movie1 = new Movie("Galactic Journey", 120);
        Movie movie2 = new Movie("Ocean Depths", 95);

        Screening screening1 = new Screening(
                movie1,
                hall,
                LocalDateTime.now().plusDays(1),
                ScreeningType.TWO_D
        );
        Screening screening2 = new Screening(
                movie2,
                hall,
                LocalDateTime.now().plusDays(2),
                ScreeningType.THREE_D
        );

        cinema.addScreening(screening1);
        cinema.addScreening(screening2);

        cinema.printProgramme();

        screening1.reserveSeats("S1", "S2");

        Customer customer = new Customer("Jan Kowalski");
        screening2.reserveSeats(customer, "S10", "S11");
        screening2.buyTickets(customer, "S10", "S11");

        customer.printTickets();

        Movie found = cinema.findMovie("Ocean Depths");
        System.out.println("Found movie: " + found);
    }
}
