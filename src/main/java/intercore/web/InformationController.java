package intercore.web;

import intercore.MemberInformation;

import intercore.data.InformationRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/information")
@SessionAttributes("memberInformation")
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
    public String processOrder(@Valid @ModelAttribute("memberInformation") MemberInformation memberInformation, Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "informationForm";
        }

        informationRepository.save(memberInformation);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}