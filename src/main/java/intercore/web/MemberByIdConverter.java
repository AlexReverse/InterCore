package intercore.web;

import intercore.data.DisciplineRepository;
//import intercore.data.TeammateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import intercore.domain.Discipline;

@Component
public class MemberByIdConverter implements Converter<String, Discipline> {
    private DisciplineRepository disciplineRepository;
    //private TeammateRepository teammateRepository;

    @Autowired
    public MemberByIdConverter(DisciplineRepository disciplineRepository) {
        this.disciplineRepository=disciplineRepository;
        //this.teammateRepository=teammateRepository;
    }

    @Override
    public Discipline convert(String id){
        return disciplineRepository.findById(id).orElse(null);
    }

}

