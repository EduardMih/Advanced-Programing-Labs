//Hamza Eduard-Mihail, 2A4
package transportation;

import java.util.Arrays;

public class RandomInstance {
    private int[] supply;
    private int[] demand;
    private int[] [] cost;

    public static void main(String[] args)
    {
        RandomInstance r1 = new RandomInstance();
        Problem largePb = new Problem();
        Solution sol = new Solution();

        r1.generateSupDem(1000);
        r1.generateCost(1000);
        largePb.setSupply(r1.supply);
        largePb.setDemand(r1.demand);
        largePb.setCost(r1.cost);

        Algorithm vogel = new VogelAlgorithm(largePb);
        sol = vogel.solve();

        System.out.println(sol);

    }
    private void generateSupDem(int n)
    {
        int sum=0, currentSum=0, pos;
        supply = new int[n];
        demand = new int[n];

        //generate supply array
        for(int i = 0; i < supply.length; i++)
        {
            supply[i] = (int) (Math.random() * 100);
            sum = sum + supply[i];
        }

        //generate demand array with the same sum as supply
        while(currentSum < sum)
        {
            pos = (int) (Math.random() * n);
            demand[pos] = demand[pos] + 1;
            currentSum = currentSum + 1;
        }
    }

    private void generateCost(int n)
    {
        cost = new int[n][n];

        for(int i = 0; i < cost.length; i++)
            for(int j = 0; j < cost[i].length; j++)
                cost[i][j] = (int) (Math.random() * 10);
    }


}
