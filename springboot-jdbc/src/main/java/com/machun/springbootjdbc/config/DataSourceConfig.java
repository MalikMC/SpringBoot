package com.machun.springbootjdbc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/28 20:49
 * @UpdateDate: 2020/3/28 20:49
 * @menu
 */
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean(name = "masterDataSource")
    @Qualifier("masterDataSource")
    @ConfigurationProperties(prefix="spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "salveDataSource")
    @Qualifier("salveDataSource")
    @ConfigurationProperties(prefix="spring.datasource.salve")
    public DataSource salveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="masterJdbcTemplate")
    public JdbcTemplate masterJdbcTemplate (
            @Qualifier("masterDataSource")  DataSource dataSource ) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name="salveJdbcTemplate")
    public JdbcTemplate  salveJdbcTemplate(
            @Qualifier("salveDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
