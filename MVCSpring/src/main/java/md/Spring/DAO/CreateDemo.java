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

public class CreateDemo {

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

            Course course1 = new Course("Architect");
            Course course2 = new Course("Informatic");
            Course course3 = new Course("Programming");

            instructor.add(course1);
            instructor.add(course2);
            instructor.add(course3);

            session.save(course1);
            session.save(course2);
            session.save(course3);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }


    }

}