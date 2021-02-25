//Hamza Eduard-Mihail, 2A4
package transportation;

public class TestProblem {
    public static void main(String[] args) {
        Source[] sources = new Source[3];
        Destination[] destinations = new Destination[3];
        Problem pr = new Problem();
        Problem pr2;
        int[] supply = {10, 35, 25};
        int[] demand = {20, 25, 25};
        int[][] cost = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};

        sources[0] = new Source("S1", SourceType.FACTORY);
        sources[1] = new Source("S2", SourceType.WAREHOUSE);
        sources[2] = new Source("S3", SourceType.WAREHOUSE);

        for (int i = 0; i < 3; i++)
            destinations[i] = new Destination("S" + (i + 1));

        for (int i = 0; i < 3; i++) {
            System.out.println(sources[i].toString());
            System.out.println(destinations[i].toString());
        }

        //using setter methods from Problem
        pr.setSources(sources);
        pr.setDestinations(destinations);
        pr.setSupply(supply);
        pr.setDemand(demand);
        pr.setCost(cost);

        System.out.println(pr.toString());

        //with constructor
        pr2 = new Problem(sources, destinations, supply, demand, cost);

        System.out.println(pr);

        //check error throwing in set method
        Destination d1 = new Destination();

        try
        {
            d1.setName(null);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Exception at set destination name" + e.getMessage());
        }

    }
}
