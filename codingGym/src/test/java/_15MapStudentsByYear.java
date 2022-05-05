import data.lab.Lab;
import data.lab.Student;
import org.junit.jupiter.api.Test;
import workspace.previous.Main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _15MapStudentsByYear {

    @Test
    public void separateStudentsByYeartest(){
        Lab lab = new Lab();
        Map<Integer, List<Student>> expected = lab.getProjects().stream()
                .flatMap(project -> project.getStudents().stream())
                .collect(Collectors.groupingBy(student -> student.getDateOfJoinProject().getYear()));

        Map<Integer, List<Student>> actual = Main.separateStudentsByYear();

        assertEquals(expected, actual);
    }
}
