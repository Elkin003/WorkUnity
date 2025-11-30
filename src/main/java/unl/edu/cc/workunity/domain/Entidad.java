package unl.edu.cc.workunity.domain;
import unl.edu.cc.workunity.domain.enums.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Cristian Guaman
 */
public class Entidad {
    private String nombre;
    private String apellido;
    private String numeroTelefono;
    private LocalDate fechaCreacion;

    private Usuario usuario;
    private List<Proyecto> proyectos;
    private List<Integrante> integrantes;

    public Entidad(String nombre, String apellido, String numeroTelefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefono = numeroTelefono;
        this.fechaCreacion = LocalDate.now();
    }

    public List<Proyecto> listarProyectos() {
        if(proyectos==null){
            return new ArrayList<>();
        }
        return new ArrayList<>(proyectos);
    }

    public List<Integrante> listarIntegrantes() {
        if(integrantes==null){
            return new ArrayList<>();
        }
        return new ArrayList<>(integrantes);
    }

    public void agregarProyecto(Proyecto proyecto) {
        getProyectos();
        if(!this.proyectos.contains(proyecto)){
            proyectos.add(proyecto);
        }
    }

    public void crearProyecto(String nombre, String descripcion, LocalDate fechaLimite) {
        Proyecto proyecto = new Proyecto(nombre, descripcion, fechaLimite, this);
        this.agregarProyecto(proyecto);
        Integrante integrante = new Integrante(Rol.LIDER, this, proyecto);
        this.getIntegrantes().add(integrante);
        proyecto.getMiembros().add(integrante);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Proyecto> getProyectos() {
        if (proyectos == null) {
            proyectos = new ArrayList<>();
        }
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<Integrante> getIntegrantes() {
        if (integrantes == null) {
            integrantes = new ArrayList<>();
        }
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entidad entidad = (Entidad) o;
        return Objects.equals(nombre, entidad.nombre) && Objects.equals(apellido, entidad.apellido) && Objects.equals(numeroTelefono, entidad.numeroTelefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, numeroTelefono);
    }

    @Override
    public String toString() {
        return "Entidad{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", proyectos=" + getProyectos() +
                ", integrantes=" + getIntegrantes() +
                '}';
    }
}