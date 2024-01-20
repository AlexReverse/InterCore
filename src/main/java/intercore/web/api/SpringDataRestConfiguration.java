package intercore.web.api;

import intercore.domain.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;

@Configuration
public class SpringDataRestConfiguration {

    @Bean
    public RepresentationModelProcessor<PagedModel<EntityModel<Member>>> memberProcessor(EntityLinks links) {
        return new RepresentationModelProcessor<PagedModel<EntityModel<Member>>>() {

            @Override
            public PagedModel<EntityModel<Member>> process(PagedModel<EntityModel<Member>> resource) {
                resource.add(
                        links.linkFor(Member.class)
                                .slash("recent")
                                .withRel("recent"));
                return resource;
            }
        };
    }
}

