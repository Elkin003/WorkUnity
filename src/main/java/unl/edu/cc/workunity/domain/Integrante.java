package unl.edu.cc.workunity.domain;
import unl.edu.cc.workunity.domain.enums.Rol;
import unl.edu.cc.workunity.exceptions.UnauthorizedAccessException;

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
            throw new UnauthorizedAccessException("Permiso Denegado, un miembro no puede modificar");
        }
    }

    public void editarProyecto(Proyecto proyecto, String nuevoNombre, String nuevaDescripcion) {
        validarLider();
        proyecto.setNombre(nuevoNombre);
        proyecto.setDscripcion(nuevaDescripcion);
    }

    public void eliminarProyecto(Proyecto proyecto) {
        validarLider();
        proyecto.getMiembros().clear();
        proyecto.getTareas().clear();
    }

    public void agregarIntegrante(Proyecto proyecto, Integrante integrante) {
        validarLider();
        if (!proyecto.getMiembros().contains(integrante)) {
            proyecto.getMiembros().add(integrante); // Agrega un integrante al proyecto
        }
    }

    public void asignarTarea(Proyecto proyecto, Tarea tarea) {
        validarLider();
        if (!proyecto.getTareas().contains(tarea)) {
            proyecto.getTareas().add(tarea); // Asigna una tarea al proyecto
        }
    }

    public void eliminarTarea(Proyecto proyecto, Tarea tarea) {
        validarLider();
        proyecto.getTareas().remove(tarea); // Elimina una tarea del proyecto
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
        return rol == that.rol;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rol);
    }

    @Override
    public String toString() {
        return "Integrante{" +
                "rol=" + rol +
                '}';
    }
}