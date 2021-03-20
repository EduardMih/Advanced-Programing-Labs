//Hamza Eduard-Mihail, 2A4
package algorithms;


import app.School;
import app.Student;
import problemandsolution.Problem;
import problemandsolution.Solution;

import java.util.ArrayList;
import java.util.List;

public class GaleShapley implements Algorithm {
    private Problem pb;
    private List<Student> freeStudents;
    private List<School> freeSchools;
    private Solution sol;

    public GaleShapley(Problem pb) {
        this.pb = pb;
        freeStudents = new ArrayList<>(pb.getStudentsList());
        freeSchools = new ArrayList<>(pb.getSchoolsList());
        this.sol = new Solution();
    }

    @Override
    public Solution solve() {
        galeShapley();

        return sol;

    }

    private void galeShapley() {
        School currentSchool;
        Student currentStudent;
        int currentPreference;
        while (!freeStudents.isEmpty()) { //as long as there is an unassigned student
            currentStudent = freeStudents.get(0);
            currentSchool = findNextFreeSchool(currentStudent); //first free school in his list
            pb.getStudentPreference().get(currentStudent).remove(currentSchool);

            if (freeSchools.contains(currentSchool)) { //if school is free
                sol.add(currentStudent, currentSchool);
                freeStudents.remove(currentStudent);
                freeSchools.remove(currentSchool);
            } else {
                currentPreference = pb.getSchoolPreference().get(currentSchool).indexOf(sol.getMatch().get(currentSchool));

                if (pb.getSchoolPreference().get(currentSchool).indexOf(currentStudent) < currentPreference) { //if current student is better then the last in the school's list
                    sol.add(currentStudent, currentSchool);
                    freeStudents.add(sol.getMatch().get(currentSchool));
                    freeStudents.remove(currentStudent);
                }
            }
        }
    }

    private School findNextFreeSchool(Student currentStudent)
    {

        return pb.getStudentPreference().get(currentStudent).stream()
                .filter(school -> freeSchools.contains(school))
                .findFirst().orElse(null);

    }
}
