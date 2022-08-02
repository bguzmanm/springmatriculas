package cl.awakelab.matricula.web.restcontroller;

import cl.awakelab.matricula.model.domain.dto.Student;
import cl.awakelab.matricula.model.domain.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

    private final StudentService service;

    public StudentRestController(StudentService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<Optional<List<Student>>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

}
