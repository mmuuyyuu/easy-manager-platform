package com.easy.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.easy.config.datasource.druid.DruidDataSourceDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Packge com.easy.config.datasource
 * @Autor linNaibin
 * @Description 数据库配置
 * @Version 1.0
 * @Date 2020/11/24 17:17
 */
@Configuration
public class DataSourceConfig {

    // 修饰一下 DataSource
    private DruidDataSourceDecorator decorator;

    @Autowired
    public void setDecorator(DruidDataSourceDecorator decorator) {
        this.decorator = decorator;
    }

    // 模型
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.emp")
    DataSource easyDataSource() {
         DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return decorator.decorat(dataSource);
    }


}
