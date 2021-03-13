//Hamza Eduard-Mihail, 2A4
package Entities;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)
    {
        Student[] students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);

        List<Student> studentList = new LinkedList<>();
        studentList.addAll(Arrays.asList(students));

        System.out.println(studentList);

        List<Student> newSortedList = studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println(newSortedList);

        School[] schools;
        schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i))
                .toArray(School[]::new);

        Set<School> schoolSet = new TreeSet<>();
        schoolSet.addAll(Arrays.asList(schools));

        System.out.println(schoolSet);

        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        stdPrefMap.put(students[0], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[1], Arrays.asList(schools[0], schools[1], schools[2]));
        stdPrefMap.put(students[2], Arrays.asList(schools[0], schools[1]));
        stdPrefMap.put(students[3], Arrays.asList(schools[0], schools[2]));

        Map<School, List<Student>> schPrefMap = new TreeMap<>();
        schPrefMap.put(schools[0], Stream.of(students[3], students[0], students[1], students[2])
                .collect(Collectors.toList()));

        schPrefMap.put(schools[1], Stream.of(studentList.get(0), studentList.get(2), studentList.get(1))
                .collect(Collectors.toList()));

        schPrefMap.put(schools[2], Arrays.asList(students[0], students[1], students[3]));

        System.out.println(stdPrefMap);
        System.out.println(schPrefMap);
    }
}

