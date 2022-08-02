package cl.awakelab.matricula.model.persistence.mapper;

import cl.awakelab.matricula.model.domain.dto.Grade;
import cl.awakelab.matricula.model.persistence.entity.Curso;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TeacherMapper.class})
public interface GradeMapper {
    @Mappings({
            @Mapping(source = "id", target = "gradeId"),
            @Mapping(source = "codigo", target = "code"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "facilitadorId", target = "teacherId"),
            @Mapping(source = "facilitador", target = "teacher"),
    })
    Grade toGrade(Curso curso);
    List<Grade> toGrades(List<Curso> curso);
    @InheritInverseConfiguration
    Curso toCurso(Grade grade);
}
