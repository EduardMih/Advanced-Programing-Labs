//Hamza Eduard-Mihail, 2A4
package Travel;

import Places.Location;

public class Preference {
    private Location predecessor;
    private Location successor;

    public Preference(Location predecessor, Location successor) {
        this.predecessor = predecessor;
        this.successor = successor;
    }

    public Location getPredecessor() {

        return predecessor;

    }

    public Location getSuccessor() {

        return successor;

    }
}
