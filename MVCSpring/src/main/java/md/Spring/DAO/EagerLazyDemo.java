package md.Spring.DAO;

import md.Spring.models.Course;
import md.Spring.models.Instructor;
import md.Spring.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author Babin Sergiu
 */

public class EagerLazyDemo {

    public static void main(String[] args) {


        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create objects
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 4);

            System.out.println("Lazy_Eager " + instructor);

            session.getTransaction().commit();

            session.close();

            System.out.println("Lazy_Eager " + instructor.getCourses());

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }


    }

}