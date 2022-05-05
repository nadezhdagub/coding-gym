import org.junit.jupiter.api.Test;
import workspace.previous.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _7CountStudentstes {

    @Test
    public void getCountAllStudentstest(){
        assertEquals(15L, Main.getCountAllStudents());
    }
}
