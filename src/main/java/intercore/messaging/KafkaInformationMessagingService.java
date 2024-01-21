package intercore.messaging;

import intercore.domain.MemberInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaInformationMessagingService implements InformationMessagingService {
    private KafkaTemplate<String, MemberInformation> kafkaTemplate;

    @Autowired
    public KafkaInformationMessagingService(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }
    @Override
    public void sendInformation(MemberInformation information) {
        kafkaTemplate.send("intercore.informations.topic", information);
    }
}
