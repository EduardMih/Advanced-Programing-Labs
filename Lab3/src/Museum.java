import java.time.LocalTime;
import java.util.Map;

public class Museum extends Location implements Visitable, Playable {
    private LocalTime openingTime, closingTime;
    private double ticketPrice;

    public Museum(String name, String description) {
        super(name, description);
    }

    public Museum(String name, String description, LocalTime openingTime, LocalTime closingTime, double ticketPrice) {
        super(name, description);
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public double getTicketPrice() {

        return ticketPrice;

    }

    @Override
    public LocalTime getOpeningTime() {

        return openingTime;

    }

    @Override
    public LocalTime getClosingTime() {

        return closingTime;

    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Museum{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
