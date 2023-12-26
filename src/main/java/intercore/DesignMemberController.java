package intercore;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("disciplines")
public class DesignMemberController {
    @ModelAttribute
    public void addGamingDisciplineToModel(Model model) {
        List<Disciplines> disciplines = Arrays.asList(
                new Disciplines("Dota 2", "CARRY", Disciplines.Type.DOTA2),
                new Disciplines("Dota 2", "MIDLANER", Disciplines.Type.DOTA2),
                new Disciplines("Dota 2", "OFFLANER", Disciplines.Type.DOTA2),
                new Disciplines("Dota 2", "ROAMER", Disciplines.Type.DOTA2),
                new Disciplines("Dota 2", "HARD SUPPORT", Disciplines.Type.DOTA2),
                new Disciplines("Dota 2", "FLEX", Disciplines.Type.DOTA2),

                new Disciplines("CS2", "ENTRY FRAGGER", Disciplines.Type.CS2),
                new Disciplines("CS2", "REFRAGGER", Disciplines.Type.CS2),
                new Disciplines("CS2", "AWP'ER", Disciplines.Type.CS2),
                new Disciplines("CS2", "LURKER", Disciplines.Type.CS2),
                new Disciplines("CS2", "IGL", Disciplines.Type.CS2),
                new Disciplines("CS2", "FLEX", Disciplines.Type.CS2),

                new Disciplines("Valorant", "CONTROLLER", Disciplines.Type.VALORANT),
                new Disciplines("Valorant", "SENTINEL", Disciplines.Type.VALORANT),
                new Disciplines("Valorant", "INITIATOR", Disciplines.Type.VALORANT),
                new Disciplines("Valorant", "DUELIST", Disciplines.Type.VALORANT),
                new Disciplines("Valorant", "FLEX", Disciplines.Type.VALORANT),

                new Disciplines("Overwatch 2", "TANK", Disciplines.Type.OVERWATCH),
                new Disciplines("Overwatch 2", "DPS FLEX", Disciplines.Type.OVERWATCH),
                new Disciplines("Overwatch 2", "DPS HS", Disciplines.Type.OVERWATCH),
                new Disciplines("Overwatch 2", "DPS PROJECTILE", Disciplines.Type.OVERWATCH),
                new Disciplines("Overwatch 2", "HEALER FLEX", Disciplines.Type.OVERWATCH),
                new Disciplines("Overwatch 2", "HEALER MAIN", Disciplines.Type.OVERWATCH),
                new Disciplines("Overwatch 2", "HEALER OFF", Disciplines.Type.OVERWATCH),
                new Disciplines("Overwatch 2", "FLEX", Disciplines.Type.OVERWATCH),

                new Disciplines("Tom Clancy's Rainbow Six Siege", "HARD BREACH", Disciplines.Type.RAINBOW6),
                new Disciplines("Tom Clancy's Rainbow Six Siege", "HARD BREACH SUPPORT", Disciplines.Type.RAINBOW6),
                new Disciplines("Tom Clancy's Rainbow Six Siege", "SOFT BREACH", Disciplines.Type.RAINBOW6),
                new Disciplines("Tom Clancy's Rainbow Six Siege", "ENTRY FRAGGERS", Disciplines.Type.RAINBOW6),
                new Disciplines("Tom Clancy's Rainbow Six Siege", "DISRUPTORS", Disciplines.Type.RAINBOW6),
                new Disciplines("Tom Clancy's Rainbow Six Siege", "ANGLE WATCHERS", Disciplines.Type.RAINBOW6),
                new Disciplines("Tom Clancy's Rainbow Six Siege", "AREA DENIAL", Disciplines.Type.RAINBOW6),
                new Disciplines("Tom Clancy's Rainbow Six Siege", "INTEL GATHERERS", Disciplines.Type.RAINBOW6),
                new Disciplines("Tom Clancy's Rainbow Six Siege", "FLEX", Disciplines.Type.RAINBOW6),

                new Disciplines("League of Legends", "TOP LANE", Disciplines.Type.LOL),
                new Disciplines("League of Legends", "JUNGLE", Disciplines.Type.LOL),
                new Disciplines("League of Legends", "MID LANE", Disciplines.Type.LOL),
                new Disciplines("League of Legends", "BOT LANE", Disciplines.Type.LOL),
                new Disciplines("League of Legends", "SUPPORT", Disciplines.Type.LOL),
                new Disciplines("League of Legends", "FLEX", Disciplines.Type.LOL),

                new Disciplines("FIFA", "Solo Player", Disciplines.Type.SOLOGAMES),
                new Disciplines("Hearthstone", "Solo Player", Disciplines.Type.SOLOGAMES),
                new Disciplines("Mortal Kombat", "Solo Player", Disciplines.Type.SOLOGAMES)
        );

        Disciplines.Type[] types = Disciplines.Type.values();
        for (Disciplines.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(disciplines, type));
        }
    }

    @ModelAttribute(name = "TeamInformation")
    public TeamInformation TeamInformation() {
        return new TeamInformation();
    }

    @ModelAttribute(name = "TeamMember")
    public TeamMember TeamMember(){
        return new TeamMember();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    private Iterable<Disciplines> filterByType(List<Disciplines> disciplines, Disciplines.Type type) {
        return disciplines
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
