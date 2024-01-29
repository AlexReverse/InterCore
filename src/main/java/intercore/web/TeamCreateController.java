package intercore.web;

import intercore.data.TeamRepository;
import intercore.domain.Member;
import intercore.domain.Team;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/team")
@SessionAttributes("team")
public class TeamCreateController {
    private TeamRepository teamRepository;
    private Team team;

    public TeamCreateController(TeamRepository teamRepository, Team team) {
        this.team = team;
        this.teamRepository = teamRepository;
    }

    @PostMapping
    public String processCreateTeam(@Valid @ModelAttribute("team") Team team, Errors errors, SessionStatus sessionStatus){
        if (errors.hasErrors()) {
            return "team";
        }

        teamRepository.save(team);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
