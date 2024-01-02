package intercore.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import intercore.Discipline;
import intercore.Discipline.Type;
import intercore.MemberInformation;
import intercore.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/create")
@SessionAttributes("memberInformation")
public class CreateMemberController {
    @ModelAttribute
    public void addGamingDisciplineToModel(Model model) {
        List<Discipline> disciplines = Arrays.asList(
                new Discipline("DOTA2-CARRY", "CARRY", Type.DOTA2),
                new Discipline("DOTA2-MIDLANER", "MIDLANER", Type.DOTA2),
                new Discipline("DOTA2-OFFLANER", "OFFLANER", Type.DOTA2),
                new Discipline("DOTA2-ROAMER", "ROAMER", Type.DOTA2),
                new Discipline("DOTA2-HARDSUPPORT", "HARD SUPPORT", Type.DOTA2),
                new Discipline("DOTA2-FLEX", "FLEX", Type.DOTA2),

                new Discipline("CS2-ENTRYFRAGGER", "ENTRY FRAGGER", Type.CS2),
                new Discipline("CS2-REFRAGGER", "REFRAGGER", Type.CS2),
                new Discipline("CS2-AWPER", "AWP'ER", Type.CS2),
                new Discipline("CS2-LURKER", "LURKER", Type.CS2),
                new Discipline("CS2-IGL", "IGL", Type.CS2),
                new Discipline("CS2-FLEX", "FLEX", Type.CS2),

                new Discipline("Valorant-CONTROLLER", "CONTROLLER", Type.VALORANT),
                new Discipline("Valorant-SENTINEL", "SENTINEL", Type.VALORANT),
                new Discipline("Valorant-INITIATOR", "INITIATOR", Type.VALORANT),
                new Discipline("Valorant-DUELIST", "DUELIST", Type.VALORANT),
                new Discipline("Valorant-FLEX", "FLEX", Type.VALORANT),

                new Discipline("Overwatch2-TANK", "TANK", Type.OVERWATCH),
                new Discipline("Overwatch2-DPSFLEX", "DPS FLEX", Type.OVERWATCH),
                new Discipline("Overwatch2-DPSHS", "DPS HS", Type.OVERWATCH),
                new Discipline("Overwatch2-DPSPROJECTILE", "DPS PROJECTILE", Type.OVERWATCH),
                new Discipline("Overwatch2-HEALERFLEX", "HEALER FLEX", Type.OVERWATCH),
                new Discipline("Overwatch2-HEALERMAIN", "HEALER MAIN", Type.OVERWATCH),
                new Discipline("Overwatch2-HEALEROFF", "HEALER OFF", Type.OVERWATCH),
                new Discipline("Overwatch2-FLEX", "FLEX", Type.OVERWATCH),

                new Discipline("RAINBOW6-HARDBREACH", "HARD BREACH", Type.RAINBOW6),
                new Discipline("RAINBOW6-HARDBREACHSUPPORT", "HARD BREACH SUPPORT", Type.RAINBOW6),
                new Discipline("RAINBOW6-SOFTBREACH", "SOFT BREACH", Type.RAINBOW6),
                new Discipline("RAINBOW6-ENTRYFRAGGERS", "ENTRY FRAGGERS", Type.RAINBOW6),
                new Discipline("RAINBOW6-DISRUPTORS", "DISRUPTORS", Type.RAINBOW6),
                new Discipline("RAINBOW6-ANGLEWATCHERS", "ANGLE WATCHERS", Type.RAINBOW6),
                new Discipline("RAINBOW6-AREADENIAL", "AREA DENIAL", Type.RAINBOW6),
                new Discipline("RAINBOW6-INTELGATHERERS", "INTEL GATHERERS", Type.RAINBOW6),
                new Discipline("RAINBOW6-FLEX", "FLEX", Type.RAINBOW6),

                new Discipline("LOL-TOPLANE", "TOP LANE", Type.LOL),
                new Discipline("LOL-JUNGLE", "JUNGLE", Type.LOL),
                new Discipline("LOL-MIDLANE", "MID LANE", Type.LOL),
                new Discipline("LOL-BOTLANE", "BOT LANE", Type.LOL),
                new Discipline("LOL-SUPPORT", "SUPPORT", Type.LOL),
                new Discipline("LOL-FLEX", "FLEX", Type.LOL),

                new Discipline("FIFA", "FIFA", Type.SOLOGAMES),
                new Discipline("Hearthstone", "Hearthstone", Type.SOLOGAMES),
                new Discipline("Mortal Kombat", "Mortal Kombat", Type.SOLOGAMES)
        );

        Type[] types = Discipline.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(disciplines, type));
        }
    }

    @ModelAttribute(name = "memberInformation")
    public MemberInformation information() {
        return new MemberInformation();
    }

    @ModelAttribute(name = "member")
    public Member member() {
        return new Member();
    }

    @GetMapping
    public String showCreateForm() {
        return "create";
    }

    @PostMapping
    public String processMember(
            @Valid Member member, Errors errors,
            @ModelAttribute MemberInformation memberInformation) {

        if (errors.hasErrors()) {
            return "create";
        }

        memberInformation.addMember(member);
        log.info("Processing member: {}", member);

        return "redirect:/information/current";
    }

    private Iterable<Discipline> filterByType(List<Discipline> disciplines, Type type) {
        return disciplines
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
