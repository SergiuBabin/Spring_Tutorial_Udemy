package md.Sergiu.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Babin Sergiu
 */
@Component
public class CricketCoach implements Coach {
    @Value("${email}")
    private String emailAddress;
    @Value("${team}")
    private String team;


    private FortuneService fortuneService;

    public CricketCoach() {
        System.out.println("CricketCoach: inside no-arg constructor");
    }

    @Autowired
    public void setFortuneService(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes\nEmail = " + emailAddress + "\nTeam name:" + team;
    }

    @Override
    public String getFortuneService() {
        return fortuneService.getFortune();
    }
}
