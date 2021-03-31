package md.Sergiu.Spring;

import org.springframework.stereotype.Component;

/**
 * @author Babin Sergiu
 */
@Component
public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Today is your lucky day!!";
    }
}
