package pe.municipalidad.plataforma.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.municipalidad.plataforma.entidades.CategoriaAtencion;

public interface RepositorioCategoriaAtencion extends JpaRepository<CategoriaAtencion, Long> {
}
