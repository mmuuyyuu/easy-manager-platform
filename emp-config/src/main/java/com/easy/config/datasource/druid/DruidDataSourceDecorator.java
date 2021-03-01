package com.easy.config.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Packge com.easy.config.datasource.druid
 * @Autor linNaibin
 * @Description 数据库连接池配置
 * @Version 1.0
 * @Date 2020/11/24 17:11
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDataSourceDecorator {
    public DruidDataSourceDecorator() {
    }
    // 读取 Druid 配置

    // 初始连接数
    private int initialSize;
    // 最小连接池数量
    private int minIdle;

    // 最大连接池数量
    private int maxActive;
    // 配置获取连接等待超时的时间
    private int maxWait;
    // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    private int timeBetweenEvictionRunsMillis;
    // 配置一个连接在池中最小生存的时间，单位是毫秒
    private int minEvictableIdleTimeMillis;
    // 配置一个连接在池中最大生存的时间，单位是毫秒
    private int maxEvictableIdleTimeMillis;
    // 配置检测连接是否有效
    private String validationQuery;
    //
    private boolean testWhileIdle;
    //
    private boolean testOnBorrow;
    //
    private boolean testOnReturn;

    public int getInitialSize() {
        return initialSize;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public int getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public int getMaxEvictableIdleTimeMillis() {
        return maxEvictableIdleTimeMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public void setMaxEvictableIdleTimeMillis(int maxEvictableIdleTimeMillis) {
        this.maxEvictableIdleTimeMillis = maxEvictableIdleTimeMillis;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public DruidDataSource decorat(DruidDataSource source) {

        /** 配置初始化大小、最小、最大 */
        source.setInitialSize(initialSize);
        source.setMaxActive(maxActive);
        source.setMinIdle(minIdle);

        /** 配置获取连接等待超时的时间 */
        source.setMaxWait(maxWait);

        /** 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 */
        source.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);

        /** 配置一个连接在池中最小、最大生存的时间，单位是毫秒 */
        source.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        source.setMaxEvictableIdleTimeMillis(maxEvictableIdleTimeMillis);

        /**
         * 用来检测连接是否有效的sql，要求是一个查询语句，常用select
         * 'x'。如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会起作用。
         */
        source.setValidationQuery(validationQuery);
        /**
         * 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
         */
        source.setTestWhileIdle(testWhileIdle);
        /** 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。 */
        source.setTestOnBorrow(testOnBorrow);
        /** 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。 */
        source.setTestOnReturn(testOnReturn);

        return source;
    }

}
