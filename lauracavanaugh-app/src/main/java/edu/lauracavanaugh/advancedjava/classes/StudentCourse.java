package edu.lauracavanaugh.advancedjava.classes;

import edu.lauracavanaugh.advancedjava.interfaces.ICourse;

/**
 *
 * @author laura
 */
public class StudentCourse implements ICourse {

    private String courseId;

     public StudentCourse(String courseId) {
        this.courseId = courseId;
     }

    @Override
    public String toString() {
        return "StudentCourse{" + "courseId=" + courseId + '}';
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

}
