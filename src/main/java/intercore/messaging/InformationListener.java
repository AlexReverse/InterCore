package intercore.messaging;

import intercore.application.ApplicationUI;
import intercore.domain.MemberInformation;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InformationListener {
    private ApplicationUI ui;

    @Autowired
    public InformationListener(ApplicationUI ui) {
        this.ui=ui;
    }

    @KafkaListener(topics = "intercore.informations.topic")
    public void handler(MemberInformation information, ConsumerRecord<String, MemberInformation> record) {
        log.info("Received from partition {} with timestamp {}", record.partition(), record.timestamp());
        ui.displayInformation(information);
    }
}
