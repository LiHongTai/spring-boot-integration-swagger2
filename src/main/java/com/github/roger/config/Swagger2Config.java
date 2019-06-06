package com.github.roger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //需要生成api文档的接口所在包
                .apis(RequestHandlerSelectors.basePackage("com.github.roger.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot整合Swagger2构建api文档")//文档标题
                .description("简单优雅的Restful风格,http://blog.csdn.net/saytime")//描述
                .termsOfServiceUrl("http://blog.csdn.net/saytime")
                .version("1.0")//版本
                .build();
    }
}
