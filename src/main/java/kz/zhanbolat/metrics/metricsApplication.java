package kz.zhanbolat.metrics;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class metricsApplication extends Application<metricsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new metricsApplication().run(args);
    }

    @Override
    public String getName() {
        return "metrics";
    }

    @Override
    public void initialize(final Bootstrap<metricsConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final metricsConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
