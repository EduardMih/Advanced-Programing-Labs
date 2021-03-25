//Hamza Eduard-Mihail, 2A4
package solver;

import org.chocosolver.solver.Solution;

public class TestSolver {
    private int[] [] adj;

    public static void main(String[] args)
    {
        TestSolver test = new TestSolver();

        test.generateGraph();
        Solver solver = new Solver(test.adj);
        Solution sol = solver.solve();

        System.out.println(sol);
    }

    private void generateGraph()
    {
        adj = new int[12][12];
        adj[1][2] = 1;
        adj[1][4] = 1;
        adj[1][7] = 1;
        adj[1][9] = 1;
        adj[2][3] = 1;
        adj[2][6] = 1;
        adj[2][8] = 1;
        adj[3][5] = 1;
        adj[3][7] = 1;
        adj[3][10] = 1;
        adj[4][5] = 1;
        adj[4][6] = 1;
        adj[4][10] = 1;
        adj[5][8] = 1;
        adj[5][9] = 1;
        adj[6][11] = 1;
        adj[7][11] = 1;
        adj[8][11] = 1;
        adj[9][11] = 1;
        adj[10][11] = 1;
    }
}
