package br.com.bb.cotacaodolar.config;

import java.util.HashMap;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = {
		"br.com.bb.cotacaodolar.repository" }, entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")
public class CotacaoDataSource {

	@Autowired
	private Environment env;

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManager() throws NamingException {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dbDatasource());
		em.setPackagesToScan(new String[] { "br.com.bb.cotacaodolar.domain" });
		em.setPersistenceUnitName("entityManager");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", env.getProperty("spring.jooq.sql-dialect"));
		properties.put("hibernate.show-sql", env.getProperty("hibernate.show_sql"));
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Primary
	@Bean
	public DataSource dbDatasource() throws NamingException {
		return (DataSource) new JndiTemplate().lookup(env.getProperty("spring.datasource.jndi-name"));
	}

	@Primary
	@Bean
	public PlatformTransactionManager transactionManager() throws NamingException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManager().getObject());
		return transactionManager;
	}
}
