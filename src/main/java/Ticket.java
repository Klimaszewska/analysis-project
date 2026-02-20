public class Ticket {
    private final Screening screening;
    private final String seatNumber;
    private final Customer customer;

    public Ticket(Screening screening, String seatNumber, Customer customer) {
        this.screening = screening;
        this.seatNumber = seatNumber;
        this.customer = customer;
    }

    public Screening getScreening() {
        return screening;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        String customerName = customer == null ? "Guest" : customer.getName();
        return "Ticket{" +
                "movie=" + screening.getMovie().getTitle() +
                ", seat=" + seatNumber +
                ", customer=" + customerName +
                '}';
    }
}
