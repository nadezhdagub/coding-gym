import data.lab.Lab;
import data.lab.Student;
import org.junit.jupiter.api.Test;
import workspace.previous.Main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _9MapProjectNameAndStudents {

    @Test
    public void getStudentsByProjecttest(){
        Lab lab = new Lab();
        Map<String, List<Student>> expected = lab.getProjects().stream()
                .collect(Collectors.toMap(project -> project.getName(), project -> project.getStudents()));

        Map<String, List<Student>> actual = Main.getStudentsByProject();

        assertEquals(expected, actual);
    }
}
