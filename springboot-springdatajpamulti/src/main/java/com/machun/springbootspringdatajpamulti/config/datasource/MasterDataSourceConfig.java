package com.machun.springbootspringdatajpamulti.config.datasource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/4/1 13:47
 * @UpdateDate: 2020/4/1 13:47
 * @menu
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryMaster",
        transactionManagerRef="transactionManagerMaster",
        basePackages= { "com.machun.springbootspringdatajpamulti.repository.master" })
public class MasterDataSourceConfig {

    @Autowired
    @Qualifier("masterDataSource")
    private DataSource masterDataSource;

    @Autowired
    @Qualifier("vendorProperties")
    private Map<String, Object> vendorProperties;

    @Bean(name = "entityManagerFactoryMaster")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMaster (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(masterDataSource)
                .properties(vendorProperties)
                .packages("com.machun.springbootspringdatajpamulti.entity")
                .persistenceUnit("masterPersistenceUnit")
                .build();
    }

    @Bean(name = "entityManagerMaster")
    @Primary
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryMaster(builder).getObject().createEntityManager();
    }

    @Bean(name = "transactionManagerMaster")
    @Primary
    PlatformTransactionManager transactionManagerMaster(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryMaster(builder).getObject());
    }
}
