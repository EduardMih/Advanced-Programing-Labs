//Hamza Eduard-Mihail, 2A4
package transportation;

import java.util.Objects;

public abstract class Source {
    protected String name;

    public Source() {
    }

    public Source(String name) {
        this.name = name;
    }

    public String getName() {

        return name;

    }

    public void setName(String name) {
        if(name == null)
            throw new IllegalArgumentException("!!!NULL argument");
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;

        return Objects.equals(name, source.name);

    }

    @Override
    public int hashCode() {

        return Objects.hash(name);

    }
}
