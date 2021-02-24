//Hamza Eduard-Mihail, 2A4 Lab1 Optional
package Optional;


public class Main {
    public static void main(String[] args) {
        int n = 0;

        if (validateArgs(args)) {
            n = Integer.parseInt(args[0]);
            System.out.println(n);

            if (n < 25)
                smallTests(n); //also display the mat

            else

                bigTests(n); //perform calculations, don't display mat but compute execution time
            //Ex: 63877901400(nanoseconds) (with -Xms4G -Xmx8G -Xss5m)

        }

    }

    public static boolean validateArgs(String[] args) {
        int n;

        if (args.length != 1) {
            System.out.println("Must be called with exact 1 param");

            return false;

        }

        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Not valid arg: " + e.getMessage());

            return false;

        }

        return true;

    }

    public static void smallTests(int n) {
        Graph graph = new Graph();

        graph.generateRandomGraph(n);
        graph.displayGraph();

        if (graph.isConnected() == 1) {
            graph.createPartialTree();
            graph.displayPartialTree();
        }
    }

    public static void bigTests(int n) {
        Graph graph = new Graph();
        long t1, t2;

        t1 = System.nanoTime();

        graph.generateRandomGraph(n);

        if (graph.isConnected() == 1)
            graph.createPartialTree();

        t2 = System.nanoTime();
        System.out.println(t2 - t1);
    }
}
