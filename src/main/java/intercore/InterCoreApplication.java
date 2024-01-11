package intercore;

import intercore.data.DisciplineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class InterCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(InterCoreApplication.class, args);
    }

    @Bean
    @Profile("prod")
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

                repo.save(new Discipline("Valorant-CONTROLLER", "CONTROLLER", Discipline.Type.VALORANT));
                repo.save(new Discipline("Valorant-SENTINEL", "SENTINEL", Discipline.Type.VALORANT));
                repo.save(new Discipline("Valorant-INITIATOR", "INITIATOR", Discipline.Type.VALORANT));
                repo.save(new Discipline("Valorant-DUELIST", "DUELIST", Discipline.Type.VALORANT));
                repo.save(new Discipline("Valorant-FLEX", "FLEX", Discipline.Type.VALORANT));

                repo.save(new Discipline("Overwatch2-TANK", "TANK", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("Overwatch2-DPSFLEX", "DPS FLEX", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("Overwatch2-DPSHS", "DPS HS", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("Overwatch2-DPSPROJECTILE", "DPS PROJECTILE", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("Overwatch2-HEALERFLEX", "HEALER FLEX", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("Overwatch2-HEALERMAIN", "HEALER MAIN", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("Overwatch2-HEALEROFF", "HEALER OFF", Discipline.Type.OVERWATCH));
                repo.save(new Discipline("Overwatch2-FLEX", "FLEX", Discipline.Type.OVERWATCH));

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
