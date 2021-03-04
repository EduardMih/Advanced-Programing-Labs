//Hamza Eduard-Mihail, 2A4
package transportation;

import java.util.Arrays;

public class Problem {
    private Source[] sources;
    private Destination[] destinations;

    private int[] supply;
    private int[] demand;
    private int[] [] cost;

    public Problem() {
    }

    public Problem(Source[] sources, Destination[] destinations, int[] supply, int[] demand, int[][] cost) {
        if(!hasUniqueObjects(sources))
            throw new IllegalArgumentException("!!!Not unique or NULL sources");

        this.sources = sources;

        if(!hasUniqueObjects(destinations))
            throw new IllegalArgumentException("!!!Not unique or NULL destinations");

        this.destinations = destinations;

        this.supply = supply;
        this.demand = demand;
        this.cost = cost;
    }

    public Source[] getSources() {

        return sources;

    }

    public void setSources(Source[] sources) {
        if(!hasUniqueObjects(sources))
            throw new IllegalArgumentException("!!!Not unique or NULL sources");

        this.sources = sources;
    }

    public int[] getSupply() {
        int[] copy = new int[this.supply.length];

        System.arraycopy(this.supply, 0, copy, 0,  copy.length);

        return copy;

    }



    public void setSupply(int[] supply) {
        this.supply = supply;
    }

    public Destination[] getDestinations() {

        return destinations;

    }

    public void setDestinations(Destination[] destinations) {
        if(!hasUniqueObjects(destinations))
            throw new IllegalArgumentException("!!!Not unique or NULL destinations");

        this.destinations = destinations;
    }

    public int[] getDemand() {
        int[] copy = new int[this.demand.length];

        System.arraycopy(this.demand, 0, copy, 0, copy.length);

        return copy;

    }

    public void setDemand(int[] demand) {
        this.demand = demand;
    }

    public int[][] getCost() {
        int[] [] copy = new int[this.cost.length][this.cost.length];

        for(int i = 0; i < this.cost.length; i++)
            System.arraycopy(this.cost[i], 0, copy[i], 0, this.cost[i].length);

        return copy;

    }

    public void setCost(int[][] cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {

        return "Problem{" +
                "sources=" + Arrays.toString(sources) +
                ", destinations=" + Arrays.toString(destinations) +
                ", supply=" + Arrays.toString(supply) +
                ", demand=" + Arrays.toString(demand) +
                ", cost=" + Arrays.deepToString(cost) +
                '}';

    }

    public boolean hasUniqueObjects(Object[] obj)
    {
        for (int i = 0; i < obj.length; i++)
            for (int j = i + 1; j < obj.length; j++)
                 if((obj[i] == null) || (obj[i].equals(obj[j])))

                     return false;

                 return true;
    }
}
