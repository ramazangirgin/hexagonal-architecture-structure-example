package girgin.ramazan.hexagonalarchitecturestructureexample.application.rest.controller.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.shaded.com.google.common.collect.ImmutableList;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {BaseIT.Initializer.class})
public abstract class BaseIT {

    final protected static GenericContainer rabbitMqContainer = new GenericContainer("rabbitmq:3.7.7")
            .withExposedPorts(5672);

    @Autowired
    protected ConfigurableApplicationContext configurableApplicationContext;

    @BeforeClass
    public static void abstractBeforeClass() {
        startRabbitMq();
    }

    @AfterClass
    public static void abstractAfterClass() {
        stopRabbitMq();
    }

    private static void startRabbitMq() {
        try {
            if (!rabbitMqContainer.isRunning()) {
                rabbitMqContainer.start();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private static void stopRabbitMq() {
        try {
            if (!rabbitMqContainer.isRunning()) {
                rabbitMqContainer.stop();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            System.setProperty("es.set.netty.runtime.available.processors", "false");
            TestPropertyValues.of(new ImmutableList.Builder<String>()
                    .add("spring.rabbitmq.host=" + rabbitMqContainer.getContainerIpAddress())
                    .add("spring.rabbitmq.port=" + rabbitMqContainer.getMappedPort(5672).toString())
                    .build())
                    .applyTo(configurableApplicationContext);
            ConfigurationPropertySources.attach(configurableApplicationContext.getEnvironment());
        }
    }
}
