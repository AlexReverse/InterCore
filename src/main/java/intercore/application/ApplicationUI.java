package intercore.application;

import intercore.domain.MemberInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationUI {
    public void displayInformation(MemberInformation information) {
        log.info("RECEIVED PLAYER: " + information);
    }
}
