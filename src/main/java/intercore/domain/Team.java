package intercore.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 3, message = "Team Name must be at least 3 characters long")
    private String teamName;

    private Boolean cap;
    private Date createdAt;

    //#TODO - референс на type
    private Discipline game;

    @Size(min = 1, message = "Choose members!")
    @ManyToMany(targetEntity = Member.class)
    private List<Member> memberList;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
