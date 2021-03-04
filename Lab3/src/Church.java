import java.time.LocalTime;
import java.util.Map;

public class Church extends Location implements Visitable{
    private LocalTime openingTime, closingTime;

    public Church(String name, String description, LocalTime openingTime, LocalTime closingTime) {
        super(name, description);
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public Church(String name, String description) {
        super(name, description);
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

    @Override
    public String toString() {
        return "Church{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
