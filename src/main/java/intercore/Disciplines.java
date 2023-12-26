package intercore;

import lombok.Data;

@Data
public class Disciplines {
    private final String id;
    private final String role;
    private final Type type;

    public enum Type{
        DOTA2, CS2, VALORANT, OVERWATCH, RAINBOW6, LOL, SOLOGAMES
    }
}
