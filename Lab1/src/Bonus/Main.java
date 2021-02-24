//Hamza Eduard-Mihail, 2A4, Lab1 Bonus
package Bonus;

import java.util.Arrays;

public class Main {
    private int numberOfVertices;
    private int[][] adj;
    private boolean[] visited;

    public static void main(String[] args) {
        Main mn = new Main();
        int root;

        root = mn.generateTree(6);
        mn.displayTree(root, 0);
    }

    public int generateTree(int n) {
        numberOfVertices = n;

        int k = 1, vert1, vert2, index1, index2, root;
        int[] visited = new int[numberOfVertices];
        int[] unvisited = new int[numberOfVertices];

        adj = new int[numberOfVertices][numberOfVertices];
        //at the beginning all nodes are unvisited
        for (int i = 0; i < numberOfVertices; i++)
            unvisited[i] = i;

        //randomly chose the root
        root = generateNrInRange(0, n);
        visited[0] = unvisited[root];
        deleteFromArray(root, unvisited);


        while (k < numberOfVertices) { //we consider a complete graph, so we can randomly chose any edge between an visited and unvisited vertex
            index1 = generateNrInRange(0, k - 1); //chose an index from visited
            index2 = generateNrInRange(0, n - k); //chose an index from unvisited
            vert1 = visited[index1]; //take the visited vertex corresponding to index1
            vert2 = unvisited[index2]; //take the unvisited vertex corresponding to index2
            visited[k] = vert2; //the unvisited vertex become visited
            deleteFromArray(index2, unvisited);


            adj[vert1][vert2] = 1;
            adj[vert2][vert1] = 1;

            k = k + 1;
        }

        for (int i = 0; i < numberOfVertices; i++)
            System.out.println(Arrays.toString(adj[i]));

        return root;

    }

    public int generateNrInRange(int a, int b) {

        return (int) ((Math.random() * (b - a)) + a);

    }

    public void deleteFromArray(int index, int[] arr) {
        for (int i = index; i < arr.length - 1; i++)
            arr[i] = arr[i + 1];
    }

    public void displayTree(int root, int level) { //recursively print the tree in the specified format
        int k;

        for (int i = 1; i <= level; i++)
            System.out.print(" ");

        k = 0;

        for (int i = 0; i < numberOfVertices; i++) {
            if (adj[root][i] == 1) {
                adj[root][i] = 0;
                adj[i][root] = 0;
                if (k == 0) {
                    System.out.println("+node" + root); //print only once, with + if not leaf
                    k = 1;
                }
                displayTree(i, level + 1);
            }
        }

        if (k == 0)
            System.out.println("-node" + root); //print with - if leaf
    }
}
