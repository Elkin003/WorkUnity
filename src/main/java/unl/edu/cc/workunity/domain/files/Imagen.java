package unl.edu.cc.workunity.domain.files;

import unl.edu.cc.workunity.domain.ArchivoAdjunto;

public class Imagen extends ArchivoAdjunto {
    public enum TipoImagen { PNG, JPG }

    private TipoImagen tipo;

    public Imagen(byte[] contenido, TipoImagen tipo) {
        super(contenido);
        this.tipo = tipo;
    }
}
