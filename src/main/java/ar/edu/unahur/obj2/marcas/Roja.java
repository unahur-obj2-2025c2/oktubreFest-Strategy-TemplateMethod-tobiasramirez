package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.nacionalidades.Nacionalidad;

public class Roja extends Negra {

    public Roja(Double contenidoDeLupulo, Nacionalidad pais) {
        super(contenidoDeLupulo, pais);
       
    }

    @Override
    public Double graduacion() {
        return super.graduacion() * 1.25;
    }

}
