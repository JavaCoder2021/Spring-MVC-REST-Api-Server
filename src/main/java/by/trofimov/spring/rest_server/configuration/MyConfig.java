package by.trofimov.spring.rest_server.configuration;

import javax.sql.DataSource;
import java.util.Properties;
import java.beans.PropertyVetoException;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import static by.trofimov.spring.rest_server.util.Constant.*;

@Configuration
@ComponentScan(MY_CONFIG_PACKAGES_TO_SCAN)
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(DB_DRIVER_CLASS);
            dataSource.setJdbcUrl(DB_JDBC_URL);
            dataSource.setUser(DB_USER);
            dataSource.setPassword(DB_PASSWORD);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(SESSION_FACTORY_PACKAGES_TO_SCAN);
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(SESSION_FACTORY_HIBERNATE_DIALECT, SESSION_FACTORY_MYSQL_DIALECT);
        hibernateProperties.setProperty(SESSION_FACTORY_SHOW_SQL, SESSION_FACTORY_TRUE);
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
