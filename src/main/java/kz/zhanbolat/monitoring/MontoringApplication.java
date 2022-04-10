package kz.zhanbolat.monitoring;

import io.dropwizard.Application;
import io.dropwizard.health.conf.HealthConfiguration;
import io.dropwizard.health.core.HealthCheckBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import kz.zhanbolat.monitoring.health.EntityHealthCheck;
import kz.zhanbolat.monitoring.mbean.EntityMXBean;
import kz.zhanbolat.monitoring.mbean.HealthEntity;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class MontoringApplication extends Application<MontoringConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MontoringApplication().run(args);
    }

    @Override
    public String getName() {
        return "Montoring";
    }

    @Override
    public void initialize(final Bootstrap<MontoringConfiguration> bootstrap) {
        bootstrap.addBundle(new HealthCheckBundle<MontoringConfiguration>() {
            @Override
            protected HealthConfiguration getHealthConfiguration(MontoringConfiguration montoringConfiguration) {
                return montoringConfiguration.getHealthCheckConfiguration();
            }
        });
    }

    @Override
    public void run(final MontoringConfiguration configuration,
                    final Environment environment) {

        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        HealthEntity healthEntity = new HealthEntity();
        try {
            ObjectName objectName = new ObjectName("kz.zhanbolat.monitoring:type=entity");
            beanServer.registerMBean(healthEntity, objectName);
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException e) {
            throw new RuntimeException(e);
        }

        environment.healthChecks().register("healthEntity", new EntityHealthCheck(healthEntity));
    }

}
