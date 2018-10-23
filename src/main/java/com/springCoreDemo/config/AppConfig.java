package com.springCoreDemo.config;

import java.util.Properties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

@Configuration	
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans (value= {
	@ComponentScan("com.springCoreDemo.service"),
	@ComponentScan("com.springCoreDemo.dao")
} )
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		
		Properties prop = new Properties();
		
		prop.setProperty(DRIVER, env.getProperty("mysql.driver"));
		prop.setProperty(URL, env.getProperty("mysql.url"));
		prop.setProperty(USER, env.getProperty("mysql.user"));
		prop.setProperty(PASS, env.getProperty("mysql.password"));
		
		prop.setProperty(SHOW_SQL, env.getProperty("hibernate.show_sql"));
		prop.setProperty(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
		
		prop.setProperty(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
		prop.setProperty(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
		prop.setProperty(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
		prop.setProperty(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
		prop.setProperty(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
		
		localSessionFactoryBean.setHibernateProperties(prop);
		localSessionFactoryBean.setPackagesToScan("com.springCoreDemo.model");
		
		return localSessionFactoryBean;
		
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		
		HibernateTransactionManager transaction = new HibernateTransactionManager();
		
		transaction.setSessionFactory(getSessionFactory().getObject());
		
		return transaction;
	}

}
