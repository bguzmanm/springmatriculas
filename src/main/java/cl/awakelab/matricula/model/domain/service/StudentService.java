package cl.awakelab.matricula.model.domain.service;

import cl.awakelab.matricula.model.domain.dto.Student;
import cl.awakelab.matricula.model.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Optional<List<Student>> findAll(){
        return repo.findAll();
    }

}
