package pe.municipalidad.plataforma.servicioRest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pe.municipalidad.plataforma.entidades.Calificacion;
import pe.municipalidad.plataforma.entidades.Quejas;
import pe.municipalidad.plataforma.entidades.Respuesta;
import pe.municipalidad.plataforma.servicioDAO.ServicioDAOAtencion;

@RestController
@RequestMapping("/api/atencion")
public class ServicioRestAtencion {
    @Autowired
    private ServicioDAOAtencion servicioDAOAtencion;

    @PostMapping("/registro")
    public Respuesta registrar(@RequestBody Quejas input) {
        Respuesta rpta = new Respuesta();

        try {
            rpta = servicioDAOAtencion.registrar(input);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo registrar la queja", e);
        }
        return rpta ;
    }

    @PostMapping("/valorar")
    public Respuesta valorar(@RequestBody Calificacion input) {
        Respuesta rpta = new Respuesta();

        try {
            rpta = servicioDAOAtencion.calificar(input);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo registrar la calificación", e);
        }
        return rpta ;
    }
}
