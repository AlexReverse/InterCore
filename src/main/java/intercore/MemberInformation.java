package intercore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class MemberInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @ManyToOne
    private User user;

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

    @ManyToMany(targetEntity = Member.class)
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        this.members.add(member);
    }

    @PrePersist
    void placedAt(){
        this.placedAt=new Date();
    }
}
