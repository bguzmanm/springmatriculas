package cl.awakelab.matricula.model.persistence.repository;

import cl.awakelab.matricula.model.domain.dto.Teacher;
import cl.awakelab.matricula.model.domain.repository.TeacherRepository;
import cl.awakelab.matricula.model.persistence.crud.FacilitadorCrud;
import cl.awakelab.matricula.model.persistence.entity.Estudiante;
import cl.awakelab.matricula.model.persistence.entity.Facilitador;
import cl.awakelab.matricula.model.persistence.mapper.TeacherMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FacilitadorRepository implements TeacherRepository {

    private final FacilitadorCrud crud;
    private final TeacherMapper mapper;

    public FacilitadorRepository(FacilitadorCrud crud, TeacherMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Teacher>> findAll() {
        return Optional.of(mapper.toTeachers((List<Facilitador>) crud.findAll()));
    }

    @Override
    public Optional<Teacher> findById(int teacherId) {
        return crud.findById(teacherId)
                .map(mapper::toTeacher);
    }

    @Override
    public Teacher save(Teacher teacher) {
        return mapper.toTeacher(crud.save(mapper.toFacilitador(teacher)));
    }

    @Override
    public void delete(int teacherId) {
        crud.deleteById(teacherId);
    }
}
