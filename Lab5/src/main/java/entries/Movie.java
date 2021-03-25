//Hamza Eduard-Mihail, 2A4
package entries;

import java.util.Date;

public class Movie extends Item{
    private Date releaseDate;
    public Movie(String id, String name) {
        super(id, name);
    }

    public Movie(String id, String name, String location) {
        super(id, name, location);
    }

    @Override
    public String toString() {

        return "Movie{" +
                "releaseDate=" + releaseDate +
                 " " + super.toString();

    }
}
