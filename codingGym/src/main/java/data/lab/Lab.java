package data.lab;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lab {
    List<Student> edpStudents = new ArrayList<>();
    List<Student> lamaStudents = new ArrayList<>();
    List<Student> beaconStudents = new ArrayList<>();
    List<Mentor> edpMentors = new ArrayList<>();
    List<Mentor> beaconMentors = new ArrayList<>();
    List<Mentor> lamaMentors = new ArrayList<>();
    List<Project> projects = new ArrayList<>();

    private void createStudents(){
        Student student1 = new Student("Hanna", LocalDate.of(2021, 03, 23), "edp");
        Student student2 = new Student("Anton", LocalDate.of(2021, 03, 23), "edp");
        Student student3 = new Student("Oleg", LocalDate.of(2021, 06, 4), "edp");
        Student student4 = new Student("Kristina", LocalDate.of(2021, 06, 01), "edp");
        Student student5 = new Student("Marina", LocalDate.of(2021, 07, 01), "edp");
        Student student6 = new Student("Elena", LocalDate.of(2021, 07, 5), "edp");
        Student student7 = new Student("Anatolii", LocalDate.of(2021, 02, 7), "edp");
        Student student8 = new Student("Olga", LocalDate.of(2020, 12, 23), "lama");
        Student student9 = new Student("Ilia", LocalDate.of(2020, 12, 23), "lama");
        Student student10 = new Student("Aleksandr", LocalDate.of(2021, 04, 01), "lama");
        Student student11 = new Student("Hanna", LocalDate.of(2021, 05, 05), "lama");
        Student student12 = new Student("Aleksandr", LocalDate.of(2021, 05, 23), "lama");
        Student student13 = new Student("Kseniia", LocalDate.of(2021, 03, 6), "beacon");
        Student student14 = new Student("Elena", LocalDate.of(2021, 04, 23), "beacon");
        Student student15 = new Student("Ilia", LocalDate.of(2021, 07, 23), "beacon");

        edpStudents.add(student1);
        edpStudents.add(student2);
        edpStudents.add(student3);
        edpStudents.add(student4);
        edpStudents.add(student5);
        edpStudents.add(student6);
        edpStudents.add(student7);
        lamaStudents.add(student8);
        lamaStudents.add(student9);
        lamaStudents.add(student10);
        lamaStudents.add(student11);
        lamaStudents.add(student12);
        beaconStudents.add(student13);
        beaconStudents.add(student14);
        beaconStudents.add(student15);
    }

    private void createMentors(){
        Mentor mentor1 = new Mentor(1, "Artem", "backend");
        Mentor mentor2 = new Mentor(2, "Sasha", "backend");
        Mentor mentor3 = new Mentor(3, "Pavel", "frontend");
        Mentor mentor4 = new Mentor(4, "Sasha", "frontend");
        Mentor mentor5 = new Mentor(5, "Alina", "frontend");
        Mentor mentor6 = new Mentor(6, "Nikita", "backend");
        Mentor mentor7 = new Mentor(7, "Slava", "backend");
        Mentor mentor8 = new Mentor(8, "Anna", "backend");

        edpMentors.add(mentor1);
        edpMentors.add(mentor2);
        edpMentors.add(mentor3);
        beaconMentors.add(mentor4);
        beaconMentors.add(mentor5);
        lamaMentors.add(mentor6);
        lamaMentors.add(mentor7);
        lamaMentors.add(mentor8);
    }

    private void createProjects(){
        Project edp = new Project(edpMentors, edpStudents, "edp");
        Project beacons = new Project(beaconMentors, beaconStudents, "beacons");
        Project lama = new Project(lamaMentors, lamaStudents, "lama");

        projects.add(edp);
        projects.add(beacons);
        projects.add(lama);
    }

    public Lab() {
        createStudents();
        createMentors();
        createProjects();
    }

    public List<Project> getProjects() {
        return projects;
    }
}
