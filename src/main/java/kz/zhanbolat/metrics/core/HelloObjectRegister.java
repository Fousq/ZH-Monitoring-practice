package kz.zhanbolat.metrics.core;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;
import kz.zhanbolat.metrics.api.HelloObject;

import java.util.ArrayList;
import java.util.List;

public class HelloObjectRegister {
    private List<HelloObject> helloObjects;

    public HelloObjectRegister(MetricRegistry metricRegistry) {
        helloObjects = new ArrayList<>();
        metricRegistry.register(MetricRegistry.name(HelloObjectRegister.class, "size"), (Gauge<Integer>) helloObjects::size);
    }

    public void add(HelloObject helloObject) {
        helloObjects.add(helloObject);
    }
}
