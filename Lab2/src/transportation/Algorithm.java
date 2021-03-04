//Hamza Eduard-Mihail, 2A4
package transportation;

import java.util.Arrays;

public abstract class Algorithm {
    protected int[] supply, demand;
    protected int[] [] costs;
    protected int[] [] x;

    public Algorithm(Problem pb) {
        this.supply = pb.getSupply();
        this.demand = pb.getDemand();
        this.costs = pb.getCost();
        x = new int[costs.length] [costs.length];
    }

    abstract void computeSolution();

    public Solution solve()
    {
        Solution sol = new Solution();

        computeSolution();

        sol.setCosts(costs);
        sol.setX(x);
        sol.computeCost();

        return sol;

    }
}
