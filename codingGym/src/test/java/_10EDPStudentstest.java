import data.lab.Student;
import org.junit.jupiter.api.Test;
import workspace.previous.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class _10EDPStudentstest {
    @Test
    public void EDPStudentstest(){
        List<Student> expected = new ArrayList<>();
        Student student1 = new Student("Hanna", LocalDate.of(2021, 03, 23), "edp");
        Student student2 = new Student("Anton", LocalDate.of(2021, 03, 23), "edp");
        Student student3 = new Student("Oleg", LocalDate.of(2021, 06, 4), "edp");
        Student student4 = new Student("Kristina", LocalDate.of(2021, 06, 01), "edp");
        Student student5 = new Student("Marina", LocalDate.of(2021, 07, 01), "edp");
        Student student6 = new Student("Elena", LocalDate.of(2021, 07, 5), "edp");
        Student student7 = new Student("Anatolii", LocalDate.of(2021, 02, 7), "edp");

        expected.add(student1);
        expected.add(student2);
        expected.add(student3);
        expected.add(student4);
        expected.add(student5);
        expected.add(student6);
        expected.add(student7);

        List<Student> actual= Main.getEDPStudents();

        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }
}
