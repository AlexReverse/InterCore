package intercore;

import java.util.List;
import java.util.ArrayList;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class MemberInformation {

    @NotEmpty(message="Surname is required")
    private String surname;

    @NotEmpty(message="Name is required")
    private String realName;

    @NotEmpty(message="Speciality is required")
    private String speciality;

    @NotEmpty(message="Rating is required")
    private String rating;

    @NotEmpty(message="Discord ID is required")
    private String discord;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotEmpty(message="Birthday must be like YYYY-MM-DD")
    private String birthday;

    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        this.members.add(member);
    }
}
