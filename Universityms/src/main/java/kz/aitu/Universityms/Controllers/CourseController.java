package kz.aitu.Universityms.Controllers;

import kz.aitu.Universityms.entities.Course;
import org.springframework.web.bind.annotation.*;

@RestController

public class CourseController {

    @PostMapping("/addCourse")
    public String addCourse(@RequestBody Course course) {
        dbms.addCourse(course.getCourseName(), course.getCourseCode(), course.getCredits());

        return dbms.getCourseInfo();
    };


    @PostMapping("/changeCredits")
    public String ChangeCredits(@RequestBody Course course) {
        dbms.updateCourseCredits(course.getCourseName(), course.getCredits());

        return dbms.getCourseInfo();
    }

    @PostMapping("/dropCourse")
    public String DropCourse(@RequestBody Course course) {
        dbms.dropCourse(course.getCourseName());

        return dbms.getCourseInfo();
    };


    @PostMapping("/getCourseInfo")
    public String GetInfo() {
        return dbms.getCourseInfo();
    };
}


