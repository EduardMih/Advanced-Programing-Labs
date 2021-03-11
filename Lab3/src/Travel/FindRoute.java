//Hamza Eduard-Mihail, 2A4
package Travel;

import Places.Location;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindRoute {
    private TravelPlan plan;
    private int minCost;
    private int[][] dagAdj;
    private int[] inDegree;

    public FindRoute(TravelPlan plan) {
        this.plan = plan;
    }

    public void solve() {
        minCost = Integer.MAX_VALUE;
        createDagAdj(); //create preferences DAG
        generateAllTopologicalSort();
        System.out.println(minCost);

    }

    private void createDagAdj() {
        //create DAG for preferences
        int nrOfVertices, indexOfPred, indexOfSucc;

        nrOfVertices = plan.getCurrentCity().getNodes().size();
        dagAdj = new int[nrOfVertices][nrOfVertices];
        inDegree = new int[nrOfVertices];

        for (Preference pf : plan.getPreferences()) {
            indexOfPred = plan.getCurrentCity().getNodes().indexOf(pf.getPredecessor());
            indexOfSucc = plan.getCurrentCity().getNodes().indexOf(pf.getSuccessor());

            dagAdj[indexOfPred][indexOfSucc] = 1;
            inDegree[indexOfSucc] = inDegree[indexOfSucc] + 1;
        }

        System.out.println(Arrays.toString(inDegree));
        System.out.println(Arrays.deepToString(dagAdj));
    }

    private void generateAllTopologicalSort()
    {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[plan.getCurrentCity().getNodes().size()];

        topologicalSort(visited, result);
    }

    private void topologicalSort(boolean[] visited, List<Integer> result)
    {
        //create a list(results) with index of every node in topological order
        int nrOfVertices = plan.getCurrentCity().getNodes().size();
        boolean sortFound = false;

        for(int i = 0; i < nrOfVertices; i++)
        {
            if((!visited[i]) && (inDegree[i] == 0))
            {
                visited[i] = true;
                result.add(i);

                for(int j = 0; j < dagAdj.length; j++)
                    if(dagAdj[i][j] == 1)
                        inDegree[j] = inDegree[j] - 1;

                topologicalSort(visited, result);

                visited[i] = false;
                result.remove(result.size() - 1);

                for(int j = 0; j < dagAdj.length; j++)
                    if(dagAdj[i][j] == 1)
                        inDegree[j] = inDegree[j] + 1;

                sortFound = true;

            }
        }

        if(!sortFound)
        {
            System.out.println(result.toString());
            dijkstraForDags(result);
        }
    }

    private void dijkstraForDags(List<Integer> results)
    {
        //compute shortest distance using only neighbours that are ahead in topological sort order
        int nrOfVertices = results.size();
        int indexOfNeighbour;
        int currentDist;
        int[] dist = new int[nrOfVertices];
        boolean[] visited = new boolean[nrOfVertices];
        Location currentLocation;

        for(int i = 0; i < nrOfVertices; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[plan.getCurrentCity().getNodes().indexOf(plan.getStartPoint())] = 0;
        System.out.println(Arrays.toString(dist));

        for(int i = 0; i < nrOfVertices; i++)
        {
            visited[results.get(i)] = true;
            currentLocation = plan.getCurrentCity().getNodes().get(results.get(i));

            for(Location neighbour : currentLocation.getCost().keySet())
            {
                indexOfNeighbour = plan.getCurrentCity().getNodes().indexOf(neighbour);

                if((!visited[indexOfNeighbour]) && (dist[indexOfNeighbour] > dist[results.get(i)] + currentLocation.getCost().get(neighbour)))
                    dist[indexOfNeighbour] = dist[results.get(i)] + currentLocation.getCost().get(neighbour);

            }
        }
        System.out.println(Arrays.toString(dist));
        currentDist = dist[plan.getCurrentCity().getNodes().indexOf(plan.getEndPoint())];
        if((currentDist < minCost) && (currentDist > 0))
            minCost = currentDist;

    }

}
