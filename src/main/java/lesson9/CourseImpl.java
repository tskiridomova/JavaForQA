package lesson9;

class CourseImpl implements Course {
    public String name;

    public CourseImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CourseImpl{" +
                "name='" + name + '\'' +
                '}';
    }
}
