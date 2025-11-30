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

    private Entidad entidad;

    public Usuario(String nombre, String email, String contrasenia) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario entidad = (Usuario) o;
        return Objects.equals(nombre, entidad.nombre)
                && Objects.equals(email, entidad.email)
                && Objects.equals(contrasenia, entidad.contrasenia);
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
                '}';
    }
}