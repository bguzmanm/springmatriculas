package cl.awakelab.matricula.model.persistence.crud;

import cl.awakelab.matricula.model.persistence.entity.Facilitador;
import org.springframework.data.repository.CrudRepository;

public interface FacilitadorCrud extends CrudRepository<Facilitador, Integer> {
}
