package md.Spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author Babin Sergiu
 */

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("md.Spring")
@PropertySource({"classpath:persistence-postgresSQL.properties"})
public class SpringConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

//    private Logger logger = Logger.getLogger(getClass().getName());
//
//    private final Environment env;

    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }
//
//
//    // define a bean for ViewResolver
//    @Bean
//    public DataSource myDataSource() {
//
//        // create connection pool
//        ComboPooledDataSource myDataSource = new ComboPooledDataSource();
//
//        // set the jdbc driver
//        try {
//            myDataSource.setDriverClass("org.postgresql.Driver");
//        } catch (PropertyVetoException exc) {
//            throw new RuntimeException(exc);
//        }
//
//        // for sanity's sake, let's log url and user ... just to make sure we are reading the data
//        logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
//        logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
//
//        // set database connection props
//        myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
//        myDataSource.setUser(env.getProperty("jdbc.user"));
//        myDataSource.setPassword(env.getProperty("jdbc.password"));
//
//        // set connection pool props
//        myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
//        myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
//        myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
//        myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
//
//        return myDataSource;
//    }
//
//    private Properties getHibernateProperties() {
//
//        // set hibernate properties
//        Properties props = new Properties();
//
//        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//
//        return props;
//    }
//
//
//    // need a helper method
//    // read environment property and convert to int
//
//    private int getIntProperty(String propName) {
//
//        String propVal = env.getProperty(propName);
//
//        // now convert to int
//        int intPropVal = Integer.parseInt(propVal);
//
//        return intPropVal;
//    }
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory(){
//
//        // create session factorys
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//        // set the properties
//        sessionFactory.setDataSource(myDataSource());
//        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
//        sessionFactory.setHibernateProperties(getHibernateProperties());
//
//        return sessionFactory;
//    }
//
//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//
//        // setup transaction manager based on session factory
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory);
//
//        return txManager;
//    }
}
