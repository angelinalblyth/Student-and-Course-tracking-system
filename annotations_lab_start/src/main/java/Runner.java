import db.DBCourse;
import db.DBHelper;
import models.*;

import java.util.Calendar;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("Human Physiology", Level.PHD);
        DBHelper.save(course1);
        Course course2 = new Course("CS50", Level.BA);
        DBHelper.save(course2);

        Instructor instructor1 = new Instructor("Steve");
        DBHelper.save(instructor1);

        Calendar cal = Calendar.getInstance();
        cal.set(2018, 7, 2);

        Lesson lesson1 = new Lesson("Biology", 3, cal, course1, instructor1);
        DBHelper.save(lesson1);
        Lesson lesson2 = new Lesson("Python", 2, cal,course2, instructor1);
        DBHelper.save(lesson2);
        Lesson lesson3 = new Lesson("Ruby", 4, cal, course2, instructor1);
        DBHelper.save(lesson3);
        Lesson lesson4 = new Lesson("Machine Learning", 2, cal, course2, instructor1);
        DBHelper.save(lesson4);

        Student student1 = new Student("Angelina", "Blyth", 27, 12345, course1);
        DBHelper.save(student1);
        Student student2 = new Student("Louise", "Reekie", 29, 12346, course2);
        DBHelper.save(student2);
        Student student3 = new Student("Jamie", "Logan", 25, 12347, course1);
        DBHelper.save(student3);
        Student student4 = new Student("Christy", "Whyte", 34, 12348, course2);
        DBHelper.save(student4);
        Student student5 = new Student("Meg", "Smith", 26, 12349, course1);
        DBHelper.save(student5);




        student1.setAge(28);
        DBHelper.update(student1);

        DBHelper.delete(student2);

        List<Student> students = DBHelper.getAll(Student.class);
        List<Course> courses = DBHelper.getAll(Course.class);
        List<Lesson> lessons = DBHelper.getAll(Lesson.class);

        Student foundStudent = DBHelper.find(Student.class, 1);
        Course foundCourse = DBHelper.find(Course.class, 1);

        List<Student> studentsOnCourse = DBCourse.listOfStudentOnCourse(course1);
        List<Lesson> lessonsOnCourse = DBCourse.listOfLessonsOnCourse(course2);

    }
}
