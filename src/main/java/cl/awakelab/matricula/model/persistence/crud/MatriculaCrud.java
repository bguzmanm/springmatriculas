package cl.awakelab.matricula.model.persistence.crud;

import cl.awakelab.matricula.model.persistence.entity.Matricula;
import cl.awakelab.matricula.model.persistence.entity.MatriculaPK;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.DoubleStream;

public interface MatriculaCrud extends CrudRepository<Matricula, MatriculaPK> {

}
