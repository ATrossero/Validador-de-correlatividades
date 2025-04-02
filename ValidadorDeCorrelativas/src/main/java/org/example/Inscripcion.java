package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion
{
    private List<Materia> materiasSolicitadas;

    public Inscripcion(){
        this.materiasSolicitadas = new ArrayList<>();
    }
    public void agregarMaterias (Materia ... materias) {
        Collections.addAll(this.materiasSolicitadas, materias);
    }

    public List<Materia> getMaterias() {
        return materiasSolicitadas;
    }

    public Boolean aprobada(Alumno alumno) {
        return this.materiasSolicitadas.stream().allMatch( materia -> materia.puedeCursar(alumno));
    }
}
