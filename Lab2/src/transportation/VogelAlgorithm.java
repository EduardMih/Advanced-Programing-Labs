//Hamza Eduard-Mihail, 2A4
package transportation;

import java.util.Arrays;

public class VogelAlgorithm extends Algorithm{
    private int leftRows, leftColumn;
    private int[] rowDifference, columnDifference;

    public VogelAlgorithm(Problem pb) {
        super(pb);
        leftColumn = this.costs.length;
        leftRows = this.costs.length;
    }

    @Override
    void computeSolution()
    {
        int k = 0;

        while((leftRows > 1) && (leftColumn > 1))
        {
            findDifferences();
            markMinCell();
        }

        if(leftColumn == 1) //only 1 column left
            solveCol();

        if(leftRows == 1) //only 1 row left
            solveRow();
    }

    private void solveCol()
    {
        /*
        Solving the last column left, by allocating the max supply possible
        on the cells with lower costs.
         */
        int row=0, col=0, minQuantity;

        for(int i = 0; i < demand.length; i++)
            if(demand[i] == 0) //find unsolved column
                col = i;

        while(demand[col] != 0) //column is not solved
        {
            row = findMin(col);
            minQuantity = Math.min(demand[col], supply[row]);
            demand[col] = demand[col] - minQuantity;
            supply[row] = supply[row] - minQuantity;
            leftRows = leftRows - 1;
        }

    }

    private int findMin(int col)
    {
        int min=1000, row=0;

        for(int i = 0; i < costs.length; i++)
            if((costs[i][col] < min) && (supply[i] != 0))
            {
                min= costs[i][col];
                row = i;
            }

        return row;

    }

    private void solveRow()
    {
        /*
        Solving the only row left, by allocating the demand.
         */
        int row=0;

        for(int i = 0; i < supply.length; i++)
            if(supply[i] != 0) //find unsolved row
                row = i;

       for(int i = 0; i < costs[row].length; i++)
       {
           if(demand[i] != 0) //while not solved
           {
               supply[row] = supply[row] - demand[i];
               x[row][i] = demand[i];
               demand[i] = 0;
               leftColumn = leftColumn - 1;
           }
       }
       leftRows = leftRows - 1;
    }

    private void markMinCell()
    {
        int penalty=-1, row=-1, column=-1, minCost=-1, minQuantity;

        //computing penalty
        for(int i = 0; i < rowDifference.length; i++)
        {
            if((rowDifference[i] > penalty) && (supply[i] != 0))
            {
                penalty = rowDifference[i];
                row = i;
                column = -1;
                minCost = costs[i][0];
            }

            if((columnDifference[i] > penalty) && (demand[i] != 0))
            {
                penalty = columnDifference[i];
                row = -1;
                column = i;
                minCost = costs[0][i];
            }
        }

        //find min cost cell corresponding to penalty
        if(row == -1)
        {
            minCost = 10000000;

            System.out.println(Arrays.toString(rowDifference));
            System.out.println(Arrays.toString(columnDifference));
            System.out.println(penalty);

            for (int i = 0; i < costs.length; i++)
                if ((minCost > costs[i][column]) && (supply[i] != 0) && (demand[column] != 0))
                {
                    minCost = costs[i][column];
                    row = i;
                }
        }

        if(column == -1)
        {
            minCost = 1000000;

            for(int i = 0; i < costs.length; i++)
            {
                if((minCost > costs[row][i]) && (supply[row] != 0) && (demand[i] != 0))
                {
                    minCost = costs[row][i];
                    column = i;
                }
            }
        }

        System.out.print("Col" + column);
        System.out.println("ROW" + row);

        //updating supply, demand, result
        minQuantity = Math.min(demand[column], supply[row]);
        System.out.println("MinQ " + minQuantity);
        demand[column] = demand[column] - minQuantity;
        System.out.println("DEM:" + Arrays.toString(demand));
        supply[row] = supply[row] - minQuantity;
        System.out.println("SUP: " + Arrays.toString(supply));
        x[row][column] = minQuantity;

        if(demand[column] == 0)
            leftColumn = leftColumn - 1;

        if(supply[row] == 0)
            leftRows = leftRows - 1;

    }

    private void findDifferences()
    {
        //Computing the abs difference between first and second least costs on each row/column.

        int least=0, secondLeast=0;

        rowDifference = new int[costs.length];
        columnDifference = new int[costs.length];

        for(int i = 0; i < costs.length; i++)
        {
            least = 100;
            secondLeast = 100;

            for (int j = 0; j < costs[i].length; j++)
            {
                if ((costs[i][j] < least) && (supply[i] != 0) && (demand[j] != 0))
                {
                    secondLeast = least;
                    least = costs[i][j];
                }

                else

                    if((costs[i][j] < secondLeast) && (supply[i] != 0) && (demand[j] != 0))
                        secondLeast = costs[i][j];
            }
            rowDifference[i] = Math.abs(least - secondLeast);
        }

        for(int j = 0; j < costs.length; j++)
        {
            least = 100;
            secondLeast = 100;
            for(int i = 0; i < costs[j].length; i++)
            {
                if((costs[i][j] < least) && (supply[i] != 0) && (demand[j] != 0))
                {
                    secondLeast = least;
                    least = costs[i][j];
                }

                else

                    if((costs[i][j] < secondLeast) && (supply[i] != 0) && (demand[j] != 0))
                        secondLeast = costs[i][j];

            }
            columnDifference[j] = Math.abs(least - secondLeast);
        }

        System.out.println("RowDif" + Arrays.toString(rowDifference));
        System.out.println("ColDif" + Arrays.toString(columnDifference));
    }

}
