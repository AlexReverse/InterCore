package intercore.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import intercore.Discipline;
import intercore.Discipline.Type;
import intercore.MemberInformation;
import intercore.Member;
import intercore.data.DisciplineRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/create")
@SessionAttributes("memberInformation")
public class CreateMemberController {

    private final DisciplineRepository disciplineRepository;

    @Autowired
    public CreateMemberController(DisciplineRepository disciplineRepository) {
        this.disciplineRepository=disciplineRepository;
    }

    @ModelAttribute
    public void addGamingDisciplineToModel(Model model) {
        List<Discipline> disciplines = new ArrayList<>();
        disciplineRepository.findAll().forEach(i -> disciplines.add(i));

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