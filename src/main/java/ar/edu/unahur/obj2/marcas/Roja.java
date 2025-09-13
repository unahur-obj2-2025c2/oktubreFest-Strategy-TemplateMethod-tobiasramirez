package ar.edu.unahur.obj2.marcas;

public class Roja extends Negra {

    public Roja(Double contenidoDeLupulo, String pais) {
        super(contenidoDeLupulo, pais);
       
    }

    @Override
    public Double graduacion() {
        return super.graduacion() * 1.25;
    }

}
