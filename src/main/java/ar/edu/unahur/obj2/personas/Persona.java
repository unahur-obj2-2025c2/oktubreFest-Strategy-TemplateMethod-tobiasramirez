package ar.edu.unahur.obj2.personas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.carpas.Carpa;
import ar.edu.unahur.obj2.jarras.*;
import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.nacionalidades.Nacionalidad;

public class Persona {
    private Double peso;
    private List<Jarra> jarrasCompradas;
    private Boolean leGustaMusicaTradicional;
    private Integer nivelDeAguante;
    private Nacionalidad nacionalidad;

    public Persona(Double peso, Boolean leGustaMusicaTradicional, Integer nivelDeAguante, Nacionalidad nacionalidad) {
        this.peso = peso;
        this.leGustaMusicaTradicional = leGustaMusicaTradicional;
        this.nivelDeAguante = nivelDeAguante;
        this.nacionalidad = nacionalidad;
        this.jarrasCompradas = new ArrayList<>();
    }

    public Boolean estaEbria() {
        return this.alcoholIngerido() * peso > nivelDeAguante;
    }

    public Double alcoholIngerido() {
        return jarrasCompradas.stream().mapToDouble(j -> j.contenidoAlcohol()).sum();
    }

    public Boolean leGusta(Marca unaMarca) {
        return switch (nacionalidad.name()) {
            case "BELGA" ->
                unaMarca.getContenidoDeLupulo() > 4;

            case "CHECO" ->
                unaMarca.graduacion() > 0.08;

            case "ALEMAN" ->
                true;

            default ->
                false;

        };

    }
     public Boolean getLeGustaMusicaTradicional() {
        return leGustaMusicaTradicional;
    }
    public Boolean quiereEntrar(Carpa unaCarpa) {
        return this.leGusta(unaCarpa.getMarca()) && 
        (this.leGustaMusicaTradicional && unaCarpa.getTieneUnaBanda()) && 
        !(nacionalidad.name().equals("ALEMAN")|| 
        unaCarpa.cantidadPersonas() <= unaCarpa.getLimiteAdmitido()) ;

    }
    public Boolean puedeEntrar(Carpa carpa){
        return this.quiereEntrar(carpa) && carpa.dejaIngresar(this);
    }
    public void comprarJarra(Jarra jarra){
        jarrasCompradas.add(jarra);
    }

    public List<Jarra> getJarrasCompradas() {
        return jarrasCompradas;
    }
    public Boolean esEbrioEmpedernido(){
        return this.estaEbria() && jarrasCompradas.stream().allMatch(j->j.getCapacidad() > 1.0);
    }
    
    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public Boolean esPatriota(){
        return jarrasCompradas.stream().allMatch(j->j.getMarca().getPais().name().equals(this.getNacionalidad()));
    }
    public Boolean sonCompatibles(Persona persona){
        Set<Marca> marcas = this.jarrasCompradas.stream().map(j->j.getMarca().collect(Collector.toSet()))
        Set<Marca> marcas2 = persona.jarrasCompradas.stream().map(j->j.getMarca().collect(Collector.toSet()))
        Integer coincidencias = 0;
        for (Marca marca: marcas) {
            if(marcas2.contains(marca)){
                coincidencias+=1;
            }
        }
    }
}
