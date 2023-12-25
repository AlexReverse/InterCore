package intercore;

import java.util.Comparator;

class MemberComparator implements Comparator<TeamMember> {

    public int compare(TeamMember a, TeamMember b){

        return a.getRole().compareTo(b.getRole());
    }
}