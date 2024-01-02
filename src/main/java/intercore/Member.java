package intercore;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Member {

    @NotNull
    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    @NotNull
    @Size(min=1, message="Choose discipline!")
    private List<Discipline> disciplines;

}
