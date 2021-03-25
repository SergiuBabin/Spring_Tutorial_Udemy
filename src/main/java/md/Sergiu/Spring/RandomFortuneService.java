package md.Sergiu.Spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Babin Sergiu
 */
@Component
public class RandomFortuneService implements FortuneService {

    private List<String> fortuneList = new ArrayList<>(Arrays.asList("Happy fortune", "Sad fortune", "Hungry fortune"));


    @Override
    public String getFortune() {
        Random random = new Random();
        return "Today we have " + fortuneList.get(random.nextInt(3));
    }
}
