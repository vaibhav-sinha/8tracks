package com.github.vaibhavsinha.eighttracks.config;

import com.github.vaibhavsinha.eighttracks.converter.TagsConverter;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Created by vaibhav on 15/07/17.
 */
@Configuration
@EnableSwagger2
public class ApplicationConfig {

    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapper() {
        DozerBeanMapperFactoryBean factoryBean = new DozerBeanMapperFactoryBean();
        factoryBean.setCustomConverters(Collections.singletonList(new TagsConverter()));
        return factoryBean;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.vaibhavsinha.eighttracks.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
