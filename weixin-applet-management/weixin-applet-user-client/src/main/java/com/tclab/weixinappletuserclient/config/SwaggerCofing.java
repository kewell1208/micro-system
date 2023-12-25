package com.tclab.weixinappletuserclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerCofing {

    @Bean
    public Docket createUserClientModuleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .groupName("客户端")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.tclab.weixinappletuserclient.controller.front.user_client"))
            .paths(PathSelectors.any())
            .build();
    }

    @Bean
    public Docket createDoctorClientModuleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("医生端")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tclab.weixinappletuserclient.controller.front.doctor_client"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createAcquisitionClientModuleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("采集点端")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tclab.weixinappletuserclient.controller.front.acquisition_client"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("同创诊合小程序后台接口文档")//标题
                .description("后台独立接口文档")//描述
//                .termsOfServiceUrl("http://localhost:8999/")//条款地址
                .version("1.0")//版本号
                .build();
    }

}
