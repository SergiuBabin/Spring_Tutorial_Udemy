package md.Sergiu.Spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Babin Sergiu
 */

public class SpringHelloApp {
    public static void main(String[] args) {
        // Load the spring configuration file
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // retrieve bean from spring container
        Coach coach = applicationContext.getBean("myTrackCoach", Coach.class);
        Coach coach1 = applicationContext.getBean("baseballCoach", Coach.class);
        CricketCoach coach2 = applicationContext.getBean("cricketCoach", CricketCoach.class);
        // call methods on the bean

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getFortuneService());
        System.out.println("---------------------");
        System.out.println(coach1.getDailyWorkout());
        System.out.println(coach1.getFortuneService());
        System.out.println("---------------------");
        System.out.println(coach2.getDailyWorkout());
        System.out.println(coach2.getFortuneService());
        // close the context
        applicationContext.close();
    }
}
