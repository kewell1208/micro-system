package com.tclab.weixinappletadminclient.config;

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
    public Docket createStaffModuleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("后台-员工管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tclab.wxmabackapi"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createPackageModuleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("后台-套餐管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tclab.wxmabackapi"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createUserModuleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("后台-用户管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tclab.wxmabackapi"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createAcquisitionModuleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("后台-机构管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tclab.wxmabackapi"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createAccountModuleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("后台-账户管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tclab.wxmabackapi"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createOrderModuleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("后台-订单管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tclab.wxmabackapi"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createLogisticsModuleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("后台-物流管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tclab.wxmabackapi"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createCommissionModuleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("后台-提成管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tclab.wxmabackapi"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createFinancialModuleRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("后台-财务管理")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tclab.wxmabackapi"))
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
