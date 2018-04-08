package com.hainet.graphql.spring.boot.sample.web.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class RaceQuery implements GraphQLQueryResolver {

    public String rabbit() throws InterruptedException {
        return "I'm rabbit. I reached the goal at " + LocalDateTime.now();
    }

    public String turtle() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return "I'm turtle. I reached the goal at " + LocalDateTime.now();
    }
}
