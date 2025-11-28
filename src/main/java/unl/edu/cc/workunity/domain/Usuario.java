package unl.edu.cc.workunity.domain;
import unl.edu.cc.workunity.domain.enums.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Cristian Guaman
 */
public class Usuario {
    private String nombre;
    private String email;
    private String contrasenia;
    private List<Proyecto> proyectos;
    private List<Integrante> integrantes;

    public Usuario(String nombre, String email, String contrasenia) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre)
                && Objects.equals(email, usuario.email)
                && Objects.equals(contrasenia, usuario.contrasenia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, email, contrasenia);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", proyectos=" + proyectos +
                ", integrantes=" + integrantes +
                '}';
    }
}