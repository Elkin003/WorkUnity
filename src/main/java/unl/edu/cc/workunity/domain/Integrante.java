package unl.edu.cc.workunity.domain;
import unl.edu.cc.workunity.domain.enums.Rol;
import unl.edu.cc.workunity.exceptions.ExistingIntegrantException;
import unl.edu.cc.workunity.exceptions.UnauthorizedAccessException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Leonel Lima (LMess)
 */
public class Integrante {

    private Rol rol;
    private Usuario usuario;
    private Proyecto proyecto;
    private List<Tarea> tareas;

    public Integrante(Rol rol, Usuario usuario, Proyecto proyecto) {
        this.rol = rol;
        this.usuario = usuario;
        this.proyecto = proyecto;
    }

    private void validarLider() {
        if (rol != Rol.LIDER) {
            throw new UnauthorizedAccessException("Permiso Denegado, solo el líder puede realizar esta acción.");
        }
    }

    public void editarProyecto(String nuevoNombre, String nuevaDescripcion, LocalDate nuevaFechaLimite) {
        validarLider();
        proyecto.setNombre(nuevoNombre);
        proyecto.setDescripcion(nuevaDescripcion);
        proyecto.setFechaLimite(nuevaFechaLimite);
    }

    public void agregarIntegrante(Usuario usuario) {
        validarLider();
        Integrante integranteNuevo = new Integrante(Rol.MIEMBRO, usuario, proyecto);
        if (!proyecto.getMiembros().contains(integranteNuevo)) {
            proyecto.getMiembros().add(integranteNuevo); // Agrega un integrante al proyecto
            usuario.getIntegrantes().add(integranteNuevo);
        } else {
            throw new ExistingIntegrantException("El integrante ya pertenece al proyecto.");
        }
    }

    public void asignarTarea(Tarea tarea, Integrante integranteAsignado) {
        validarLider();
        if (!proyecto.getMiembros().contains(integranteAsignado)) {
            throw new UnauthorizedAccessException("El integrante no pertenece al Proyecto");
        }
        tarea.setIntegranteAsignado(integranteAsignado);
        integranteAsignado.getTareas();
        integranteAsignado.tareas.add(tarea);
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Tarea> getTareas() {
        if (tareas == null) {
            tareas = new ArrayList<>();
        }
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Integrante that = (Integrante) o;
        return rol == that.rol && Objects.equals(usuario, that.usuario) && Objects.equals(proyecto, that.proyecto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rol, usuario, proyecto);
    }

    @Override
    public String toString() {
        return "Integrante{" +
                "rol=" + rol +
                ", usuario=" + usuario.getNombre() +
                ", proyecto=" + proyecto.getNombre() +
                ", tareas=" + getTareas().size() +
                '}';
    }
}