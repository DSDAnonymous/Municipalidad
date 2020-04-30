package pe.municipalidad.plataforma.servicioDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.municipalidad.plataforma.entidades.CategoriaAtencion;
import pe.municipalidad.plataforma.repositorio.RepositorioCategoriaAtencion;
import pe.municipalidad.plataforma.repositorio.RepositorioUsuario;

import java.util.List;

@Service
public class ServicioDAOCategoriaAtencion {
    @Autowired
    private RepositorioCategoriaAtencion repositorioCategoriaAtencion;

    public List<CategoriaAtencion> listar() {
        return repositorioCategoriaAtencion.findAll();
    }
}
