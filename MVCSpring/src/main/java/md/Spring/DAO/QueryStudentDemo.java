package md.Spring.DAO;

import md.Spring.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author Babin Sergiu
 */

public class QueryStudentDemo {

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

            // query students
            List<Student> studentList = session.createQuery("from Student").getResultList();

            for (Student i : studentList) {
                System.out.println(i);
            }

            List<Student> studentList1 = session.createQuery("from Student s WHERE s.firstName='John'").getResultList();

            for (Student i : studentList1) {
                System.out.println(i);
            }
            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        finally {
            factory.close();
        }


    }

}