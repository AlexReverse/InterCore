package intercore;

import lombok.Data;
import java.util.List;

@Data
public class TeamMember {
    private String fio;
    private String speciality;
    private List<Disciplines> gamingDisciplines;
    private String information;
    private String rating;
    private String discord;
}
