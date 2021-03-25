package md.Sergiu.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Babin Sergiu
 */
@Component
public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach() {}


    @Autowired

    public BaseballCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getFortuneService() {
        return fortuneService.getFortune();
    }

}
