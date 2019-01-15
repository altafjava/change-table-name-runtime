package com.javaaltaf.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

	@Value("${db.driver}")
	private String driver;
	@Value("${db.password}")
	private String password;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${hibernate.show_sql}")
	private String showSQL;
	@Value("${hibernate.format_sql}")
	private String formatSQL;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddlAuto;
	@Value("${entitymanager.packagesToScan}")
	private String[] packagesToScan;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(packagesToScan);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", dialect);
		hibernateProperties.put("hibernate.show_sql", showSQL);
		hibernateProperties.put("hibernate.format_sql", formatSQL);
		hibernateProperties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
}
