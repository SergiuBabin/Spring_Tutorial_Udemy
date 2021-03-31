package md.Spring.DAO;

import md.Spring.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author Babin Sergiu
 */

public class ReadStudentDemo {

    public static void main(String[] args) {


        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create 3 student objects
            System.out.println("Creating student object...");
            Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            System.out.println(tempStudent1);
            session.save(tempStudent1);

            // commit transaction
            session.getTransaction().commit();


            System.out.println("Student id = " + tempStudent1.getId());

            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println(session.get(Student.class, tempStudent1.getId()));

            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }

}