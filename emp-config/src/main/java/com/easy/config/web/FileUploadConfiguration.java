package com.easy.config.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;
import java.util.Map;

/**
 * @Packge com.easy.config.web
 * @Autor linNaibin
 * @Description 上传文件配置
 * @Version 1.0
 * @Date 2021/2/4 10:31
 */
@Configuration
@ConfigurationProperties(prefix = "files")
public class FileUploadConfiguration {

    private Map<String, Object> params;


    public Object get(String key) {
        return this.params.get(key);
    }

    public long getAsLong(String key) {
        Object r = this.get(key);
        if (r == null) {
            return 0l;
        }
        return Long.valueOf(String.valueOf(r));
    }

    public String getAsString(String key) {
        return String.valueOf(this.get(key));
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件大小mb
        factory.setMaxFileSize(DataSize.ofMegabytes(getAsLong("maxFileSize")));
        //设置总上传数据大小10MB
        factory.setMaxRequestSize(DataSize.ofMegabytes(getAsLong("maxRequestSize")));
        // 文件临时存放地址
        factory.setLocation(getAsString("location"));

        return factory.createMultipartConfig();
    }

}
