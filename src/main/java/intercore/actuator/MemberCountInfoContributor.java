package intercore.actuator;

import intercore.data.MemberRepository;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemberCountInfoContributor implements InfoContributor {
    private MemberRepository memberRepository;

    public MemberCountInfoContributor(MemberRepository memberRepository) {
        this.memberRepository=memberRepository;
    }

    @Override
    public void contribute(Info.Builder builder) {
        long memberCount = memberRepository.count();
        Map<String, Object> memberMap = new HashMap<>();
        memberMap.put("count", memberCount);
        builder.withDetail("member-stats", memberMap);
    }
}
