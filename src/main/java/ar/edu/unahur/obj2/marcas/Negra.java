package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.reglamento.Reglamento;

public class Negra extends Marca {

    public Negra(Double contenidoDeLupulo, String pais) {
        super(contenidoDeLupulo, pais);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Double graduacion() {
        return Math.min(Reglamento.getIntance().getGraduacionReglamentaria(), getContenidoDeLupulo() * 2);
    }

}
