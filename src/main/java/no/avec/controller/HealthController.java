package no.avec.controller;

import org.springframework.boot.actuate.health.Health;

import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by avec on 25/11/2016.
 */
@RestController
@Path("/health")
public class HealthController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Health health() {
        return Health.up().build();
    }
}
