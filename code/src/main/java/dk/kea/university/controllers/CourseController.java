package dk.kea.university.controllers;

import dk.kea.university.services.SeCourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

// Security
import org.springframework.security.access.annotation.Secured;

@Controller
@RequestMapping("courses")
public class CourseController {

  private final SeCourse seCourse;

  public CourseController(SeCourse seCourse) {
    this.seCourse = seCourse;
  }

  String pathPrefix="courses/";

  // CRUD

  @GetMapping("/list")
  public String list(Model m){
    m.addAttribute("courses", seCourse.list());
    return pathPrefix + "list";
  }

  // These roles must match the ones specified in SecurityConfig.java
  //@Secured({"ROLE_TEACHER","ROLE_ADMIN"})
  @GetMapping("/add")
  public String add(){
    return pathPrefix + "add";
  }

  //@Secured({"ROLE_TEACHER","ROLE_ADMIN"})
  @PostMapping("/add")
  public String padd(){
    return "redirect:/add";
  }

  //@Secured({"ROLE_TEACHER","ROLE_ADMIN"})
  @GetMapping("/update")
  public String update(){
    return pathPrefix + "update";
  }

  //@Secured({"ROLE_TEACHER","ROLE_ADMIN"})
  @PostMapping("/update")
  public String pupdate(){
    return "redirect:/";
  }

  //@Secured({"ROLE_ADMIN"})
  @PostMapping("/delete")
  public String delete(){
    return "redirect:/";
  }

}
