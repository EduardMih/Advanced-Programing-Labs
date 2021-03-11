package Places;

public class Restaurant extends Location implements Classifiable {
    private int rank;

    public Restaurant(String name, String description) {
        super(name, description);
    }

    public Restaurant(String name, String description, int rank) {
        super(name, description);
        this.rank = rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int getRank() {

        return rank;

    }

    @Override
    public String toString() {
        return "Places.Restaurant{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rank=" + rank +
                '}';
    }

}
