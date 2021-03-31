package md.Spring.DAO;

import md.Spring.models.Instructor;
import md.Spring.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author Babin Sergiu
 */

public class DeleteInstructorDemo {

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

            Instructor instructor = session.get(Instructor.class, 2);

            session.delete(instructor);

            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }


    }

}