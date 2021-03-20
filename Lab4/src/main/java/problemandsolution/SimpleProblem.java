//Hamza Eduard-Mihail, 2A4
package problemandsolution;

import app.School;
import app.Student;

import java.util.List;
import java.util.Map;

public class SimpleProblem {
    private List<Student> studentList;
    private List<School> schoolList;
    private Map<Student, List<School>> studPreference;

    public SimpleProblem(List<Student> studentList, List<School> schoolList, Map<Student, List<School>> studPreference) {
        this.studentList = studentList;
        this.schoolList = schoolList;
        this.studPreference = studPreference;
    }

    public List<Student> getStudentList() {

        return studentList;

    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<School> getSchoolList() {

        return schoolList;

    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    public Map<Student, List<School>> getStudPreference() {

        return studPreference;

    }

    public void setStudPreference(Map<Student, List<School>> studPreference) {
        this.studPreference = studPreference;
    }
}
