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
@SessionAttributes("information")
public class InformationController {

    private InformationRepository informationRepository;

    public InformationController(InformationRepository informationRepository) {
        this.informationRepository=informationRepository;
    }

    @GetMapping("/current")
    public String information(){
        return "information";
    }

    @PostMapping
    public String processOrder(@Valid @ModelAttribute("information") MemberInformation information, Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "information";
        }

        informationRepository.save(information);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}