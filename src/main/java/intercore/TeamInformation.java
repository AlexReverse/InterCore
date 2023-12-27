package intercore;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Data
public class TeamInformation {
    private String teamName;
    private String teamCap;
    private String teamCoach;
    private String GamingDiscipline;
    private String dateCreation;
    private String[] vacancy;
    private String srRating;

//    MemberComparator memberComparator = new MemberComparator();
//    private Set<TeamMember> teamMemberSet = new TreeSet<>(memberComparator);
    private List<TeamMember> teamMembers = new ArrayList<>();

    public void addMember(TeamMember teamMember) {
        this.teamMembers.add(teamMember);
        System.out.printf("Пользователь %s - успешно добавлен!", teamMember.getFio());
    }
}
