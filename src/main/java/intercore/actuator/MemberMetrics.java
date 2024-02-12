package intercore.actuator;

import intercore.domain.Discipline;
import intercore.domain.Member;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberMetrics extends AbstractRepositoryEventListener<Member> {
    private MeterRegistry meterRegistry;

    public MemberMetrics(MeterRegistry meterRegistry){
        this.meterRegistry=meterRegistry;
    }

    @Override
    protected void onAfterCreate(Member member) {
        List<Discipline> disciplines = member.getDisciplines();
        for (Discipline discipline : disciplines) {
            meterRegistry.counter("intercore", "discipline", discipline.getId()).increment();
        }
    }
}
