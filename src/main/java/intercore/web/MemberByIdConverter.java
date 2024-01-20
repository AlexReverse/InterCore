package intercore.web;

import intercore.data.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import intercore.domain.Discipline;

@Component
public class MemberByIdConverter implements Converter<String, Discipline> {
    private DisciplineRepository disciplineRepository;

    @Autowired
    public MemberByIdConverter(DisciplineRepository disciplineRepository) {
        this.disciplineRepository=disciplineRepository;
    }

    @Override
    public Discipline convert(String id){
        return disciplineRepository.findById(id).orElse(null);
    }

}

