package intercore;

import lombok.Data;
import java.util.List;

@Data
public class Member {
    private String name;
    private List<Discipline> disciplines;
}
