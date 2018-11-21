package com.config;

import com.lesson2.OrderDAO;
import com.lesson2.OrderService;
import com.lesson2.homework2_1.model.Route;
import com.lesson2.homework2_1.model.Service;
import com.lesson2.homework2_1.model.Step;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManagerFactory;
import java.util.*;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

    //lesson2
    @Bean
    public OrderService orderService(){
        return new OrderService();
    }

    @Bean
    public OrderDAO orderDAO(){
        return new OrderDAO();
    }

    //lesson 2 hw 2_1
    @Bean
    public Service serviceFrom(){
        return new Service(1L, "A", new ArrayList<>(Arrays.asList("param1", "param2")));
    }

    @Bean
    public Service serviceTo(){
        return new Service(2L, "B", new ArrayList<>(Arrays.asList("param3", "param4")));
    }

    @Bean
    public Step step1(){
        Map<String, List> mapParamsFrom = new HashMap<>();
            mapParamsFrom.put("serviceFrom",serviceFrom().getParamsToCall());
        Map<String, List> mapParamsTo = new HashMap<>();
            mapParamsTo.put("serviceTo",serviceTo().getParamsToCall());
        return new Step(12L, serviceFrom(), serviceTo(), mapParamsFrom, mapParamsTo);
    }

    @Bean
    public Step step2(){
        Map<String, List> mapParamsFrom = new HashMap<>();
            mapParamsFrom.put("serviceFrom",serviceFrom().getParamsToCall());
        Map<String, List> mapParamsTo = new HashMap<>();
            mapParamsTo.put("serviceTo",serviceTo().getParamsToCall());
        return new Step(13L, serviceFrom(), serviceTo(), mapParamsFrom, mapParamsTo);
    }

    @Bean
    public Step step3(){
        Map<String, List> mapParamsFrom = new HashMap<>();
            mapParamsFrom.put("serviceFrom",serviceFrom().getParamsToCall());
        Map<String, List> mapParamsTo = new HashMap<>();
            mapParamsTo.put("serviceTo",serviceTo().getParamsToCall());
        return new Step(14L, serviceFrom(), serviceTo(), mapParamsFrom, mapParamsTo);
    }

    @Bean
    public Route route(){
        return new Route("78", new ArrayList<>(Arrays.asList(step1(), step2(), step3())));
    }

    //lesson5
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"com"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@gromcode-lessons.ce5xbsungqgk.us-east-2.rds.amazonaws.com:1521:ORCL");
        dataSource.setUsername("main");
        dataSource.setPassword("11111111");

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

}
