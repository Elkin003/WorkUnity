package unl.edu.cc.workunity.domain;

import java.util.Objects;

/**
 *
 * @author Elkin Jiménez
 */
public class Comentario {

    private String texto;

    //Relaciones
    private Integrante autor;
    private Tarea tarea;

    public Comentario(String texto, Integrante autor) {
        this.texto = texto;
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public Integrante getAutor() {
        return autor;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Comentario that = (Comentario) o;
        return Objects.equals(texto, that.texto) && Objects.equals(autor, that.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto, autor);
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "texto='" + texto + '\'' +
                ", autor=" + autor +
                ", tarea=" + tarea +
                '}';
    }
}