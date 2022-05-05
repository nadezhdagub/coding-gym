package lab;

import data.lab.Student;
import org.junit.jupiter.api.Test;
import workspace.previous.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class _12OldestStudentstest {

    @Test
    public void getOldestStudenttest(){
        List<Student> expected = new ArrayList<>();
        Student student7 = new Student("Anatolii", LocalDate.of(2021, 02, 7), "edp");
        Student student8 = new Student("Olga", LocalDate.of(2020, 12, 23), "lama");
        Student student9 = new Student("Ilia", LocalDate.of(2020, 12, 23), "lama");
        expected.add(student7);
        expected.add(student8);
        expected.add(student9);


        List<Student> actual = Main.getOldStudents();

        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }
}
