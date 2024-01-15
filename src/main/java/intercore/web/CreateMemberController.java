package intercore.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import intercore.Discipline;
import intercore.Discipline.Type;
import intercore.MemberInformation;
import intercore.Member;
import intercore.data.DisciplineRepository;
import intercore.data.MemberRepository;
import intercore.data.UserRepository;
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
@SessionAttributes("information")
public class CreateMemberController {

    private final DisciplineRepository disciplineRepository;
    private MemberRepository memberRepository;
    private UserRepository userRepository;

    @Autowired
    public CreateMemberController(DisciplineRepository disciplineRepository, MemberRepository memberRepository, UserRepository userRepository) {
        this.disciplineRepository=disciplineRepository;
        this.memberRepository=memberRepository;
        this.userRepository=userRepository;
    }

    @ModelAttribute
    public void addDisciplinesToModel(Model model) {
        List<Discipline> disciplines = new ArrayList<>();
        disciplineRepository.findAll().forEach(i -> disciplines.add(i));

        Type[] types = Discipline.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(disciplines, type));
        }
    }

    @ModelAttribute(name = "information")
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
            @ModelAttribute MemberInformation information) {

        log.info("--- Saving information");

        if (errors.hasErrors()) {
            log.info("--- saving is not successful");
            return "create";
        }

        log.info("--- saved successfully");

        Member saved = memberRepository.save(member);
        information.addMember(saved);

        return "redirect:/information/current";
    }

    private Iterable<Discipline> filterByType(List<Discipline> disciplines, Type type) {
        return disciplines
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}