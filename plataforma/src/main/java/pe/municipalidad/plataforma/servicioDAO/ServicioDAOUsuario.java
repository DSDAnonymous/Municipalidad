package pe.municipalidad.plataforma.servicioDAO;

import antlr.collections.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.municipalidad.plataforma.entidades.ComplexResponse;
import pe.municipalidad.plataforma.entidades.Respuesta;
import pe.municipalidad.plataforma.entidades.Usuario;
import pe.municipalidad.plataforma.repositorio.RepositorioUsuario;

import javax.validation.OverridesAttribute;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicioDAOUsuario {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Respuesta registrar(Usuario usuario) {
        //repositorioUsuario.
        Respuesta r = new Respuesta();

        if (repositorioUsuario.existsById(usuario.getDni())) {
            r.setMensajeRespuesta("El DNI ingresado ya se encuentra registrado");
        } else {
            repositorioUsuario.save(usuario);
             r.setCodigoRespuesta(1);
            r.setMensajeRespuesta("Usuario registrado satisfactoriamente");
        }

        return r;
    }

    public ComplexResponse<Usuario> login(Usuario usuario) {
        ComplexResponse<Usuario> r = new ComplexResponse<>();
        Optional<Usuario> o = repositorioUsuario.findById(usuario.getDni());
        Usuario u = o.isPresent() ? o.get() : null;

        if (u == null) {
            r.setMensajeRespuesta("El DNI ingresado no se encuentra registrado");
        } else if (u.getClave().equals(usuario.getClave()) == false) {
            r.setMensajeRespuesta("Contraseña incorrecta");
        } else {
            r.setCodigoRespuesta(1);
            r.setMensajeRespuesta("Usuario validado satisfactoriamente");
            r.setData(u);
        }

        return r;
    }



}
