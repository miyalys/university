package dk.kea.university.controllers;

import dk.kea.university.models.Course;
import dk.kea.university.models.User;
import dk.kea.university.services.SeCourse;
import dk.kea.university.services.SeUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

// Security

@Controller
@RequestMapping("users")
public class UserController {

  private final SeUser seUser;
  private final SeCourse seCourse;
  String prefixPath="users/";

  public UserController(SeUser seUser, SeCourse seCourse) {
    this.seUser = seUser;
    this.seCourse = seCourse;

  }

  @Secured({"ROLE_ADMIN"})
  @GetMapping("/inCourse")
  public String usersInCourse(@PathVariable("courseId") int courseId) {
    //Iterable<User> usersInCourse = seUser.getUsersInCourse();
    return prefixPath + "inCourse";
  }

  // A student requests to sign up for a course. Done via the course list and possibly also info
  // Teachers sign up while adding a course or editing one.
  @Secured({"ROLE_STUDENT"})
  @PostMapping("/student-signup")
  public String signup(Principal p, @RequestParam("id") int course_id){

    User user = seUser.findUserByName(p.getName());
    Course course = seCourse.findCourse(course_id);
    course.setPendingStudents(user);
    seCourse.save(course);
    return prefixPath + "signupOk";
  }

  @Secured({"ROLE_ADMIN"})
  @GetMapping("/student-signup-requests")
  public String studentSignupRequests() {
    return prefixPath + "student-signup-requests";
  }

  @Secured({"ROLE_ADMIN"})
  @PostMapping("/student-signup-requests")
  public String pstudentSignupRequests() {
    return "redirect:/student-signup-requests";
  }

  // A list of "My" courses, ie. the courses you're in as a Student, or assigned to as a Teacher.
  @Secured({"ROLE_STUDENT", "ROLE_TEACHER"})
  @GetMapping("/my")
  public String my() {
      return prefixPath + "my";
  }


}
