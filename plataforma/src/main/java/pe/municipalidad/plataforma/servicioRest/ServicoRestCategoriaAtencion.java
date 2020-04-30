package pe.municipalidad.plataforma.servicioRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pe.municipalidad.plataforma.entidades.CategoriaAtencion;
import pe.municipalidad.plataforma.entidades.ComplexResponse;
import pe.municipalidad.plataforma.servicioDAO.ServicioDAOCategoriaAtencion;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class ServicoRestCategoriaAtencion {
    @Autowired
    private ServicioDAOCategoriaAtencion servicioDAOCategoriaAtencion;
    @GetMapping("/listar")
    public ComplexResponse<List<CategoriaAtencion>> listar() {
        ComplexResponse<List<CategoriaAtencion>> rpta = new ComplexResponse<>();

        try {
            rpta.setData(servicioDAOCategoriaAtencion.listar());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo registrar", e);
        }
        return rpta ;
    }
}
