import org.junit.jupiter.api.Test;
import workspace.previous.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _13NameOfNewStudenttest {

    @Test
    public void getNameNewStudenttest(){
        String expected = "Ilia";

        assertEquals(expected, Main.getNameNewStudent());
    }
}
