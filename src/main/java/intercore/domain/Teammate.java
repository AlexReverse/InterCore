package intercore.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Teammate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 3, message = "Teammate Name must be at least 3 characters long")
    private String teamName;

    @NotNull
    @Size(min = 3, message = "Capitan Name must be at least 3 characters long")
    private String cap;
    private Date createdAt;
    private String game;

    @Size(min = 1, message="Choose Members!")
    @ManyToMany(targetEntity = Member.class)
    private List<Member> member;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
