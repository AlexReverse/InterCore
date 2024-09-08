package intercore.web;

import intercore.data.DisciplineRepository;
import intercore.data.MemberRepository;
import intercore.domain.Discipline;
import intercore.domain.Member;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/member")
@SessionAttributes("member")
public class MemberController {
    private MemberRepository memberRepository;
    private DisciplineRepository disciplineRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository, DisciplineRepository disciplineRepository) {
        this.memberRepository=memberRepository;
        this.disciplineRepository=disciplineRepository;
    }

    @ModelAttribute(name = "member")
    public Member member(){
        return new Member();
    }

    @ModelAttribute
    public void addDisciplinesToModel(Model model) {
        List<Discipline> disciplines = new ArrayList<>();
        disciplineRepository.findAll().forEach(i -> disciplines.add(i));

        Discipline.Type[] types = Discipline.Type.values();
        for (Discipline.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(disciplines, type));
        }
    }
    private Iterable<Discipline> filterByType(List<Discipline> disciplines, Discipline.Type type) {
        return disciplines
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @GetMapping
    public String showMemberForm() {
        return "member";
    }

    @PostMapping
    public String processCreateMember(@Valid @ModelAttribute("member") Member member, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "member";
        }

        memberRepository.save(member);
        sessionStatus.setComplete();

        return "redirect:/";
    }

}
