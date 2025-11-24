package unl.edu.cc.workunity.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;
import unl.edu.cc.workunity.domain.enums.TipoArchivo;

public class ArchivoAdjunto {
  private float tamanio;
  private byte[] contenido;
  private TipoArchivo tipoArchivo;

    public ArchivoAdjunto() {
    }

    public ArchivoAdjunto(float tamanio, byte[] contenido, TipoArchivo tipoArchivo) {
        this.tamanio = tamanio;
        this.contenido = contenido;
        this.tipoArchivo = tipoArchivo;
    }

    public float getTamanio() {
        return tamanio;
    }

    public void setTamanio(float tamanio) {
        this.tamanio = tamanio;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public TipoArchivo getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(TipoArchivo tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ArchivoAdjunto.class.getSimpleName() + "[", "]")
                .add("tamanio=" + tamanio)
                .add("contenido=" + Arrays.toString(contenido))
                .add("tipoArchivo=" + tipoArchivo)
                .toString();
    }

}