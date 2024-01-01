package intercore.web;

import intercore.MemberInformation;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/information")
@SessionAttributes("memberInformation")
public class InformationController {
    @GetMapping("/current")
    public String informationForm(){
        return "informationForm";
    }

    @PostMapping
    public String processOrder(@Valid MemberInformation memberInformation, Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "informationForm";
        }

        log.info("Player submitted: {}", memberInformation);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
