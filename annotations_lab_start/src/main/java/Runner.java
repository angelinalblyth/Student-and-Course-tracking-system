import db.DBHelper;
import models.Course;
import models.Level;
import models.Student;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("Human Physiology", Level.PHD);
        DBHelper.save(course1);
        Course course2 = new Course("CS50", Level.BA);
        DBHelper.save(course2);

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

    }
}
