package Places;

import java.util.*;

public class City {
    private List<Location> nodes = new ArrayList<>();

    public City() {
    }

    public City(List<Location> nodes) {
        this.nodes = nodes;
    }

    public List<Location> getNodes() {

        return nodes;

    }

    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    public void addLocation(Location node)
    {
        nodes.add(node);
    }

    public static int compareByOpeningHour(Location o1, Location o2)
    {
        Visitable v1 = (Visitable) o1;
        Visitable v2 = (Visitable) o2;

        return v1.getOpeningTime().compareTo(v2.getOpeningTime());

    }

    public void displayVisitableAndNotPayable()
    {
        List<Location> temp = new ArrayList<>();

        for(Location loc : this.nodes)
            if((loc instanceof Visitable) && (!(loc instanceof Playable)))
                temp.add(loc);

        Collections.sort(temp, City::compareByOpeningHour);

        System.out.println("Places.Visitable and not Payable, sorted by opening hour:");

        for(Location loc : temp)
            System.out.println(loc.getName());
    }

    @Override
    public String toString() {

        return "Places.City{" +
                "nodes=" + nodes +
                "\n" +
                '}';

    }
}
