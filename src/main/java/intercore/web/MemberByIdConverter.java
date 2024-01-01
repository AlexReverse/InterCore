package intercore.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import intercore.Discipline;
import intercore.Discipline.Type;


@Component
public class MemberByIdConverter implements Converter<String, Discipline> {
    private Map<String, Discipline> disciplineMap = new HashMap<>();

    public MemberByIdConverter() {
        disciplineMap.put("DOTA2-CARRY", new Discipline("Dota 2", "CARRY", Type.DOTA2));
        disciplineMap.put("DOTA2-MIDLANER", new Discipline("Dota 2", "MIDLANER", Type.DOTA2));
        disciplineMap.put("DOTA2-OFFLANER", new Discipline("Dota 2", "OFFLANER", Type.DOTA2));
        disciplineMap.put("DOTA2-ROAMER", new Discipline("Dota 2", "ROAMER", Type.DOTA2));
        disciplineMap.put("DOTA2-HARD SUPPORT", new Discipline("Dota 2", "HARD SUPPORT", Type.DOTA2));
        disciplineMap.put("DOTA2-FLEX", new Discipline("Dota 2", "FLEX", Type.DOTA2));

        disciplineMap.put("CS2-ENTRY FRAGGER", new Discipline("CS2", "ENTRY FRAGGER", Type.CS2));
        disciplineMap.put("CS2-REFRAGGER", new Discipline("CS2", "REFRAGGER", Type.CS2));
        disciplineMap.put("CS2-AWPER", new Discipline("CS2", "AWP'ER", Type.CS2));
        disciplineMap.put("CS2-LURKER", new Discipline("CS2", "LURKER", Type.CS2));
        disciplineMap.put("CS2-IGL", new Discipline("CS2", "IGL", Type.CS2));
        disciplineMap.put("CS2-FLEX", new Discipline("CS2", "FLEX", Type.CS2));

        disciplineMap.put("Valorant-CONTROLLER", new Discipline("Valorant", "CONTROLLER", Type.VALORANT));
        disciplineMap.put("Valorant-SENTINEL", new Discipline("Valorant", "SENTINEL", Type.VALORANT));
        disciplineMap.put("Valorant-INITIATOR", new Discipline("Valorant", "INITIATOR", Type.VALORANT));
        disciplineMap.put("Valorant-DUELIST", new Discipline("Valorant", "DUELIST", Type.VALORANT));
        disciplineMap.put("Valorant-FLEX", new Discipline("Valorant", "FLEX", Type.VALORANT));

        disciplineMap.put("Overwatch2-TANK", new Discipline("Overwatch 2", "TANK", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-DPSFLEX", new Discipline("Overwatch 2", "DPS FLEX", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-DPSHS", new Discipline("Overwatch 2", "DPS HS", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-DPSPROJECTILE", new Discipline("Overwatch 2", "DPS PROJECTILE", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-HEALERFLEX", new Discipline("Overwatch 2", "HEALER FLEX", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-HEALERMAIN", new Discipline("Overwatch 2", "HEALER MAIN", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-HEALEROFF", new Discipline("Overwatch 2", "HEALER OFF", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-FLEX", new Discipline("Overwatch 2", "FLEX", Type.OVERWATCH));

        disciplineMap.put("RAINBOW6-HARDBREACH", new Discipline("Tom Clancy's Rainbow Six Siege", "HARD BREACH", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-HARDBREACHSUPPORT", new Discipline("Tom Clancy's Rainbow Six Siege", "HARD BREACH SUPPORT", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-SOFTBREACH", new Discipline("Tom Clancy's Rainbow Six Siege", "SOFT BREACH", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-ENTRYFRAGGERS", new Discipline("Tom Clancy's Rainbow Six Siege", "ENTRY FRAGGERS", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-DISRUPTORS", new Discipline("Tom Clancy's Rainbow Six Siege", "DISRUPTORS", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-ANGLEWATCHERS", new Discipline("Tom Clancy's Rainbow Six Siege", "ANGLE WATCHERS", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-AREADENIAL", new Discipline("Tom Clancy's Rainbow Six Siege", "AREA DENIAL", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-INTELGATHERERS", new Discipline("Tom Clancy's Rainbow Six Siege", "INTEL GATHERERS", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-FLEX", new Discipline("Tom Clancy's Rainbow Six Siege", "FLEX", Type.RAINBOW6));

        disciplineMap.put("LOL-TOPLANE", new Discipline("League of Legends", "TOP LANE", Type.LOL));
        disciplineMap.put("LOL-JUNGLE", new Discipline("League of Legends", "JUNGLE", Type.LOL));
        disciplineMap.put("LOL-MIDLANE", new Discipline("League of Legends", "MID LANE", Type.LOL));
        disciplineMap.put("LOL-BOTLANE", new Discipline("League of Legends", "BOT LANE", Type.LOL));
        disciplineMap.put("LOL-SUPPORT", new Discipline("League of Legends", "SUPPORT", Type.LOL));
        disciplineMap.put("LOL-FLEX", new Discipline("League of Legends", "FLEX", Type.LOL));

        disciplineMap.put("FIFA", new Discipline("No team needed", "FIFA", Type.SOLOGAMES));
        disciplineMap.put("Hearthstone", new Discipline("No team needed", "Hearthstone", Type.SOLOGAMES));
        disciplineMap.put("Mortal Kombat", new Discipline("No team needed", "Mortal Kombat", Type.SOLOGAMES));
    }

    @Override
    public Discipline convert(String id){
        return disciplineMap.get(id);
    }

}

