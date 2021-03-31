package md.Spring.DAO;

import md.Spring.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author Babin Sergiu
 */

public class UpdateStudentDemo {

    public static void main(String[] args) {


        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();
            Student student = session.get(Student.class, 1);

            // Update the student object
            System.out.println("Update the student...");

            student.setFirstName("Sergiu");

            session.createQuery("update Student set email='sergiu@gmail.com'")
                    .executeUpdate();
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }

}