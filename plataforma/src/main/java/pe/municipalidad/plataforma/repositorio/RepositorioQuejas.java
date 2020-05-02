package pe.municipalidad.plataforma.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.municipalidad.plataforma.entidades.Quejas;

public interface RepositorioQuejas extends JpaRepository<Quejas, Long> {
}
