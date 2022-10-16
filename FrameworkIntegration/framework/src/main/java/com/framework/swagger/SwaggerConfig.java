package com.framework.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
@Configuration
@EnableSwagger2//开启swagger2
public class SwaggerConfig {
    /**
     * 设置基础分组 里面包含所有注解标注过的接口
     * @return
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo())
                .select()
                //requestHandlerSelectors 配置要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.framework"))
                .build()
                .groupName("所有路径分组");
    }


    //配置swagger信息 apiInfo
    public ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("血手人屠","","1723246792@qq.com");
        return new ApiInfo("swaggerApi文档",
                "这个作者有点酷",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }
}
