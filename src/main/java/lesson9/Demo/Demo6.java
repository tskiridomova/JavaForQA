package lesson9.Demo;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Задачки на стримы
public class Demo6 {

    static class Student {
        public String name;
        public int grade;

        public String getName() {
            return name;
        }

        public int getGrade() {
            return grade;
        }

        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("A", 100), new Student("B", 100), new Student("C", 93));

        students.sort(
            Comparator.comparing(Student::getGrade, Comparator.reverseOrder())
            .thenComparing(student -> student.name)
        );

        students.forEach(System.out::println);
    }
    /*
    Написать функцию
    Которая на вход получает Stream организаций
    Каждая организация содержит список рабочих
    Вернуть необходимо Stream с уникальными именами всех сотрудников, где сотрудников больше 7
    */

    Stream<String> uniqWorkersNames(Stream<Organization> organizationStream) {
        return organizationStream
            .filter(x -> x.getWorkers().size() > 7)
            .map(Organization::getWorkers)
            .flatMap(List::stream)
            .map(Worker::getName)
            .distinct();
    }

    /*
    Нужно написать коллектор, который создаст Map с ключем - ID организации
    а в качестве значения - сама организация
    */

    Map<Integer, Organization> integerOrganizationMap(List<Organization> organizations) {
        return organizations.stream()
            .collect(Collectors.toMap(Organization::getId, org -> org));
    }

    /*
    Нужно написать коллектор, который создаст Map, где ключом будет должность,
    а в качестве значения будет список рабочих, которые занимают эту должность.
    */

    Map<String, List<Worker>> groupWorkersByPosition(List<Worker> workers) {
        return workers.stream()
            .collect(Collectors.groupingBy(Worker::getPosition));
    }

    /*
    Нужно написать коллектор, который создаст Map, где ключом будет должность, а в качестве значения
    будет количество рабочих, которые занимают эту должность.
    */

    Map<String, Long> getCountForPositions(List<Worker> workers) {
        return workers.stream()
            .collect(
                Collectors.groupingBy(Worker::getPosition, Collectors.counting())
            );
    }

    /*
    Нужно написать коллектор, который создаст Map, где ключом будет должность,
    а в качестве значения будет средняя зарплата для этой должности.
    */

    Map<String, Double> getAvgSalaryPerPosition(List<Worker> workers) {
        return workers.stream()
            .collect(
                Collectors.groupingBy(Worker::getPosition, Collectors.averagingDouble(Worker::getSalary))
            );
    }

    interface Organization {
        int getId();
        List<Worker> getWorkers();
    }

    interface Worker {
        String getName();
        String getPosition();
        double getSalary();
    }
}
