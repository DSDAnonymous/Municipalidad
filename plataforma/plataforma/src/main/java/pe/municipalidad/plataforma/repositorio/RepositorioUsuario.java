package pe.municipalidad.plataforma.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import pe.municipalidad.plataforma.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}
