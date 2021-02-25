//Hamza Eduard-Mihail, 2A4
package transportation;

import java.util.Objects;

public class Source {
    private String name;
    private SourceType type;

    public Source() {
    }

    public Source(String name, SourceType type) {
        this.name = name;
        this.type = type;
    }

    public SourceType getType() {

        return type;

    }

    public void setType(SourceType type) {
        this.type = type;
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
    public String toString() {

        return "Source{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(name, source.name) && type == source.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
