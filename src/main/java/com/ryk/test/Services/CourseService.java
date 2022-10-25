package com.ryk.test.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryk.test.data.ClassCourse;
import com.ryk.test.data.OnlineCourse;

@Service
public class CourseService {
    private List<OnlineCourse> oCourses = new ArrayList<>();
    private List<ClassCourse> cCourses = new ArrayList<>();

    @Autowired
    FileService fService;

    public OnlineCourse addOnlineCourse(OnlineCourse cData){
        oCourses.add(cData);
        fService.writeOnline(oCourses);
        return cData;
    }

    public ClassCourse addClassCourse(ClassCourse cData){
        cCourses.add(cData);
        fService.writeClass(cCourses);
        return cData;
    }

    public List<OnlineCourse> getOnline(){
        oCourses = fService.readOnline();
        return oCourses;
    }

    public List<ClassCourse> getClasses(){
        cCourses = fService.readClass();
        return cCourses;
    }

    public int existsbyId(String courseId){
        for (ClassCourse classCourse : cCourses) {
            if(classCourse.getCourseId().equals(courseId)){
                return 1;
            }
        }
        for(OnlineCourse onlineCourse : oCourses){
            if(onlineCourse.getCourseId().equals(courseId)){
                return 2;
            }
        }
        return 0;
    }

    public OnlineCourse searchOnlineById(String courseId){
        for (OnlineCourse onlineCourse : oCourses) {
            if(onlineCourse.getCourseId().equals(courseId))
                return onlineCourse;
        }
        return null;
    }

    public ClassCourse searchClassById(String courseId){
        for (ClassCourse classCourse : cCourses) {
            if(classCourse.getCourseId().equals(courseId))
                return classCourse;
        }
        return null;
    }

}
