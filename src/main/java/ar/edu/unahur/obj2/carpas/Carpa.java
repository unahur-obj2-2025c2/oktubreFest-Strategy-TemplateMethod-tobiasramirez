package ar.edu.unahur.obj2.carpas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.jarras.Jarra;
import ar.edu.unahur.obj2.marcas.Marca;
import ar.edu.unahur.obj2.personas.Persona;

public class Carpa {
    private final Integer limiteAdmitido;
    private final Boolean tieneUnaBanda;
    private final Marca marca;
    private Jarra jarra;
    private List<Persona> personas;

    public Integer cantidadPersonas() {
        return personas.size();
    }

    public Carpa(Integer limiteAdmitido, Boolean tieneUnaBanda, Marca marca, Jarra jarra) {
        this.limiteAdmitido = limiteAdmitido;
        this.tieneUnaBanda = tieneUnaBanda;
        this.marca = marca;
        this.jarra = jarra;
        this.personas = new ArrayList<>();
    }

    public Integer getLimiteAdmitido() {
        return limiteAdmitido;
    }

    public Boolean getTieneUnaBanda() {
        return tieneUnaBanda;
    }

    public Marca getMarca() {
        return marca;
    }

    public Jarra getJarra() {
        return jarra;
    }
    public Boolean dejaIngresar(Persona persona){
        return ! persona.estaEbria() && this.cantidadPersonas() < limiteAdmitido;
    }
    public Boolean puedeEnrtarAUnaCarpa(Persona persona){
        return persona.quiereEntrar(this) && this.dejaIngresar(persona);
    }
    public void entrarACarpa(Persona persona){
        if(persona.puedeEntrar(this)){
            personas.add(persona);
        } else{
            throw new RuntimeException("no puede entrar a la carpa");
        }
    }

    public void servirJarraDeCerveza(Persona persona, Double capacidad){
        if (! (personas.contains(persona))){
            throw new RuntimeException("no se encuentra en la carpa");

        }
        persona.comprarJarra(new Jarra(capacidad, marca));
       

    }
    public long cantidadEbriosEmpedernidos(){
        return personas.stream().filter(p->p.esEbrioEmpedernido()).count();
    }
    public Boolean esHomogenea() {
        return this.personas.stream().allMatch(p->p.getNacionalidad());
    }
    
   
}
