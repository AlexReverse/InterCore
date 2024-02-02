package intercore.web;

import intercore.data.TeammateRepository;
import intercore.domain.Teammate;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/teammate")
@SessionAttributes("teammate")
public class TeammateController {
    private TeammateRepository teammateRepository;

    @Autowired
    public TeammateController(TeammateRepository teammateRepository) {
        this.teammateRepository = teammateRepository;
    }

    @ModelAttribute
    public Teammate teammate() {
        return new Teammate();
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
