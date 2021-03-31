package md.Sergiu.Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Babin Sergiu
 */
@Configuration
@ComponentScan("md.Sergiu.Spring")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public FortuneService randomFortuneService() {
        return new RandomFortuneService();
    }

    @Bean
    public Coach cricketCoach() {
        return new CricketCoach(randomFortuneService());
    }
}
