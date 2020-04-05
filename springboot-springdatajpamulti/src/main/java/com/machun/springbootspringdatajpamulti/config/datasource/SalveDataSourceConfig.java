package com.machun.springbootspringdatajpamulti.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
 * @CreateDate: 2020/4/1 13:48
 * @UpdateDate: 2020/4/1 13:48
 * @menu
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactorySalve",
        transactionManagerRef="transactionManagerSalve",
        basePackages= { "com.machun.springbootspringdatajpamulti.repository.salve" })
public class SalveDataSourceConfig {

    @Autowired
    @Qualifier("salveDataSource")
    private DataSource salveDataSource;

    @Autowired
    @Qualifier("vendorProperties")
    private Map<String, Object> vendorProperties;

    @Bean(name = "entityManagerFactorySalve")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySalve (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(salveDataSource)
                .properties(vendorProperties)
                .packages("com.machun.springbootspringdatajpamulti.entity")
                .persistenceUnit("salvePersistenceUnit")
                .build();
    }

    @Bean(name = "entityManagerSalve")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySalve(builder).getObject().createEntityManager();
    }

    @Bean(name = "transactionManagerSalve")
    PlatformTransactionManager transactionManagerSalve(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySalve(builder).getObject());
    }
}
