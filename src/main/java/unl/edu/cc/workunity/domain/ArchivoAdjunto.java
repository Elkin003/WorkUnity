package unl.edu.cc.workunity.domain;

import java.util.Arrays;
import java.util.StringJoiner;

public abstract class ArchivoAdjunto {
  protected float tamanio;
  protected byte[] contenido;

    // Tamaño máximo permitido para el archivo 20 MB convertidos a bytes
    private static final int TamanioMaximoBytes = 20 * 1024 * 1024;

    public ArchivoAdjunto(byte[] contenido) {
        this.tamanio = tamanio;
        this.contenido = contenido;
       validarTamanio();
    }

    public void validarTamanio() {
        if (contenido.length > TamanioMaximoBytes) {
            throw new IllegalArgumentException("El archivo supera los 20MB permitidos");
        }
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

    @Override
    public String toString() {
        return new StringJoiner(", ", ArchivoAdjunto.class.getSimpleName() + "[", "]")
                .add("tamanio=" + tamanio)
                .add("contenido=" + Arrays.toString(contenido))
                .toString();
    }
}