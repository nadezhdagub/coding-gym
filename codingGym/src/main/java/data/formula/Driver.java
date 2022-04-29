package data.formula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Driver {

    private int number;
    private String name;
    private String nationality;
    private int age;
    private int points;
    private long salary;
}
