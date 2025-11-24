package unl.edu.cc.workunity.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Cristian Guaman
 */

public class Proyecto {

    private String nombre;
    private String dscripcion;
    private LocalDate fechaCreacion;
    private LocalDate fechaLimite;
    //Relaciones
    private Usuario creador;
    private List<Integrante> miembro;
    private List<Tarea> tarea;

    public Proyecto(String nombre, String descripcion, LocalDate fechaLimite) {
        this.nombre = nombre;
        this.dscripcion = descripcion;
        fechaCreacion = LocalDate.now();
        this.fechaLimite = fechaLimite;
    }

    public Proyecto(String nombre, String dscripcion, LocalDate fechaCreacion, LocalDate fechaLimite, Usuario creador,
                    Integrante administrador, List<Integrante> miembro, List<Tarea> tarea) {
        this.nombre = nombre;
        this.dscripcion = dscripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaLimite = fechaLimite;
        this.creador = creador;
        this.miembro = new ArrayList<>();
        this.tarea = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDscripcion() {
        return dscripcion;
    }

    public void setDscripcion(String dscripcion) {
        this.dscripcion = dscripcion;
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
        return Objects.equals(nombre, proyecto.nombre) && Objects.equals(dscripcion, proyecto.dscripcion)
                && Objects.equals(fechaCreacion, proyecto.fechaCreacion)
                && Objects.equals(fechaLimite, proyecto.fechaLimite)
                && Objects.equals(creador, proyecto.creador)
                //& Objects.equals(administrador, proyecto.administrador)&
                && Objects.equals(miembro, proyecto.miembro)
                && Objects.equals(tarea, proyecto.tarea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dscripcion, fechaCreacion, fechaLimite, creador, miembro, tarea);
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", dscripcion='" + dscripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaLimite=" + fechaLimite +
                ", creador=" + creador +
                ", miembro=" + miembro +
                ", tarea=" + tarea +
                '}';
    }
}