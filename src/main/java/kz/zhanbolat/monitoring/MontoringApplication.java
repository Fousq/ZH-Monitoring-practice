package kz.zhanbolat.monitoring;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
        // TODO: application initialization
    }

    @Override
    public void run(final MontoringConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
