//Hamza Eduard-Mihail, 2A4
package transportation;

public class Factory extends Source{
    public Factory() {
    }

    public Factory(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Factory{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        return super.equals(obj);

    }

    @Override
    public int hashCode() {

        return super.hashCode();

    }
}
