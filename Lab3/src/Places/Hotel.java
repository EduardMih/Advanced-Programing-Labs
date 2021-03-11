//Hamza Eduard-Mihail, 2A4
package Places;

public class Hotel extends Location implements Classifiable {
    private int rank;


    public Hotel(String name, String description) {
        super(name, description);
    }

    public Hotel(String name, String description, int rank) {
        super(name, description);
        this.rank = rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int getRank() {

        return this.rank;

    }

    @Override
    public String toString() {
        return "Places.Hotel{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
