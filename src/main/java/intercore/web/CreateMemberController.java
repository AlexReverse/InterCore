package intercore.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import intercore.Discipline;
import intercore.Discipline.Type;
import intercore.TeamInformation;
import intercore.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/create")
@SessionAttributes("teamInformation")
public class CreateMemberController {
    @ModelAttribute
    public void addGamingDisciplineToModel(Model model) {
        List<Discipline> disciplines = Arrays.asList(
                new Discipline("Dota 2", "CARRY", Type.DOTA2),
                new Discipline("Dota 2", "MIDLANER", Type.DOTA2),
                new Discipline("Dota 2", "OFFLANER", Type.DOTA2),
                new Discipline("Dota 2", "ROAMER", Type.DOTA2),
                new Discipline("Dota 2", "HARD SUPPORT", Type.DOTA2),
                new Discipline("Dota 2", "FLEX", Discipline.Type.DOTA2),

                new Discipline("CS2", "ENTRY FRAGGER", Type.CS2),
                new Discipline("CS2", "REFRAGGER", Type.CS2),
                new Discipline("CS2", "AWP'ER", Type.CS2),
                new Discipline("CS2", "LURKER", Type.CS2),
                new Discipline("CS2", "IGL", Type.CS2),
                new Discipline("CS2", "FLEX", Type.CS2),

                new Discipline("Valorant", "CONTROLLER", Type.VALORANT),
                new Discipline("Valorant", "SENTINEL", Type.VALORANT),
                new Discipline("Valorant", "INITIATOR", Type.VALORANT),
                new Discipline("Valorant", "DUELIST", Type.VALORANT),
                new Discipline("Valorant", "FLEX", Type.VALORANT),

                new Discipline("Overwatch 2", "TANK", Type.OVERWATCH),
                new Discipline("Overwatch 2", "DPS FLEX", Type.OVERWATCH),
                new Discipline("Overwatch 2", "DPS HS", Type.OVERWATCH),
                new Discipline("Overwatch 2", "DPS PROJECTILE", Type.OVERWATCH),
                new Discipline("Overwatch 2", "HEALER FLEX", Type.OVERWATCH),
                new Discipline("Overwatch 2", "HEALER MAIN", Type.OVERWATCH),
                new Discipline("Overwatch 2", "HEALER OFF", Type.OVERWATCH),
                new Discipline("Overwatch 2", "FLEX", Type.OVERWATCH),

                new Discipline("Tom Clancy's Rainbow Six Siege", "HARD BREACH", Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "HARD BREACH SUPPORT", Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "SOFT BREACH", Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "ENTRY FRAGGERS", Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "DISRUPTORS", Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "ANGLE WATCHERS", Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "AREA DENIAL", Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "INTEL GATHERERS", Type.RAINBOW6),
                new Discipline("Tom Clancy's Rainbow Six Siege", "FLEX", Type.RAINBOW6),

                new Discipline("League of Legends", "TOP LANE", Type.LOL),
                new Discipline("League of Legends", "JUNGLE", Type.LOL),
                new Discipline("League of Legends", "MID LANE", Type.LOL),
                new Discipline("League of Legends", "BOT LANE", Type.LOL),
                new Discipline("League of Legends", "SUPPORT", Type.LOL),
                new Discipline("League of Legends", "FLEX", Type.LOL),

                new Discipline("No team needed", "FIFA", Type.SOLOGAMES),
                new Discipline("No team needed", "Hearthstone", Type.SOLOGAMES),
                new Discipline("No team needed", "Mortal Kombat", Type.SOLOGAMES)
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

    @ModelAttribute(name = "member")
    public Member member(){
        return new Member();
    }

    @GetMapping
    public String showCreateForm() {
        return "create";
    }

    @PostMapping
    public String processMember(
            @Valid Member member, Errors errors,
            @ModelAttribute TeamInformation teamInformation) {

        if (errors.hasErrors()) {
            return "create";
        }

        teamInformation.addMember(member);
        log.info("Processing member: {}", member);

        return "redirect:/member/current";
    }
    private Iterable<Discipline> filterByType(List<Discipline> disciplines, Type type) {
        return disciplines
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
