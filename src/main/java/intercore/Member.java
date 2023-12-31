package intercore;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Member {
    @NotNull
    @Size(min=1, message="Name mast be not null")
    private String name;

    @NotNull
    @Size(min=1, message="Choose discipline!")
    private List<Discipline> disciplines;
}
