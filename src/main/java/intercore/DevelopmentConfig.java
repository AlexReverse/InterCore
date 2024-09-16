package intercore;

import intercore.data.DisciplineRepository;
import intercore.domain.Discipline;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!default") //Загружает данные, только если это не дефолтная загрузка.
@Configuration
public class DevelopmentConfig {
    @Bean
    public CommandLineRunner dataLoader(DisciplineRepository repo) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                repo.save(new Discipline("DOTA2-CARRY", "CARRY", Discipline.Type.DOTA2));
                repo.save(new Discipline("DOTA2-MIDLANER", "MIDLANER", Discipline.Type.DOTA2));
                repo.save(new Discipline("DOTA2-OFFLANER", "OFFLANER", Discipline.Type.DOTA2));
                repo.save(new Discipline("DOTA2-ROAMER", "ROAMER", Discipline.Type.DOTA2));
                repo.save(new Discipline("DOTA2-HARDSUPPORT", "HARD SUPPORT", Discipline.Type.DOTA2));
                repo.save(new Discipline("DOTA2-FLEX", "FLEX", Discipline.Type.DOTA2));

                repo.save(new Discipline("CS2-ENTRYFRAGGER", "ENTRY FRAGGER", Discipline.Type.CS2));
                repo.save(new Discipline("CS2-REFRAGGER", "REFRAGGER", Discipline.Type.CS2));
                repo.save(new Discipline("CS2-AWPER", "AWP'ER", Discipline.Type.CS2));
                repo.save(new Discipline("CS2-LURKER", "LURKER", Discipline.Type.CS2));
                repo.save(new Discipline("CS2-IGL", "IGL", Discipline.Type.CS2));
                repo.save(new Discipline("CS2-FLEX", "FLEX", Discipline.Type.CS2));

                repo.save(new Discipline("VALORANT-CONTROLLER", "CONTROLLER", Discipline.Type.VALORANT));
                repo.save(new Discipline("VALORANT-SENTINEL", "SENTINEL", Discipline.Type.VALORANT));
                repo.save(new Discipline("VALORANT-INITIATOR", "INITIATOR", Discipline.Type.VALORANT));
                repo.save(new Discipline("VALORANT-DUELIST", "DUELIST", Discipline.Type.VALORANT));
                repo.save(new Discipline("VALORANT-FLEX", "FLEX", Discipline.Type.VALORANT));

                repo.save(new Discipline("OVERWATCH-TANK", "TANK", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("OVERWATCH-DPSFLEX", "DPS FLEX", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("OVERWATCH-DPSHS", "DPS HS", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("OVERWATCH-DPSPROJECTILE", "DPS PROJECTILE", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("OVERWATCH-HEALERFLEX", "HEALER FLEX", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("OVERWATCH-HEALERMAIN", "HEALER MAIN", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("OVERWATCH-HEALEROFF", "HEALER OFF", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("OVERWATCH-FLEX", "FLEX", Discipline.Type.OVERWATCH));

                repo.save(new Discipline("RAINBOW6-HARDBREACH", "HARD BREACH", Discipline.Type.RAINBOW6));
                repo.save(new Discipline("RAINBOW6-HARDBREACHSUPPORT", "HARD BREACH SUPPORT", Discipline.Type.RAINBOW6));
                repo.save(new Discipline("RAINBOW6-SOFTBREACH", "SOFT BREACH", Discipline.Type.RAINBOW6));
                repo.save(new Discipline("RAINBOW6-ENTRYFRAGGERS", "ENTRY FRAGGERS", Discipline.Type.RAINBOW6));
                repo.save(new Discipline("RAINBOW6-DISRUPTORS", "DISRUPTORS", Discipline.Type.RAINBOW6));
                repo.save(new Discipline("RAINBOW6-ANGLEWATCHERS", "ANGLE WATCHERS", Discipline.Type.RAINBOW6));
                repo.save(new Discipline("RAINBOW6-AREADENIAL", "AREA DENIAL", Discipline.Type.RAINBOW6));
                repo.save(new Discipline("RAINBOW6-INTELGATHERERS", "INTEL GATHERERS", Discipline.Type.RAINBOW6));
                repo.save(new Discipline("RAINBOW6-FLEX", "FLEX", Discipline.Type.RAINBOW6));

                repo.save(new Discipline("LOL-TOPLANE", "TOP LANE", Discipline.Type.LOL));
                repo.save(new Discipline("LOL-JUNGLE", "JUNGLE", Discipline.Type.LOL));
                repo.save(new Discipline("LOL-MIDLANE", "MID LANE", Discipline.Type.LOL));
                repo.save(new Discipline("LOL-BOTLANE", "BOT LANE", Discipline.Type.LOL));
                repo.save(new Discipline("LOL-SUPPORT", "SUPPORT", Discipline.Type.LOL));
                repo.save(new Discipline("LOL-FLEX", "FLEX", Discipline.Type.LOL));

                repo.save(new Discipline("FIFA", "FIFA", Discipline.Type.SOLOGAMES));
                repo.save(new Discipline("Hearthstone", "Hearthstone", Discipline.Type.SOLOGAMES));
                repo.save(new Discipline("Mortal Kombat", "Mortal Kombat", Discipline.Type.SOLOGAMES));
            }
        };
    }
}
