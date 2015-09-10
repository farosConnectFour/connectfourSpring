package be.faros.connectfour.config;

import be.faros.connectfour.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = UserRepository.class)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class CreateDAOBeans {

    @Autowired
    private DataSource dataSource;

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("be.faros.connectfour.domain");
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        factory.setJpaVendorAdapter(adapter);
        factory.getJpaPropertyMap().put("hibernate.format_sql", true);
        factory.getJpaPropertyMap().put("hibernate.use_sql_comments", true);
        return factory;
    }

    @Bean
    JpaTransactionManager transactionManager(){
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }
}
