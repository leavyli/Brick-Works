package com.example.jdkproxydemo.utilities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: saino
 * @Description:
 * @date: 2022/5/6 1:30
 * @link: https://gist.github.com/jrichardsz/a34480c1bcc31c45da730c48c4f41331
 */
@Slf4j
public class ClassScanner {

    public static Set<Class<?>> findAllAnnotatedClassesInPackage(String packageName,
                                                              Class<? extends Annotation> clazz) {
        final Set<Class<?>> result = new HashSet<>();
        final ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
//                new ClassPathScanningCandidateComponentProvider(true, new StandardServletEnvironment());
        provider.addIncludeFilter(new AnnotationTypeFilter(clazz));
        for (BeanDefinition beanDefinition : provider.findCandidateComponents(packageName)) {
            try {
                result.add(Class.forName(beanDefinition.getBeanClassName()));
            } catch (ClassNotFoundException e) {
                log.warn("Could not resolve class object for bean definition", e);
            }
        }
        return result;
    }
}
