//Hamza Eduard-mihail, 2A4
package problemandsolution;


import app.School;
import app.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem {
    private List<Student> studentsList;
    private List<School> schoolsList;
    private Map<Student, List<School>> studentPreference;
    private Map<School, List<Student>> schoolPreference;

    public Problem(List<Student> studentsList, List<School> schoolsList, Map<Student, List<School>> studentPreference, Map<School, List<Student>> schoolPreference) {
        this.studentsList = studentsList;
        this.schoolsList = schoolsList;
        this.studentPreference = studentPreference;
        this.schoolPreference = schoolPreference;
    }

    public void printStudentsWhoAccept(List<School> schools)
    {
        studentsList.stream()
                .filter(student -> studentPreference.get(student).containsAll(schools))
                .forEach(System.out::println);
    }

    public void printSchoolsWithTopStudentPreference(Student preferred)
    {
        schoolPreference.keySet().stream()
                .filter(school -> schoolPreference.get(school).get(0).equals(preferred))
                .forEach(System.out::println);
    }

    public List<Student> getStudentsList() {

        return studentsList;

    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public List<School> getSchoolsList() {

        return schoolsList;

    }

    public void setSchoolsList(List<School> schoolsList) {
        this.schoolsList = schoolsList;
    }

    public Map<Student, List<School>> getStudentPreference() {

        return studentPreference;

    }

    public void setStudentPreference(Map<Student, List<School>> studentPreference) {
        this.studentPreference = studentPreference;
    }

    public Map<School, List<Student>> getSchoolPreference() {

        return schoolPreference;

    }

    public void setSchoolPreference(Map<School, List<Student>> schoolPreference) {
        this.schoolPreference = schoolPreference;
    }
}
