package com.ryk.test.data;

public class Course {
    protected int courseCred = 0;
    protected String courseName = "";
    protected String courseId = "";
    protected String teacher = "";

    protected void createId(){
        this.courseId = "c" + this.courseCred + "-" + this.courseName;
    }

    public int getCourseCred() {
        return this.courseCred;
    }

    public void setCourseCred(int courseCred) {
        this.courseCred = courseCred;
        createId();
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
        createId();
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTeacher() {
        return this.teacher;
    }


}