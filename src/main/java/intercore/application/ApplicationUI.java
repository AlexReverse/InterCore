package intercore.application;

import intercore.domain.Member;
import intercore.domain.Teammate;
import intercore.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationUI {
    public void displayInformation(Member information) {
        log.info("RECEIVED PLAYER: " + information);
    }

    public void displayInformation(User information) {
        log.info("RECEIVED PLAYER: " + information);
    }

    public void displayInformation(Teammate information) {
        log.info("RECEIVED PLAYER: " + information);
    }
}
