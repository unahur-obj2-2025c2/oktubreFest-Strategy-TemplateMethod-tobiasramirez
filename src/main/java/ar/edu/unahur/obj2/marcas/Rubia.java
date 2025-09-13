package ar.edu.unahur.obj2.marcas;

public class Rubia extends Marca {
    private Double graduacion;

    public Rubia(Double contenidoDeLupulo, String pais, Double graduacion) {
        super(contenidoDeLupulo, pais);
        this.graduacion = graduacion;
    }

    @Override
    public Double graduacion() {
       return this.graduacion;
    }

}
