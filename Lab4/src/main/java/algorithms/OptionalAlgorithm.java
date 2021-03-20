//Hamza Eduard-Mihail, 2A4
package algorithms;


import app.School;
import app.Student;
import problemandsolution.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OptionalAlgorithm implements Algorithm{
    private SimpleProblem pb;
    private Map<School, Integer> leftPlaces = new HashMap<>();

    public OptionalAlgorithm(SimpleProblem pb) {
        this.pb = pb;
    }

    @Override
    public Solution solve() {
        Solution solution = new Solution();
        List<Student> sortedStudents;
        School accepted;

        sortedStudents = sortStudentsByScore(); // sort students by score
        pb.getSchoolList().forEach(School -> leftPlaces.put(School, School.getCapacity())); //initialize with full capacity

        for(Student st : sortedStudents) //assign students to wanted schools in order of scores
        {
            accepted = pb.getStudPreference().get(st).stream()
                    .filter(school -> leftPlaces.get(school) > 0)
                    .findFirst()
                    .orElse(null);

            leftPlaces.put(accepted, leftPlaces.get(accepted) - 1);
            solution.add(st, accepted);
        }

        return solution;

    }

    private List<Student> sortStudentsByScore()
    {

        return pb.getStudentList().stream()
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .collect(Collectors.toList());

    }
}
