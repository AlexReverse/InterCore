package intercore.web;

import intercore.data.MemberRepository;
import intercore.data.TeammateRepository;
import intercore.domain.Discipline;
import intercore.domain.Member;
import intercore.domain.Teammate;
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

@Slf4j
@Controller
@RequestMapping("/teammate")
@SessionAttributes("teammate")
public class TeammateController {
    private TeammateRepository teammateRepository;
    private MemberRepository memberRepository;

    @Autowired
    public TeammateController(TeammateRepository teammateRepository, MemberRepository memberRepository) {
        this.teammateRepository = teammateRepository;
        this.memberRepository = memberRepository;
    }

    @ModelAttribute(name = "teammate")
    public Teammate teammate() {
        return new Teammate();
    }

    @ModelAttribute
    public void addMembersToModel(Model model, Discipline.Type type) {
        List<Member> members = new ArrayList<>();
        memberRepository.findByDisciplinesIsStartingWith(type).forEach(i -> members.add(i));
        model.addAttribute(members);
    }

    @GetMapping
    public String showTeammateForm() {
        return "teammate";
    }

    @PostMapping
    public String processCreateTeam(@Valid @ModelAttribute("teammate") Teammate team, Errors errors, SessionStatus sessionStatus){
        if (errors.hasErrors()) {
            return "teammate";
        }

        teammateRepository.save(team);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
