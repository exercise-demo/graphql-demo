package com.auto.yung.graphql.simple.demo;

import com.auto.yung.graphql.simple.demo.register.GraphqlAnnotationBeanDefinitionRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author yung
 * @date 2019-06-12 20:55
 */
@SpringBootApplication
@Import(GraphqlAnnotationBeanDefinitionRegistrar.class)
public class GraphQLApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLApplication.class, args);
    }

}
