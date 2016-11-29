package no.avec.config;

import no.avec.controller.HealthController;
import no.avec.controller.PersonController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Created by avec on 25/11/2016.
 */
@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(PersonController.class);
        register(HealthController.class);

    }
}
