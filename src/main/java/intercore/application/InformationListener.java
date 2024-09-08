package intercore.application;

import intercore.domain.Member;
import intercore.domain.Teammate;
import intercore.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableKafka
public class InformationListener {
    private ApplicationUI ui;
    @Autowired
    public InformationListener(ApplicationUI ui) {
        this.ui=ui;
    }

    public void handler(Member information, ConsumerRecord<String, Member> record) {
        log.info("Received from partition {} with timestamp {}", record.partition(), record.timestamp());
        ui.displayInformation(information);
    }


//    public void handler(Member member, ConsumerRecord<String, Member> record) {
//        log.info("Received from partition {} with timestamp {}", record.partition(), record.timestamp());
//        ui.displayInformation(member);
//    }

    public void handler(User user, ConsumerRecord<String, User> record) {
        log.info("Received from partition {} with timestamp {}", record.partition(), record.timestamp());
        ui.displayInformation(user);
    }

    public void handler(Teammate teammate, ConsumerRecord<String, Teammate> record) {
        log.info("Received from partition {} with timestamp {}", record.partition(), record.timestamp());
        ui.displayInformation(teammate);
    }
}
