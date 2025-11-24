package unl.edu.cc.workunity.domain;

import unl.edu.cc.workunity.domain.enums.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Cristian Guaman
 */
public class Proyecto {

    private String nombre;
    private String descripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaLimite;
    //Relaciones
    private Usuario creador;
    private List<Integrante> miembro;
    private List<Tarea> tarea;

    public Proyecto(String nombre, String descripcion, LocalDate fechaLimite, Usuario creador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDate.now();
        this.fechaLimite = fechaLimite;
        this.creador = creador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public List<Integrante> getMiembros() {
        if (miembro == null) {
            miembro = new ArrayList<>();
        }
        return miembro;
    }

    public void setMiembros(List<Integrante> miembros) {
        this.miembro = miembros;
    }

    public List<Tarea> getTareas() {
        if (tarea == null) {
            tarea = new ArrayList<>();
        }
        return tarea;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tarea = tareas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Proyecto proyecto = (Proyecto) o;
        return Objects.equals(nombre, proyecto.nombre) && Objects.equals(descripcion, proyecto.descripcion) && Objects.equals(creador, proyecto.creador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion, creador);
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", dscripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaLimite=" + fechaLimite +
                ", creador=" + creador +
                ", miembro=" + miembro +
                ", tarea=" + tarea +
                '}';
    }
}