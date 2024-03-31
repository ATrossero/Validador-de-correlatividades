package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia() {
        this.correlativas = new ArrayList<>();
    }
    public void agregarCorrelativas (Materia ... nuevasCorrelativas) {
        Collections.addAll(this.correlativas, nuevasCorrelativas);
    }
    public String getNombre() {
        return nombre;
    }
    public List<Materia> getCorrelativas() {
        return correlativas;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean puedeCursar(Alumno alumno){
        return alumno.getMateriasAprobadas().containsAll(this.correlativas);
    }
}
