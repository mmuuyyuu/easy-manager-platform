package com.easy.config.datasource.sessionfactory;

import com.easy.config.datasource.pagehelper.PageHelperConfig;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Packge com.easy.config.datasource.sessionfactory
 * @Autor linNaibin
 * @Description 管理平台session factory
 * @Version 1.0
 * @Date 2021/1/24 17:15
 */
@Configuration
@MapperScan(basePackages = "com.easy.mapper.*", sqlSessionTemplateRef = "modelSqlSessionTemplate")
public class EasySessionFactory {


    private DataSource easyDatasource;

    @Autowired
    public void setModelDatasource(DataSource easyDatasource) {
        this.easyDatasource = easyDatasource;
    }

    private PageHelperConfig pageHelperConfig;

    @Autowired
    public void setPageHelperConfig(PageHelperConfig pageHelperConfig) {
        this.pageHelperConfig = pageHelperConfig;
    }

    SqlSessionFactory modelSqlSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        try {
            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
            bean.setDataSource(easyDatasource);
            // 扫描的XML
            bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*/*.xml"));

            // 设置分页插件
            Interceptor[] plugins = new Interceptor[]{pageHelperConfig.pageInterceptor()};

            bean.setPlugins(plugins);

            // 配置驼峰命名
            bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
            // 开启二级缓存
            bean.getObject().getConfiguration().setCacheEnabled(true);
            sessionFactory = bean.getObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    @Bean
    @Qualifier("modelSqlSessionTemplate")
    SqlSessionTemplate modelSqlSessionTemplate() {
        return new SqlSessionTemplate(modelSqlSessionFactory());
    }


    /**
     * 返回模型数据库的事务
     *
     * @return
     */
    @Bean
    @Qualifier("modelTransactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(easyDatasource);
    }
}
