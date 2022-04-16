package kz.zhanbolat.metrics;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import kz.zhanbolat.metrics.core.HelloObjectRegister;
import kz.zhanbolat.metrics.resources.AppResource;

import java.util.ArrayList;
import java.util.List;

public class MetricsApplication extends Application<MetricsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MetricsApplication().run(args);
    }

    @Override
    public String getName() {
        return "metrics";
    }

    @Override
    public void initialize(final Bootstrap<MetricsConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final MetricsConfiguration configuration,
                    final Environment environment) {
        MetricRegistry metrics = environment.metrics();
        HelloObjectRegister helloObjectRegister = new HelloObjectRegister(metrics);
        AppResource appResource = new AppResource(helloObjectRegister);
        environment.jersey().register(appResource);
    }

}
