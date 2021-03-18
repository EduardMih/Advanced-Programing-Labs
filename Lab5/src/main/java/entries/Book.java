//Hamza Eduard-Mihail, 2A4
package entries;

import java.util.Date;

public class Book extends Item{
    private Date releaseDate;

    public Book(String id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {

        return "Book{" +
                "releaseDate=" + releaseDate +
                " " + super.toString();

    }
}
