package vtb.itd.cba.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        String userName = "system";
        if(SecurityContextHolder.getContext().getAuthentication() != null){
            userName = SecurityContextHolder.getContext().getAuthentication().getName();
        }
        return Optional.of(userName);
    }
}
