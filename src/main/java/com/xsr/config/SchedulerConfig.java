package com.xsr.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

/**
 * Created by 145811 on 2018/5/2.
 */
@Configuration
public class SchedulerConfig {


    @Autowired
    DataSource dataSource;


    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException, PropertyVetoException {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();

        schedulerFactoryBean.setOverwriteExistingJobs(true);

        schedulerFactoryBean.setQuartzProperties(properties());
        schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(true);


        schedulerFactoryBean.setDataSource(dataSource);
        return schedulerFactoryBean;

    }

    @Bean
    public Properties properties() throws IOException {
        Properties prop = new Properties();
        prop.load(new ClassPathResource("/quartz.properties").getInputStream());
        return prop;
    }

}
