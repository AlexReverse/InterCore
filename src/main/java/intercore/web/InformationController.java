package intercore.web;

import intercore.MemberInformation;
import intercore.User;
import intercore.data.InformationRepository;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/information")
@SessionAttributes("information")
public class InformationController {

    private InformationRepository informationRepository;

    public InformationController(InformationRepository informationRepository) {
        this.informationRepository=informationRepository;
    }

    @GetMapping("/current")
    public String informationForm(){
        return "informationForm";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("information") MemberInformation information, Errors errors,
                               SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "informationForm";
        }

        information.setUser(user);

        informationRepository.save(information);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}