import org.junit.jupiter.api.Test;
import workspace.previous.Animal;
import workspace.previous.Main;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class _5Dogstest {

    @Test
    public void getDogstest(){
        List<Animal> expected = new ArrayList<>();
        Animal animal4 = new Animal("Chappy", "black", "dog");
        Animal animal5 = new Animal("Bruno", "orange", "dog");
        Animal animal9 = new Animal(null, "white", "dog");

        expected.add(animal4);
        expected.add(animal5);
        expected.add(animal9);

        List<Animal> actual = Main.getDogs();

        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));

    }
}
