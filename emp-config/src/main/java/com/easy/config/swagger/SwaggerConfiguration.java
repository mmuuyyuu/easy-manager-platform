package com.easy.config.swagger;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @Packge com.easy.gis.config.swagger
 * @Autor linNaibin
 * @Description
 * @Version 1.0
 * @Date 2020/12/10 11:00
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

	/** 是否开启swagger */
	@Value("${swagger.enabled}")
	private boolean enabled;

	/** 标题 */
	@Value("${swagger.title}")
	private String swaggerTitle;

	/** 联系人名称 */
	@Value("${swagger.concat.name}")
	private String swaggerConcatName;

	/** 联系人邮箱 */
	@Value("${swagger.concat.email}")
	private String swaggerConcatEmail;

	/** 描述 */
	@Value("${swagger.description}")
	private String swaggerDescription;

	/** 版本号 */
	@Value("${swagger.version}")
	private String swaggerVersion;

	//index -->>> doc.html 
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				// 是否启用Swagger
				.enable(enabled)
				// 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
				.apiInfo(apiInfo())
				// 设置哪些接口暴露给Swagger展示
				.select()
				// 扫描所有有注解的api，用这种方式更灵活
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				// 扫描所有 .apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	/**
	 * 添加摘要信息
	 */
	private ApiInfo apiInfo() {
		// 用ApiInfoBuilder进行定制
		return new ApiInfoBuilder()
				// 文档页标题
				.title(swaggerTitle)
				// 联系人信息
				.contact(new Contact(swaggerConcatName, null, swaggerConcatEmail))
				// 文档详细信息
				.description(swaggerDescription)
				// 文档版本
				.version(swaggerVersion).build();
	}

}
