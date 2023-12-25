package intercore;

import lombok.Data;
import java.util.List;

@Data
public class TeamMember {
    private String fio;
    private String role;
    private String speciality;
    private List<GamingDiscipline> gamingDisciplines;
    private String information;
}
