import java.util.HashMap;
import java.util.Map;

public abstract class Location implements Comparable<Location> {
    protected String name;
    protected String description;
    protected Map<Location, Integer> cost = new HashMap<>();

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {

        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {

        return description;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Location, Integer> getCost() {

        return cost;

    }

    public void setCost(Location node, int value) {
        this.cost.put(node, value);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(Location o) {
        if(this.name != null)

            return this.name.compareTo(o.name);

        throw new NullPointerException("!!!NULL Location name");

    }
}
