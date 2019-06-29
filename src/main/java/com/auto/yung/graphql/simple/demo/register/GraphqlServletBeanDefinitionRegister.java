package com.auto.yung.graphql.simple.demo.register;

import com.auto.yung.graphql.simple.demo.configure.GraphQLSchemaBuilder;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

/**
 * @author yung
 * @date 2019-06-20 21:26
 */
public class GraphqlServletBeanDefinitionRegister implements BeanDefinitionRegistryPostProcessor {

    private final String graphqlUrl = "/api/graphql";
    public static final String BEAN_NAME = "GraphqlServletBeanDefinitionRegister";
    private final String servletName = "graphQLServlet";


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        BeanDefinitionRegistry registry = beanDefinitionRegistry;
        if (registry.containsBeanDefinition(servletName)) {
            return;
        }
        GraphQLSchema schema = GraphQLSchemaBuilder.buildSchema();
        SimpleGraphQLHttpServlet servlet = SimpleGraphQLHttpServlet.newBuilder(schema).build();

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(ServletRegistrationBean.class);
        builder.addConstructorArgValue(servlet);
        builder.addConstructorArgValue(graphqlUrl);
        registry.registerBeanDefinition(servletName, builder.getBeanDefinition());

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
