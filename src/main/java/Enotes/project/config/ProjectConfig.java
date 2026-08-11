package Enotes.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ProjectConfig {

    @Bean
public AuditorAware<Long> auditorAware(){
    return new AuditAwareConfig();
}
}
