package com.github.vaibhavsinha.eighttracks.config;

import com.github.vaibhavsinha.eighttracks.converter.TagsConverter;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * Created by vaibhav on 15/07/17.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapper() {
        DozerBeanMapperFactoryBean factoryBean = new DozerBeanMapperFactoryBean();
        factoryBean.setCustomConverters(Collections.singletonList(new TagsConverter()));
        return factoryBean;
    }
}
