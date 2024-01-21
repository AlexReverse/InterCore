package intercore.messaging;

import intercore.domain.MemberInformation;

public interface InformationMessagingService {
    void sendInformation(MemberInformation information);
}
