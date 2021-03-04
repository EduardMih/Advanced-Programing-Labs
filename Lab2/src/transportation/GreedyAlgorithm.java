/**
 * <h1> Least Cost Cell Alg</h1>
 * Least Cost Cell alg; find the cell with min cost and allocate
 * the minimum between supply and demand. If supply or demand becomes 0
 * cancel that row/column.
 * @author Hamza Eduard-Mihail
 */
package transportation;

import java.util.Arrays;

public class GreedyAlgorithm extends Algorithm{
    public GreedyAlgorithm(Problem pb) {
        super(pb);
    }

    @Override
    void computeSolution()
    {
        int k = 0;

        while(k == 0)
        {
            k = 1;

            for (int d : demand) //as long as there is demand
                if (d != 0)
                {
                    k = 0;
                    leastCostCell();
                }
        }

        System.out.println(Arrays.toString(demand));
    }

    private void leastCostCell()
    {
        int minRow=0, minColumn=0, minCost, minQuantity;

        minCost = 100;

        for(int i = 0; i < costs.length; i++)
            for(int j = 0; j < costs[i].length; j++)
                if((costs[i][j] < minCost) && (supply[i] != 0) && (demand[j] != 0)) //find min cost
                {
                    minCost = costs[i][j];
                    minRow = i;
                    minColumn = j;
                }
        //update supply, demand, result
        minQuantity = Math.min(supply[minRow], demand[minColumn]);
                System.out.println(minQuantity);
                System.out.println(minCost);
        x[minRow][minColumn] = minQuantity;
        supply[minRow] = supply[minRow] - minQuantity;
        demand[minColumn] = demand[minColumn] - minQuantity;
    }

}
