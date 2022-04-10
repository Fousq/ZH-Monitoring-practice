package kz.zhanbolat.monitoring;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.health.conf.HealthConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class MontoringConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("health")
    private HealthConfiguration healthCheckConfiguration = new HealthConfiguration();

    public HealthConfiguration getHealthCheckConfiguration() {
        return healthCheckConfiguration;
    }

    public void setHealthCheckConfiguration(HealthConfiguration healthCheckConfiguration) {
        this.healthCheckConfiguration = healthCheckConfiguration;
    }
}
