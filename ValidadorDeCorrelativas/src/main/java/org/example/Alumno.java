package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
    private List<Materia> materiasAprobadas;
    private String nombre;
    public Alumno() {
        this.materiasAprobadas = new ArrayList<>();
    }
    public void agregarMateriasAprobadas (Materia ... aprobadas) {
        Collections.addAll(this.materiasAprobadas, aprobadas);
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }
    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }
    public void agregarAprobadas (Materia ... aprobadas) {
        Collections.addAll(this.materiasAprobadas, aprobadas);
    }
    public Boolean aprobada(Materia materia) {
        return this.materiasAprobadas.contains(materia);
    }
}
