package com.pankaj.springjpa.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableTransactionManagement
@EnableJpaRepositories("com.pankaj.springjpa.data.repository")
public class Config {

    private Environment environment;

    public Config(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl((environment.getProperty("datasource.url")));
        dataSource.setUsername(environment.getProperty("datasource.username"));
        dataSource.setPassword(environment.getProperty("datasource.password"));

        return dataSource;
    }

    /*@Bean
    public DataSource dataSource(){
        HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(10);
        ds.setJdbcUrl(environment.getProperty("datasource.url"));
        ds.setUsername(environment.getProperty("datasource.username"));
        ds.setPassword(environment.getProperty("datasource.password"));

        return ds;

    }*/

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(environment.getRequiredProperty("hibernate.dialect"));

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("com.pankaj.springjpa.data.model");
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setJpaProperties(hibernateProperties());

        return entityManagerFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory entityManagerFactory){

        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

        return jpaTransactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){

        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put("javax.persistence.schema-generation.database.action",
                environment.getProperty("jpa.action"));
        return properties;
    }
}
