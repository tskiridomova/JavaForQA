package lesson9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StudentImpl implements Student {

    public String name;
    public List<Course> courseList;

    public StudentImpl(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }

    @Override
    public boolean findCourseByName(String name) {
        return courseList.stream()
                .map(Course::getName)
                .collect(Collectors.toList()).contains(name);

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courseList;
    }

    @Override
    public Integer getCourseCount() {
        return this.getAllCourses().size();
    }
}
