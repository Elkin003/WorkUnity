package unl.edu.cc.workunity.domain;
import unl.edu.cc.workunity.domain.enums.Rol;
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
        this.proyecto.setNombre(nuevoNombre);
        this.proyecto.setDescripcion(nuevaDescripcion);
        this.proyecto.setFechaLimite(nuevaFechaLimite);
    }

    public void eliminarProyecto() {
        validarLider();
        this.proyecto.getMiembros().clear();
        this.proyecto.getTareas().clear();
    }

    public void agregarIntegrante(Usuario usuario) {
        validarLider();
        Integrante integranteNuevo = new Integrante(Rol.MIEMBRO, usuario, this.proyecto);

        if (!this.proyecto.getMiembros().contains(integranteNuevo)) {
            this.proyecto.getMiembros().add(integranteNuevo); // Agrega un integrante al proyecto
            usuario.getIntegrantes().add(integranteNuevo);
        }
    }

    public void crearTarea(String titulo, String descripcion, LocalDate fechaLimite) {
        validarLider();
        Tarea tarea = new Tarea(titulo, descripcion, fechaLimite, this.proyecto);
        if (!this.proyecto.getTareas().contains(tarea)) {
            this.proyecto.getTareas().add(tarea);
        }
    }

    public void asignarTarea(Tarea tarea, Integrante integranteAsignado) {
        validarLider();
        if (!this.proyecto.getMiembros().contains(integranteAsignado)) {
            throw new UnauthorizedAccessException("El integrante no pertenece al Proyecto");
        }
        tarea.setIntegranteAsignado(integranteAsignado);
        integranteAsignado.getTareas();
        integranteAsignado.tareas.add(tarea);
    }

    public void eliminarTarea(Tarea tarea) {
        validarLider();
        if (tarea.getIntegranteAsignado() != null) {
            tarea.getIntegranteAsignado().tareas.remove(tarea);
            tarea.setIntegranteAsignado(null);
        }
        this.proyecto.getTareas().remove(tarea); // Elimina una tarea del proyecto
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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
                ", usuario=" + usuario +
                ", proyecto=" + proyecto +
                ", tareas=" + tareas +
                '}';
    }
}