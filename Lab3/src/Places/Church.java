//Hamza Eduard-Mihail, 2A4
package Places;

import java.time.LocalTime;

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

        if(openingTime == null)

            return Visitable.super.getOpeningTime();

        return openingTime;

    }

    @Override
    public LocalTime getClosingTime() {

        if(closingTime == null)

            return Visitable.super.getClosingTime();

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
        return "Places.Church{" +
                "openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
