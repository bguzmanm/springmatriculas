package cl.awakelab.matricula.model.persistence.mapper;

import cl.awakelab.matricula.model.domain.dto.Student;
import cl.awakelab.matricula.model.persistence.entity.Estudiante;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mappings({
            @Mapping(source = "id", target = "studentId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "rut", target = "dni"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "telefono", target = "phone"),
    })
    Student toStudent(Estudiante estudiante);
    List<Student> toStudents(List<Estudiante> estudiante);

    @InheritInverseConfiguration
    Estudiante toEstudiante(Student student);

}
