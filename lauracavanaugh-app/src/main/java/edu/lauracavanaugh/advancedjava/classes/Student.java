package edu.lauracavanaugh.advancedjava.classes;


import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author laura
 */
public class Student extends Person {

     private ArrayList<StudentCourse> enrolledCourses;

    /**
     * Create a new Student.
     * Similarly to Faculty, default data doesn't really make sense in this object,
     * the calling class must be sure to set all of its properties accordingly.
     */
    public Student(String name) {

        super(name);

        //but we do need to initialize the enrolledCourses list...
        this.enrolledCourses = new ArrayList<StudentCourse>();
    }

    @Override
    public String toString() {
        return  "Student{" + super.toString() + ", enrolledCourses=" + enrolledCourses + '}';
    }

    public ArrayList<StudentCourse> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(ArrayList<StudentCourse> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

}