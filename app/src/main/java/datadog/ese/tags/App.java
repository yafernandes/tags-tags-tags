package datadog.ese.tags;

import java.io.File;

import com.timgroup.statsd.NonBlockingStatsDClientBuilder;
import com.timgroup.statsd.StatsDClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import datadog.trace.api.Trace;

public class App {

    private static final Logger logger = LoggerFactory.getLogger("SandBox");
    private static final StatsDClient statsd = new NonBlockingStatsDClientBuilder().prefix("statsd")
            .hostname(System.getenv().getOrDefault("DD_AGENT_HOST", "localhost")).port(8125).build();

    public static void main(String[] args) throws Exception {
        System.out.println(new File(".").getAbsolutePath());
        System.out.println("Listening on " + System.getenv().getOrDefault("DD_AGENT_HOST", "localhost"));
        while (true) {
            myMethod();
            Thread.sleep(1000);
        }
    }

    @Trace(operationName = "myOperation", resourceName = "myResource")
    private static void myMethod() {
        logger.info(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse vehicula odio eget sapien convallis dignissim. Mauris tincidunt tortor odio, vitae euismod libero mollis pulvinar.");
        statsd.recordGaugeValue("sandbox.heartbeat", 1, new String[] { "tag-source:code" });
    }
}
