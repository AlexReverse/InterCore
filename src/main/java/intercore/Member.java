package intercore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    private Date createdAt;

    @Size(min = 1, message="Choose discipline!")
    @ManyToMany(targetEntity = Discipline.class)
    private List<Discipline> disciplines;

//    public void addMember(Discipline discipline) {
//        this.disciplines.add(discipline);
//    }
    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }
}