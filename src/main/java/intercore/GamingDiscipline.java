package intercore;

import lombok.Data;

@Data
public class GamingDiscipline {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type{
        DOTA2, CS2, VALORANT, OVERWATCH, RAINBOW6, LOL, FIFA, HEARTHSTONE
    }
}
