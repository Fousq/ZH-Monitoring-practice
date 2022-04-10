package kz.zhanbolat.monitoring.health;

import com.codahale.metrics.health.HealthCheck;
import kz.zhanbolat.monitoring.mbean.HealthEntity;

public class EntityHealthCheck extends HealthCheck {
    private HealthEntity healthEntity;

    public EntityHealthCheck(HealthEntity healthEntity) {
        this.healthEntity = healthEntity;
    }

    @Override
    protected Result check() throws Exception {
        return healthEntity.isHealth() ? Result.healthy("The entity is healthy") :
                Result.unhealthy("Some problems with service. The entity is unhealthy");
    }
}
