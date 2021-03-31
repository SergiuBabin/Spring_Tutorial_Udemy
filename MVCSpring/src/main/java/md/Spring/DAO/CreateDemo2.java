package md.Spring.DAO;

import md.Spring.models.Course;
import md.Spring.models.Instructor;
import md.Spring.models.InstructorDetail;
import md.Spring.models.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author Babin Sergiu
 */

public class CreateDemo2 {

    public static void main(String[] args) {


        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create objects
            session.beginTransaction();

            Course course = new Course("Biologic");

            course.add(new Review("Cool courses"));
            course.add(new Review("Nice course"));
            course.add(new Review("Bat teacher"));

            System.out.println("Saving the course....");
            System.out.println(course);
            System.out.println(course.getReview());
            session.save(course);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }


    }

}