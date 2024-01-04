package intercore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Discipline {

    @Id
    private final String id;
    private final String name;
    private final Type type;

    public enum Type{
        DOTA2, CS2, VALORANT, OVERWATCH, RAINBOW6, LOL, SOLOGAMES
    }
}
