package cl.awakelab.matricula.model.persistence.crud;

import cl.awakelab.matricula.model.persistence.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoCrud extends CrudRepository<Curso, Integer> {
}
