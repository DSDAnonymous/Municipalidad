package pe.municipalidad.plataforma.servicioDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.municipalidad.plataforma.entidades.Usuario;
import pe.municipalidad.plataforma.repositorio.RepositorioUsuario;

@Service
public class ServicioDAOUsuario {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Usuario registrar(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }
}
