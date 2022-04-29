package data.formula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Team {

    private String teamName;
    private List<Driver> drivers;
    private long budget;
    private Engine engine;
}
