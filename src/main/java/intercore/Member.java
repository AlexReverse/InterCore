package intercore;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Data
public class Member {

    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;


    @Size(min = 1, message="Choose discipline!")
    private List<Discipline> disciplines;

}