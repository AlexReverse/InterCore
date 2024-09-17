package intercore.web;

import intercore.data.MemberRepository;
import intercore.data.TeammateRepository;
import intercore.domain.Discipline;
import intercore.domain.Teammate;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

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

    @ModelAttribute(value = "member")
    public void addMembersToModel(Model model) {
        Discipline.Type[] types = Discipline.Type.values();
        for (Discipline.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), memberRepository.findByMember(String.valueOf(type)));
        }
    }

    @GetMapping
    public String showTeammateForm() {
        return "teammate";
    }

    @PostMapping
    public String processCreateTeam(@Valid @ModelAttribute("teammate") Teammate team, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "teammate";
        }

        updateOnTeam(team);

        teammateRepository.save(team);
        sessionStatus.setComplete();

        return "redirect:/";
    }

    @Transactional
    public void updateOnTeam(Teammate teammate) {
        for (int i = 0; i < teammate.getMember().size(); i++) {
            memberRepository.updateOnTeam(teammate.getMember().get(i).getId());
        }
    }
}
