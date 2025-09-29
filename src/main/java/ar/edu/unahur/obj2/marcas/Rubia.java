package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.nacionalidades.Nacionalidad;

public class Rubia extends Marca {
    private Double graduacion;

    public Rubia(Double contenidoDeLupulo, Nacionalidad pais, Double graduacion) {
        super(contenidoDeLupulo, pais);
        this.graduacion = graduacion;
    }

    @Override
    public Double graduacion() {
       return this.graduacion;
    }

}
