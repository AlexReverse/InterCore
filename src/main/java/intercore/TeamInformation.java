package intercore;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        this.members.add(member);
        System.out.printf("Пользователь %s - успешно добавлен!", member.getName());
    }
}
