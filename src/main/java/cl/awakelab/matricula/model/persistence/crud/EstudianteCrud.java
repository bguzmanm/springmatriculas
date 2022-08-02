package cl.awakelab.matricula.model.persistence.crud;

import cl.awakelab.matricula.model.persistence.entity.Estudiante;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteCrud extends CrudRepository<Estudiante, Integer> {
}
