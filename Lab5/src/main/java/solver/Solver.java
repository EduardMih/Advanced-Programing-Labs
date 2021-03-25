//Hamza Eduard-Mihail, 2A4
package solver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;


public class Solver {
    private Model model;
    private IntVar[] colors;
    private int[] [] adj;
    private Solution solution;

    public Solver(int[][] adj) {
        this.adj = adj;
    }

    public Solution solve()
    {
        model = new Model("Graph-coloring");
        colors = new IntVar[10];
        IntVar nrOfColors = model.intVar(0);

        colors = model.intVarArray("color", 12, 0, 12);

        for(int i = 0; i < adj.length; i++)
            for(int j = 0; j < adj[i].length; j++)
            {
                if(adj[i][j] == 1)
                    model.arithm(colors[i], "!=", colors[j]).post(); //two adjacent nodes can't have the same color
            }


        for(int i = 0; i < colors.length; i++)
            if(colors[i].getValue() > nrOfColors.getValue())
                nrOfColors = colors[i];//used for minimisation


        solution = model.getSolver().findOptimalSolution(nrOfColors, false); //minimise nr of colors

        return solution;

    }
}
