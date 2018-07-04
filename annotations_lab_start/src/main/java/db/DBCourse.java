package db;

import models.Course;
import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCourse {

    private static Transaction transaction;
    private static Session session;

    public static List<Student> listOfStudentOnCourse(Course course){
        session =  HibernateUtil.getSessionFactory().openSession();
        List<Student> students = null;
        try {

            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("course", course));
            students = criteria.list();
        }catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }return students;
    }

    public static List<Lesson> listOfLessonsOnCourse(Course course){
        session =  HibernateUtil.getSessionFactory().openSession();
        List<Lesson> lessons = null;
        try {

            Criteria criteria = session.createCriteria(Lesson.class);
            criteria.add(Restrictions.eq("course", course));
            lessons = criteria.list();
        }catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }return lessons;
    }
}
