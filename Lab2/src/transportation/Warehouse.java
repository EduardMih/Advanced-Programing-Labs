//Hamza Eduard-Mihail, 2A4
package transportation;

public class Warehouse extends Source{
    public Warehouse() {
    }

    public Warehouse(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        return super.equals(o);

    }

    @Override
    public int hashCode() {

        return super.hashCode();

    }
}
