//Hamza Eduard-Mihail, 2A4
package problemandsolution;

import app.School;
import app.Student;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<School, Student> match = new HashMap<>();

    public Map<School, Student> getMatch() {

        return match;

    }

    public void add(Student student, School school)
    {
        match.put(school, student);
    }

    @Override
    public String toString() {

        return "Optional.Solution{" +
                "match=" + match +
                '}';

    }
}
