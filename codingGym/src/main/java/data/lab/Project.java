package data.lab;

import java.util.List;

public class Project {
    private List<Mentor> mentors;
    private String name;
    private List<Student> students;

    public Project(List<Mentor> mentors, List<Student> students, String name) {
        this.mentors = mentors;
        this.name = name;
        this.students = students;
    }

    public List<Mentor> getMentors() {
        return mentors;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "middle.Project{" +
                "mentors=" + mentors +
                ", students=" + students +
                '}';
    }
}
