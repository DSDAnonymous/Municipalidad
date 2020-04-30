package pe.municipalidad.plataforma.servicioRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.municipalidad.plataforma.entidades.ComplexResponse;
import pe.municipalidad.plataforma.entidades.Respuesta;
import pe.municipalidad.plataforma.entidades.Usuario;
import pe.municipalidad.plataforma.servicioDAO.ServicioDAOUsuario;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/usuario")
public class ServicioRestUsuario {
    @Autowired
    private ServicioDAOUsuario servicioDAOUsuario;

    @PostMapping("/registro")
    public Respuesta registrar(@RequestBody Usuario usuario) {
        Respuesta rpta = new Respuesta();

        try {
            // Validamos DNI contra RENIEC
            boolean existeEnReniec = validarReniec(usuario.getDni());

            if (!existeEnReniec) {
                rpta.setMensajeRespuesta("El DNI ingresado no se encuentr registrado en la RENIEC");
                return rpta;
            }

            rpta = servicioDAOUsuario.registrar(usuario);

            if (rpta.getCodigoRespuesta() == 1) {
                // Enviamos el correo para la confirmación del registro del usuario
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo registrar", e);
        }
        return rpta ;
    }

    @PostMapping("/login")
    public ComplexResponse<Usuario> login(@RequestBody Usuario usuario) {
        ComplexResponse<Usuario> rpta = new ComplexResponse<>();

        try {
            rpta = servicioDAOUsuario.login(usuario);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo registrar", e);
        }
        return rpta ;
    }

    private boolean validarReniec(Long dni) {
        // Aquí iría la invocación al servcio de la RENIEC
        return true;
    }

}
