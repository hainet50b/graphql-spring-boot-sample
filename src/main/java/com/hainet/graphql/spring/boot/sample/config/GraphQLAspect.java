package com.hainet.graphql.spring.boot.sample.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class GraphQLAspect {

    @Pointcut("within(com.hainet.graphql.spring.boot.sample.web.query.*)")
    public void query() {
    }

    @Pointcut("within(com.hainet.graphql.spring.boot.sample.web.mutation.*)")
    public void mutation() {
    }

    @Before("query() || mutation()")
    public void logGraphQLExecution(final JoinPoint jp) {
        log.info("[ SQL Queries executed in '" + jp.getSignature().toShortString() + "' ]");
    }
}
