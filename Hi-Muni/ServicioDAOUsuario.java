package pe.municipalidad.plataforma.servicioDAO;

import antlr.collections.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.municipalidad.plataforma.entidades.Usuario;
import pe.municipalidad.plataforma.repositorio.RepositorioUsuario;

import javax.validation.OverridesAttribute;

@Service
public class ServicioDAOUsuario {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Usuario registrar(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public List<Usuario> listado(){
        return repositorioUsuario.findAll();
    }
    public Usuario obtenerArtefacto(long DNI){
        return repositorioUsuario.findById(DNI).get();
    }
}
