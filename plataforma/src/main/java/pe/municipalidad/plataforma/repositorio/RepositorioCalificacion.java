package pe.municipalidad.plataforma.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.municipalidad.plataforma.entidades.Calificacion;

public interface RepositorioCalificacion extends JpaRepository<Calificacion, Long> {
}
