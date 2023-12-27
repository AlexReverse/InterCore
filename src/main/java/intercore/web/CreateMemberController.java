package intercore.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import intercore.Discipline;
import intercore.Discipline.Type;
import intercore.TeamInformation;
import intercore.TeamMember;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/create")
@SessionAttributes("teamInformation")
public class CreateMemberController {
    @ModelAttribute
    public void addGamingDisciplineToModel(Model model) {
        List<Discipline> disciplines = Arrays.asList(
                new Discipline("Dota 2", "CARRY", Discipline.Type.DOTA2),
                new Discipline("Dota 2", "MIDLANER", Discipline.Type.DOTA2),
                new Discipline("Dota 2", "OFFLANER", Discipline.Type.DOTA2),
                new Discipline("Dota 2", "ROAMER", Discipline.Type.DOTA2),
                new Discipline("Dota 2", "HARD SUPPORT", Discipline.Type.DOTA2),
                new Discipline("Dota 2", "FLEX", Discipline.Type.DOTA2),

                new Discipline("CS2", "ENTRY FRAGGER", Discipline.Type.CS2),
                new Discipline("CS2", "REFRAGGER", Discipline.Type.CS2),
                new Discipline("CS2", "AWP'ER", Discipline.Type.CS2),
                new Discipline("CS2", "LURKER", Discipline.Type.CS2),
                new Discipline("CS2", "IGL", Discipline.Type.CS2),
                new Discipline("CS2", "FLEX", Discipline.Type.CS2),

                new Discipline("Valorant", "CONTROLLER", Discipline.Type.VALORANT),
                new Discipline("Valorant", "SENTINEL", Discipline.Type.VALORANT),
                new Discipline("Valorant", "INITIATOR", Discipline.Type.VALORANT),
                new Discipline("Valorant", "DUELIST", Discipline.Type.VALORANT),
                new Discipline("Valorant", "FLEX", Discipline.Type.VALORANT),

                new Discipline("Overwatch 2", "TANK", Discipline.Type.OVERWATCH),
                new Discipline("Overwatch 2", "DPS FLEX", Discipline.Type.OVERWATCH),
                new Discipline("Overwatch 2", "DPS HS", Discipline.Type.OVERWATCH),
                new Discipline("Overwatch 2", "DPS PROJECTILE", Discipline.Type.OVERWATCH),
                new Discipline("Overwatch 2", "HEALER FLEX", Discipline.Type.OVERWATCH),
                new Discipline("Overwatch 2", "HEALER MAIN", Discipline.Type.OVERWATCH),
                new Discipline("Overwatch 2", "HEALER OFF", Discipline.Type.OVERWATCH),
                new Discipline("Overwatch 2", "FLEX", Discipline.Type.OVERWATCH),

                new Discipline("Tom Clancy's Rainbow Six Siege", "HARD BREACH", Discipline.Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "HARD BREACH SUPPORT", Discipline.Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "SOFT BREACH", Discipline.Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "ENTRY FRAGGERS", Discipline.Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "DISRUPTORS", Discipline.Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "ANGLE WATCHERS", Discipline.Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "AREA DENIAL", Discipline.Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "INTEL GATHERERS", Discipline.Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "FLEX", Discipline.Type.RAINBOW6),

                new Discipline("League of Legends", "TOP LANE", Discipline.Type.LOL),
                new Discipline("League of Legends", "JUNGLE", Discipline.Type.LOL),
                new Discipline("League of Legends", "MID LANE", Discipline.Type.LOL),
                new Discipline("League of Legends", "BOT LANE", Discipline.Type.LOL),
                new Discipline("League of Legends", "SUPPORT", Discipline.Type.LOL),
                new Discipline("League of Legends", "FLEX", Discipline.Type.LOL),

                new Discipline("FIFA", "Solo Player", Discipline.Type.SOLOGAMES),
                new Discipline("Hearthstone", "Solo Player", Discipline.Type.SOLOGAMES),
                new Discipline("Mortal Kombat", "Solo Player", Discipline.Type.SOLOGAMES)
        );

        Type[] types = Discipline.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(disciplines, type));
        }
    }

    @ModelAttribute(name = "teamInformation")
    public TeamInformation information() {
        return new TeamInformation();
    }

    @ModelAttribute(name = "teamMember")
    public TeamMember teamMember(){
        return new TeamMember();
    }

    @GetMapping
    public String showDesignForm() {
        return "create";
    }

    private Iterable<Discipline> filterByType(List<Discipline> disciplines, Type type) {
        return disciplines
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
