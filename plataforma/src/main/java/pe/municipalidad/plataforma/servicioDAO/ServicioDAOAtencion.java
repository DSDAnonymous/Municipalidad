package pe.municipalidad.plataforma.servicioDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.municipalidad.plataforma.entidades.*;
import pe.municipalidad.plataforma.repositorio.RepositorioCalificacion;
import pe.municipalidad.plataforma.repositorio.RepositorioCategoriaAtencion;
import pe.municipalidad.plataforma.repositorio.RepositorioQuejas;
import pe.municipalidad.plataforma.repositorio.RepositorioUsuario;

import java.util.Date;
import java.util.Optional;

@Service
public class ServicioDAOAtencion {

    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private RepositorioCategoriaAtencion repositorioCategoria;

    @Autowired
    private RepositorioCalificacion repositorioCalificacion;
    @Autowired
    private RepositorioQuejas repositorioQuejas;

    public Respuesta registrar(Quejas input){
        Respuesta rpta = new Respuesta();

        // Validación de existencia del código de usuario
        Optional<Usuario> oUser = repositorioUsuario.findById(input.getIdUsuario());

        if (oUser.isPresent() == false) {
            rpta.setMensajeRespuesta("El usuario indicado no existe");
            return rpta;
        }

        // Validación de existencia del código de categoría
        Optional<CategoriaAtencion> oCat = repositorioCategoria.findById(input.getIdCategoria());

        if (oCat.isPresent() == false) {
            rpta.setMensajeRespuesta("La categoría indicado no existe");
            return rpta;
        }

        if (input.getDetalle() == null || input.getDetalle().trim().length() == 0) {
            rpta.setMensajeRespuesta("Ingrese detalle de queja");
            return rpta;
        }

        input.setFecha(new Date());

        repositorioQuejas.save(input);

        rpta.setCodigoRespuesta(1);
        rpta.setMensajeRespuesta("Su queja ha sido registrada satisfactoriamente");

        return rpta;
    }

    public Respuesta calificar(Calificacion input){
        Respuesta rpta = new Respuesta();

        // Validación de existencia del código de usuario
        Optional<Usuario> oUser = repositorioUsuario.findById(input.getIdUsuario());

        if (oUser.isPresent() == false) {
            rpta.setMensajeRespuesta("El usuario indicado no existe");
            return rpta;
        }

        // Validación de existencia del código de categoría
        Optional<CategoriaAtencion> oCat = repositorioCategoria.findById(input.getIdCategoria());

        if (oCat.isPresent() == false) {
            rpta.setMensajeRespuesta("La categoría indicado no existe");
            return rpta;
        }

        if (input.getDetalle() == null || input.getDetalle().trim().length() == 0) {
            rpta.setMensajeRespuesta("Ingrese detalle de queja");
            return rpta;
        }

        if (input.getValoracion() <= 0) {
            rpta.setMensajeRespuesta("Ingrese valoración");
            return rpta;
        }

        input.setFecha(new Date());

        repositorioCalificacion.save(input);

        rpta.setCodigoRespuesta(1);
        rpta.setMensajeRespuesta("Su valoración ha sido registrada satisfactoriamente");

        return rpta;
    }
}
