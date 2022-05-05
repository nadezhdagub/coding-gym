package data.lab;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private String name;
    private LocalDate dateOfJoinProject;
    private String nameOfProject;

    public Student(String name, LocalDate dateOfJoinProject, String nameOfProject) {
        this.name = name;
        this.dateOfJoinProject = dateOfJoinProject;
        this.nameOfProject = nameOfProject;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfJoinProject() {
        return dateOfJoinProject;
    }

    public String getNameOfProject() {
        return nameOfProject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name" + name + '\'' +
                ", dataOfJoinProject=" + dateOfJoinProject +
                ", nameOfProject=" + nameOfProject + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(dateOfJoinProject, student.dateOfJoinProject) && Objects.equals(nameOfProject, student.nameOfProject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfJoinProject, nameOfProject);
    }
}
