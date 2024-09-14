package intercore.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @NotNull
    @Size(min=3, message="Nick must be at least 3 characters long")
    private String nick;

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

    @Size(min = 1, message="Choose discipline!")
    @OneToMany(targetEntity = Discipline.class)
    private List<Discipline> disciplines;

    @PrePersist
    void placedAt(){
        this.placedAt=new Date();
    }
}
