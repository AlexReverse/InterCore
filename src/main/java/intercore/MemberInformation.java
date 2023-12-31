package intercore;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
public class MemberInformation {

    @NotBlank(message = "Surname is required")
    private String surname;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Speciality is required")
    private String speciality;

    @NotBlank(message = "Rating is required")
    private String rating;

    @NotBlank(message = "Discord ID is required")
    private String discord;

    @Pattern(regexp="^(0[0-3]|1[0-9])([\\/])(0[1-9]|1[0-2])([\\/])([0-9][0-9])$",
            message="Must be formatted MM/YY")
    private String birthday;

    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        this.members.add(member);
        System.out.printf("Пользователь %s - успешно добавлен!", member.getName());
    }
}
