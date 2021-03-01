package com.easy.config.datasource.pagehelper;

import com.github.pagehelper.PageInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Packge com.easy.config.datasource.pagehelper
 * @Autor linNaibin
 * @Description 分页插件
 * @Version 1.0
 * @Date 2020/11/25 16:59
 */
@Configuration
@ConfigurationProperties(prefix = "pagehelper")
public class PageHelperConfig {

    private String helperDialect;

    private String supportMethodsArguments;

    private String reasonable;

    private String params;

    public String getHelperDialect() {
        return helperDialect;
    }

    public void setHelperDialect(String helperDialect) {
        this.helperDialect = helperDialect;
    }

    public String isSupportMethodsArguments() {
        return supportMethodsArguments;
    }

    public void setSupportMethodsArguments(String supportMethodsArguments) {
        this.supportMethodsArguments = supportMethodsArguments;
    }

    public String isReasonable() {
        return reasonable;
    }

    public void setReasonable(String reasonable) {
        this.reasonable = reasonable;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }


    public PageInterceptor pageInterceptor() {
        PageInterceptor interceptor = new PageInterceptor();
        Properties p = new Properties();
        p.setProperty("helperDialect", getHelperDialect());
        p.setProperty("supportMethodsArguments", isSupportMethodsArguments());
        p.setProperty("reasonable", isReasonable());
        interceptor.setProperties(p);
        return interceptor;
    }


}
