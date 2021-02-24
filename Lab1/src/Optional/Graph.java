//Hamza Eduard-Mihail, 2A4, Lab1 Optional

package Optional;


import java.util.Arrays;

public class Graph {
    private int numberOfVertices;
    private int[] [] adj;
    private int[] [] treeAdj;

     public void generateRandomGraph(int n)
     {
         double p, edgeProb;

         adj = new int [n] [n];
         numberOfVertices = n;
         p = Math.random();

         System.out.println("Edge existence probability: " + p);

         for(int i = 0; i < n; i++)
             for(int j = 0; j < i; j++)
             {
                 edgeProb = Math.random();

                 if(edgeProb < p)
                 {
                     adj[i][j] = 1;
                     adj[j][i] = 1;
                 }
             }
     }

     public void displayGraph()
     {
         displayMat(adj);
     }

     public void displayMat(int[] [] adj) //display mat with unicode char
     {
         System.out.print("\u250F"); //border
         for(int i = 0; i < 2 * numberOfVertices - 1; i++)
             System.out.print("\u2501");
         System.out.print("\u2513");
         System.out.println();

         for(int i = 0; i < numberOfVertices; i++)
         {
             System.out.print("\u2503");
             for (int j = 0; j < numberOfVertices; j++)
             {
                 System.out.print(adj[i][j]);
                 System.out.print("\u2503");
             }

             if(i != numberOfVertices - 1)
             {
                 System.out.println();
                 System.out.print("\u2503");
                 for (int j = 0; j < 2 * numberOfVertices - 1; j++)
                     System.out.print("\u2500");
                 System.out.print("\u2503");
                 System.out.println();
             }

             else

                 {
                     System.out.println();
                     System.out.print("\u2517");

                     for (int j = 0; j < 2 * numberOfVertices - 1; j++)
                         System.out.print("\u2501");

                     System.out.print("\u251B");

                 }
         }
         System.out.println();
     }

     public void dfsRec(int root, int currentComponent, int[] visited)
     {
         visited[root] = currentComponent;

         for(int i = 0; i < numberOfVertices; i++)
             if((adj[root][i] == 1) && (visited[i] == 0))
                 dfsRec(i, currentComponent, visited);

     }

     public void displayConnectedComponents(int nrOfComponents, int[] visited)
     {
         for(int i = 1; i <= nrOfComponents; i++)
         {
             System.out.println();
             System.out.println("Component number " + i);

             for(int j = 0; j < numberOfVertices; j++)
                 if(visited[j] == i)
                     System.out.print(j + ",");

                 System.out.println();
         }
     }

     public int isConnected() //check if connected and display components if not
    {
        int currentComponent=0;
        int[] visited = new int[numberOfVertices];

        for(int i = 0; i < numberOfVertices; i++)
        {
            if (visited[i] == 0)
            {
                currentComponent = currentComponent + 1;
                dfsRec(i, currentComponent, visited);
            }
        }

        if(currentComponent != 1)
        {
            displayConnectedComponents(currentComponent,visited);

            return 0;

        }

        else

        {
            System.out.println("Graph is connected!");

            return 1;

        }

    }

    public void createPartialTree() //starts from vertex 0 and for every already visited vertex takes all unvisited neighbours
    {
        int k = 1;
        int[] T = new int[numberOfVertices];
        boolean[] visited = new boolean[numberOfVertices];

        treeAdj = new int[numberOfVertices] [numberOfVertices];
        T[0] = 0;
        visited[0] = true;

        while(k < numberOfVertices)
        {
            for(int i = 0; i < k; i++)
                for (int j = 0; j < numberOfVertices; j++)
                    if ((adj[T[i]][j] == 1) && (!visited[j])) {
                        visited[j] = true;
                        T[k] = j;
                        treeAdj[T[i]][j] = 1;
                        treeAdj[j][T[i]] = 1;
                        k = k + 1;
                    }

        }
    }

    public void displayPartialTree()
    {
        displayMat(treeAdj);
    }

}
