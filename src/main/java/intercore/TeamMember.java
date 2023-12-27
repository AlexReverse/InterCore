package intercore;

import lombok.Data;
import java.util.List;

@Data
public class TeamMember {
    private String fio;
    private String speciality;
    private List<Discipline> gamingDisciplines;
    private String information;
    private String role;
    private String rating;
    private String discord;
}
