package com.machun.springbootmybatisxml.config.DataSourceConfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/29 13:57
 * @UpdateDate: 2020/3/29 13:57
 * @menu
 */

@Configuration
@MapperScan(basePackages = "com.machun.springbootmybatisxml.mapper.salve", sqlSessionTemplateRef  = "salveSqlSessionTemplate")
public class SalveDataSourceConfig {

    @Bean(name = "salveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.salve")
    public DataSource materDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "salveSqlSessionFactory")
    public SqlSessionFactory salveSqlSessionFactory(@Qualifier("salveDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/salve/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "salveTransactionManager")
    public DataSourceTransactionManager salveTransactionManager(@Qualifier("salveDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "salveSqlSessionTemplate")
    public SqlSessionTemplate salveSqlSessionTemplate(@Qualifier("salveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
