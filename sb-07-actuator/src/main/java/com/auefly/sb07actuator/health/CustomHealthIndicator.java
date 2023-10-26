package com.auefly.sb07actuator.health;

import com.auefly.sb07actuator.bean.CustomHealthBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {
    @Autowired
    private CustomHealthBean customHealthBean;

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        if (customHealthBean.isEven(new Random().nextInt())) {
            builder.up()
                    .withDetail("message", "is even")
                    .withDetail("anotherMessage", "it's random").build();
        } else {
            builder.down().withDetail("message", "is odd")
                    .withDetail("anotherMessage", "it's random").build();
        }
    }
}
