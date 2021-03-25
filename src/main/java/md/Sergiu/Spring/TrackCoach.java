package md.Sergiu.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Babin Sergiu
 */
@Component("myTrackCoach")
public class TrackCoach implements Coach{


    FortuneService fortuneService;

    public TrackCoach() {}


    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    @Autowired
    public void setFortuneService(@Qualifier("randomFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getFortuneService() {
        return fortuneService.getFortune();
    }

    public void doMyStartupStuff() {
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    public void doMyCleanupStuff() {
        System.out.println("TrackCoach: inside method doMyCleanupStuff");
    }
}
