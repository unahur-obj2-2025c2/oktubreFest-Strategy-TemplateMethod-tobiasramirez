package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.nacionalidades.Nacionalidad;

public abstract class Marca {
    private Double contenidoDeLupulo;
    private Nacionalidad pais;
    public Marca(Double contenidoDeLupulo, Nacionalidad pais) {
        this.contenidoDeLupulo = contenidoDeLupulo;
        this.pais = pais;
    }
    public abstract Double graduacion();

    public Double getContenidoDeLupulo() {
        return contenidoDeLupulo;
    }
    public Nacionalidad getPais() {
        return pais;
    }
    

}
