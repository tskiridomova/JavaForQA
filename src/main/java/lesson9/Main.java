package lesson9;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>(Arrays.asList(
                new StudentImpl("Student 1", new ArrayList<>(Arrays.asList(
                        new CourseImpl("Course 1"),
                        new CourseImpl("Course 2"),
                        new CourseImpl("Course 3"),
                        new CourseImpl("Course 4"),
                        new CourseImpl("Course 5")))),
                new StudentImpl("Student 2", new ArrayList<>(Arrays.asList(
                        new CourseImpl("Course 2"),
                        new CourseImpl("Course 4"),
                        new CourseImpl("Course 5")))),
                new StudentImpl("Student 3", new ArrayList<>(Arrays.asList(
                        new CourseImpl("Course 1"),
                        new CourseImpl("Course 3"),
                        new CourseImpl("Course 5")))),
                new StudentImpl("Student 4", new ArrayList<>(Arrays.asList(
                        new CourseImpl("Course 1"),
                        new CourseImpl("Course 2"),
                        new CourseImpl("Course 4"),
                        new CourseImpl("Course 5")))),
                new StudentImpl("Student 5", new ArrayList<>(Arrays.asList(
                        new CourseImpl("Course 4"),
                        new CourseImpl("Course 5")))),
                new StudentImpl("Student 6", new ArrayList<>(Arrays.asList(
                        new CourseImpl("Course 1"),
                        new CourseImpl("Course 10"),
                        new CourseImpl("Course 5"))))
                ));


        System.out.println("Уникальные курсы");
        uniqueCourseNames(students.stream()).forEach(System.out::println);
        System.out.println();

        System.out.println("Любознательные студенты");
        nerds(students.stream()).forEach(System.out::println);
        System.out.println();

        Course course = new CourseImpl("Course 10");
        System.out.println("Студенты посещающие курс" + course.getName());
        participants(students.stream(), course).forEach(System.out::println);



    }

    // Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
    public static Stream<String> uniqueCourseNames(Stream<Student> studentsStream) {
        return studentsStream
                .map(Student::getAllCourses)
                .flatMap(List::stream)
                .map(Course::getName)
                .distinct();
    }


    // Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
    public static Stream<String> nerds(Stream<Student> studentsStream) {
        return studentsStream
                .sorted(Comparator.comparing(Student::getCourseCount, Comparator.reverseOrder()))
                .map(Student::getName)
                .limit(3)
                .distinct();
    }

    // Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
    public static Stream<String> participants(Stream<Student> studentsStream, Course course) {
        return studentsStream
                .filter(student -> student.findCourseByName(course.getName()))
                .map(Student::getName);


    }
}
