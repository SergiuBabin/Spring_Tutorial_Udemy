package md.Spring.DAO;

import md.Spring.models.Instructor;
import md.Spring.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author Babin Sergiu
 */

public class GetInstructorDetailDemo {

    public static void main(String[] args) {


        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create objects
            session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 1);

            System.out.println("Detail " + instructorDetail);

            System.out.println("Instr " + instructorDetail.getInstructor());

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }

}