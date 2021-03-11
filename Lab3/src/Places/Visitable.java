//Hamza Eduard-Mihail, 2A4
package Places;

import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    default LocalTime getOpeningTime()
    {

        return LocalTime.parse("09:30");

    }
    default LocalTime getClosingTime()
    {

        return LocalTime.parse("20:00");

    }

    static Duration getVisitingDuration(Visitable a)
    {

        return Duration.between(a.getClosingTime(), a.getOpeningTime());

    }

}
