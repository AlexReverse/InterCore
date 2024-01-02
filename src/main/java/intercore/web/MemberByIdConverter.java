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
        disciplineMap.put("DOTA2-CARRY", new Discipline("DOTA2-CARRY", "CARRY", Type.DOTA2));
        disciplineMap.put("DOTA2-MIDLANER", new Discipline("DOTA2-MIDLANER", "MIDLANER", Type.DOTA2));
        disciplineMap.put("DOTA2-OFFLANER", new Discipline("DOTA2-OFFLANER", "OFFLANER", Type.DOTA2));
        disciplineMap.put("DOTA2-ROAMER", new Discipline("DOTA2-ROAMER", "ROAMER", Type.DOTA2));
        disciplineMap.put("DOTA2-HARD SUPPORT", new Discipline("DOTA2-HARDSUPPORT", "HARD SUPPORT", Type.DOTA2));
        disciplineMap.put("DOTA2-FLEX", new Discipline("DOTA2-FLEX", "FLEX", Type.DOTA2));

        disciplineMap.put("CS2-ENTRYFRAGGER", new Discipline("CS2-ENTRYFRAGGER", "ENTRY FRAGGER", Type.CS2));
        disciplineMap.put("CS2-REFRAGGER", new Discipline("CS2-REFRAGGER", "REFRAGGER", Type.CS2));
        disciplineMap.put("CS2-AWPER", new Discipline("CS2-AWPER", "AWP'ER", Type.CS2));
        disciplineMap.put("CS2-LURKER", new Discipline("CS2-LURKER", "LURKER", Type.CS2));
        disciplineMap.put("CS2-IGL", new Discipline("CS2-IGL", "IGL", Type.CS2));
        disciplineMap.put("CS2-FLEX", new Discipline("CS2-FLEX", "FLEX", Type.CS2));

        disciplineMap.put("Valorant-CONTROLLER", new Discipline("Valorant-CONTROLLER", "CONTROLLER", Type.VALORANT));
        disciplineMap.put("Valorant-SENTINEL", new Discipline("Valorant-SENTINEL", "SENTINEL", Type.VALORANT));
        disciplineMap.put("Valorant-INITIATOR", new Discipline("Valorant-INITIATOR", "INITIATOR", Type.VALORANT));
        disciplineMap.put("Valorant-DUELIST", new Discipline("Valorant-DUELIST", "DUELIST", Type.VALORANT));
        disciplineMap.put("Valorant-FLEX", new Discipline("Valorant-FLEX", "FLEX", Type.VALORANT));

        disciplineMap.put("Overwatch2-TANK", new Discipline("Overwatch2-TANK", "TANK", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-DPSFLEX", new Discipline("Overwatch2-DPSFLEX", "DPS FLEX", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-DPSHS", new Discipline("Overwatch2-DPSHS", "DPS HS", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-DPSPROJECTILE", new Discipline("Overwatch2-DPSPROJECTILE", "DPS PROJECTILE", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-HEALERFLEX", new Discipline("Overwatch2-HEALERFLEX", "HEALER FLEX", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-HEALERMAIN", new Discipline("Overwatch2-HEALERMAIN", "HEALER MAIN", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-HEALEROFF", new Discipline("Overwatch2-HEALEROFF", "HEALER OFF", Type.OVERWATCH));
        disciplineMap.put("Overwatch2-FLEX", new Discipline("Overwatch2-FLEX", "FLEX", Type.OVERWATCH));

        disciplineMap.put("RAINBOW6-HARDBREACH", new Discipline("RAINBOW6-HARDBREACH", "HARD BREACH", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-HARDBREACHSUPPORT", new Discipline("RAINBOW6-HARDBREACHSUPPORT", "HARD BREACH SUPPORT", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-SOFTBREACH", new Discipline("RAINBOW6-SOFTBREACH", "SOFT BREACH", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-ENTRYFRAGGERS", new Discipline("RAINBOW6-ENTRYFRAGGERS", "ENTRY FRAGGERS", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-DISRUPTORS", new Discipline("RAINBOW6-DISRUPTORS", "DISRUPTORS", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-ANGLEWATCHERS", new Discipline("RAINBOW6-ANGLEWATCHERS", "ANGLE WATCHERS", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-AREADENIAL", new Discipline("RAINBOW6-AREADENIAL", "AREA DENIAL", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-INTELGATHERERS", new Discipline("RAINBOW6-INTELGATHERERS", "INTEL GATHERERS", Type.RAINBOW6));
        disciplineMap.put("RAINBOW6-FLEX", new Discipline("RAINBOW6-FLEX", "FLEX", Type.RAINBOW6));

        disciplineMap.put("LOL-TOPLANE", new Discipline("LOL-TOPLANE", "TOP LANE", Type.LOL));
        disciplineMap.put("LOL-JUNGLE", new Discipline("LOL-JUNGLE", "JUNGLE", Type.LOL));
        disciplineMap.put("LOL-MIDLANE", new Discipline("LOL-MIDLANE", "MID LANE", Type.LOL));
        disciplineMap.put("LOL-BOTLANE", new Discipline("LOL-BOTLANE", "BOT LANE", Type.LOL));
        disciplineMap.put("LOL-SUPPORT", new Discipline("LOL-SUPPORT", "SUPPORT", Type.LOL));
        disciplineMap.put("LOL-FLEX", new Discipline("LOL-FLEX", "FLEX", Type.LOL));

        disciplineMap.put("FIFA", new Discipline("FIFA", "FIFA", Type.SOLOGAMES));
        disciplineMap.put("Hearthstone", new Discipline("Hearthstone", "Hearthstone", Type.SOLOGAMES));
        disciplineMap.put("Mortal Kombat", new Discipline("Mortal Kombat", "Mortal Kombat", Type.SOLOGAMES));
    }

    @Override
    public Discipline convert(String id){
        return disciplineMap.get(id);
    }

}

