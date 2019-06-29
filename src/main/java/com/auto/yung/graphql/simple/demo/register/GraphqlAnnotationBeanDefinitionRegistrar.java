package com.auto.yung.graphql.simple.demo.register;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author yung
 * @date 2019-06-20 21:46
 */
public class GraphqlAnnotationBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
                                        BeanDefinitionRegistry beanDefinitionRegistry) {
        if (!beanDefinitionRegistry.containsBeanDefinition(GraphqlServletBeanDefinitionRegister.BEAN_NAME)) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(GraphqlServletBeanDefinitionRegister.class);
            beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
            beanDefinitionRegistry.registerBeanDefinition(GraphqlServletBeanDefinitionRegister.BEAN_NAME, beanDefinition);
        }
    }
}
