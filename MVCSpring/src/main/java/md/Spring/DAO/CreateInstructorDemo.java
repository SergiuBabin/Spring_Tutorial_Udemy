package md.Spring.DAO;

import md.Spring.models.Instructor;
import md.Spring.models.InstructorDetail;
import md.Spring.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * @author Babin Sergiu
 */

public class CreateInstructorDemo {

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

//            Instructor tempIntstructor =
//                    new Instructor("Sergiu", "Babin", "sergiubabin17@gmail.com");
//
//            InstructorDetail tempInstructorDetail = new InstructorDetail("SergiuB", "fishing");
//
//            tempIntstructor.setInstructorDetail(tempInstructorDetail);

            Instructor tempIntstructor =
                    new Instructor("Ghena", "Caraman", "sergiubabin17@gmail.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("GhennaC", "fishing");

            tempIntstructor.setInstructorDetail(tempInstructorDetail);

            session.save(tempIntstructor);



            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }

}