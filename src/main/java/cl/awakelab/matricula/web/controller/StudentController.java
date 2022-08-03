package cl.awakelab.matricula.web.controller;

import cl.awakelab.matricula.model.domain.dto.Student;
import cl.awakelab.matricula.model.domain.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String findAll(Model model){
        model.addAttribute("students",
                service.findAll()
                        .orElse(new ArrayList<Student>()));
        return "studentList";
    }

    @GetMapping("/new")
    public String create(){
        return "studentNew";
    }

    @GetMapping("/edit/{studentId}")
    public String edit(@PathVariable("studentId") int studentId, Model model){
        model.addAttribute("student",
                service.findById(studentId)
                        .orElse(new Student()));

        return "studentEdit";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Student student){
        service.save(student);
        return "redirect:/student/all";
    }
    @GetMapping("/del/{studentId}")
    public String delete(@PathVariable("studentId") int studentId){
        service.delete(studentId);
        return "redirect:/student/all";
    }

}
