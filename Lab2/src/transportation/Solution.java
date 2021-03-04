//Hamza Eduard-Mihail, 2A4
package transportation;

import java.util.Arrays;

public class Solution {
    private int cost;
    private int[] [] x;
    private int[] [] costs;

    public int[][] getX() {

        return x;

    }

    public void setX(int[][] x) {
        this.x = x;
    }

    public int[][] getCosts() {

        return costs;

    }

    public void setCosts(int[][] costs) {
        this.costs = costs;
    }

    public int getCost() {

        return cost;

    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void computeCost()
    {
        for(int i = 0; i < x.length; i++)
            for(int j = 0; j < x[i].length; j++)
                cost = cost + costs[i][j] * x[i][j];
    }

    @Override
    public String toString() {

        return "Solution{" +
                "cost=" + cost +
                ", x=" + Arrays.deepToString(x) +
                '}';

    }
}
