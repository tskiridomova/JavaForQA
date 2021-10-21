package lesson9;

import java.util.List;
import java.util.stream.Stream;

interface Student {
    String getName();
    List<Course> getAllCourses();
    Integer getCourseCount();
    boolean findCourseByName(String name);
}
