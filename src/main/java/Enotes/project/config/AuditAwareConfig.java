package Enotes.project.config;

import org.springframework.data.domain.AuditorAware;

import java.time.Instant;
import java.util.Optional;

public class AuditAwareConfig implements AuditorAware<Long>{
    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.of(1l);
    }
}
