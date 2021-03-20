//Hamza Eduard-Mihail, 2A4
package app;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.github.javafaker.Faker;
import problemandsolution.*;
import algorithms.Algorithm;
import algorithms.GaleShapley;
import algorithms.OptionalAlgorithm;


public class Main {
    public static void main(String[] args)
    {
        List<Student> studentList = new LinkedList<>();
        List<Student> newSortedList;
        Set<School> schoolSet = new TreeSet<>();
        School[] schools;
        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        Map<School, List<Student>> schPrefMap = new TreeMap<>();
        Faker faker = new Faker();

        Student[] students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student(faker.funnyName().name()))
                .toArray(Student[]::new);

        System.out.println(Arrays.toString(students));

        studentList.addAll(Arrays.asList(students));
        System.out.println(studentList);

        newSortedList = studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println(newSortedList);

        schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School(faker.university().name()))
                .toArray(School[]::new);

        schoolSet.addAll(Arrays.asList(schools));
        System.out.println(schoolSet);

        stdPrefMap.put(students[0], new ArrayList<>(Arrays.asList(schools[0], schools[1], schools[2])));
        stdPrefMap.put(students[1], new ArrayList<>(Arrays.asList(schools[0], schools[1], schools[2])));
        stdPrefMap.put(students[2], new ArrayList<>(Arrays.asList(schools[0], schools[1])));
        stdPrefMap.put(students[3], new ArrayList<>(Arrays.asList(schools[0], schools[2])));

        schPrefMap.put(schools[0], Stream.of(students[3], students[0], students[1], students[2])
                .collect(Collectors.toList()));

        schPrefMap.put(schools[1], Stream.of(studentList.get(0), studentList.get(2), studentList.get(1))
                .collect(Collectors.toList()));

        schPrefMap.put(schools[2], Stream.of(studentList.get(0), studentList.get(1), studentList.get(3))
                .collect(Collectors.toList()));

        System.out.println(stdPrefMap);
        System.out.println(schPrefMap);

        Problem pr = new Problem(studentList, Arrays.asList(schools), stdPrefMap, schPrefMap);
        pr.printStudentsWhoAccept(Arrays.asList(schools[0], schools[2]));

        System.out.println();
        pr.printSchoolsWithTopStudentPreference(students[0]);
        System.out.println();
        pr.printSchoolsWithTopStudentPreference(students[3]);


        studentList.get(0).setScore(10);
        studentList.get(1).setScore(7);
        studentList.get(2).setScore(9);
        studentList.get(3).setScore(8);

        schools[0].setCapacity(2);
        schools[1].setCapacity(1);
        schools[2].setCapacity(1);
        SimpleProblem pb = new SimpleProblem(studentList, Arrays.asList(schools), stdPrefMap);
        Algorithm alg = new OptionalAlgorithm(pb);
        Solution sol = alg.solve();
        System.out.println(sol);

        alg = new GaleShapley(pr);
        sol = alg.solve();
        System.out.println(sol);

    }
}
