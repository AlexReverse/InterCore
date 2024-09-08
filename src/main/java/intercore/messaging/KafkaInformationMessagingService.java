package intercore.messaging;

import intercore.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaInformationMessagingService implements InformationMessagingService {
    private KafkaTemplate<String, Member> kafkaTemplate;

    @Autowired
    public KafkaInformationMessagingService(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }
    @Override
    public void sendInformation(Member information) {
        kafkaTemplate.send("intercore.informations.topic", information);
    }
}
