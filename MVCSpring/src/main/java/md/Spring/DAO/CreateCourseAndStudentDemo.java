package md.Spring.DAO;

import md.Spring.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author Babin Sergiu
 */

public class CreateCourseAndStudentDemo {

    public static void main(String[] args) {


        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create objects
            session.beginTransaction();

            Course course = new Course("Fishing");

            session.save(course);

            Student student1 = new Student("Sergiu", "Babin", "sergiu.babin@asc.ro");
            Student student2 = new Student("Gheorghe", "Condorachi", "gheorghe.condrachi@asc.ro");
            Student student3 = new Student("Ghena", "Caraman", "ghenadie.caraman@asc.ro");

            course.addStundet(student1);
            course.addStundet(student2);
            course.addStundet(student3);

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }


    }

}