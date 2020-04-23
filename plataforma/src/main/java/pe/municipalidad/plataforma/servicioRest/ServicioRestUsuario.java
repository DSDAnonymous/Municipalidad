package pe.municipalidad.plataforma.servicioRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.municipalidad.plataforma.entidades.Usuario;
import pe.municipalidad.plataforma.servicioDAO.ServicioDAOUsuario;

@RestController
@RequestMapping("/api")
public class ServicioRestUsuario {
    @Autowired
    private ServicioDAOUsuario servicioDAOUsuario;

    @PostMapping("/registro")
    public Usuario registrar(@RequestBody Usuario usuario) {
        Usuario u;
        try {
            u = servicioDAOUsuario.registrar(usuario);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo registrar", e);
        }
        return u;
    }
    @GetMapping("/usuarios")
    public List<Usuario> listado(){
        List<Usuario> l;
        try {
            l = servicioDAOUsuario.listado();
        }catch ( Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo obtener", e);
        }
        return l;
    }
}
