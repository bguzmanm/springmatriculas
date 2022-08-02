package cl.awakelab.matricula.model.domain.repository;

import cl.awakelab.matricula.model.domain.dto.Register;

import java.util.List;
import java.util.Optional;

public interface RegisterRepository {
    Optional<List<Register>> findAll();
    Optional<Register> findById(int studentId, int gradeId);
    Register save(Register register);
    void delete(int studentId, int gradeId);
}
