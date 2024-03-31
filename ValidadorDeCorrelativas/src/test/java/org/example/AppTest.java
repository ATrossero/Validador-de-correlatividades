package org.example;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        Materia algoritmos = new Materia();
        algoritmos.setNombre("Algoritmos");
        Alumno tino = new Alumno();
        Assert.assertTrue("Tino puede cursar algoritmos", algoritmos.puedeCursar(tino));
    }
    public void testApp2()
    {
        Materia algoritmos = new Materia();
        //algoritmos.setNombre("Algoritmos");
        Materia pdep = new Materia();
        pdep.agregarCorrelativas(algoritmos);
        Alumno tino = new Alumno();
        Assert.assertFalse("Tino no puede cursar pdep por no tener la correlativa", pdep.puedeCursar(tino));
    }
    public void testApp3()
    {
        Materia algoritmos = new Materia();
        Materia pdep = new Materia();
        pdep.agregarCorrelativas(algoritmos);
        Alumno tino = new Alumno();
        tino.agregarMateriasAprobadas(algoritmos);
        Assert.assertTrue("Tino puede cursar pdep por tener la correlativa", pdep.puedeCursar(tino));
    }
    public void testApp4()
    {
        Materia algoritmos = new Materia();
        Materia arquitectura = new Materia();
        Materia pdep = new Materia();
        pdep.agregarCorrelativas(algoritmos, arquitectura);
        Alumno tino = new Alumno();
        tino.agregarMateriasAprobadas(algoritmos);
        Assert.assertFalse("Tino no puede cursar pdep por no tener todas las correlativas", pdep.puedeCursar(tino));
    }
    public void testApp5()
    {
        Materia algoritmos = new Materia();
        Materia arquitectura = new Materia();
        Materia pdep = new Materia();
        pdep.agregarCorrelativas(algoritmos, arquitectura);
        Alumno tino = new Alumno();
        tino.agregarMateriasAprobadas(algoritmos, arquitectura);
        Assert.assertTrue("Tino puede cursar pdep por tener todas las correlativas", pdep.puedeCursar(tino));
    }
    public void testApp6()
    {
        Materia algoritmos = new Materia();
        Materia arquitectura = new Materia();
        Materia pdep = new Materia();
        Materia quimica = new Materia();
        pdep.agregarCorrelativas(algoritmos, arquitectura);
        Alumno tino = new Alumno();
        tino.agregarMateriasAprobadas(algoritmos);
        Inscripcion QuimPdeP = new Inscripcion();
        QuimPdeP.agregarMaterias(pdep, quimica);
        Assert.assertFalse("A Tino no le aceptan la inscripcion porque no puede cursar pdep por no tener todas las correlativas", QuimPdeP.aprobada(tino));
    }
    public void testApp7()
    {
        Materia algoritmos = new Materia();
        Materia arquitectura = new Materia();
        Materia pdep = new Materia();
        Materia quimica = new Materia();
        pdep.agregarCorrelativas(algoritmos, arquitectura);
        Alumno tino = new Alumno();
        tino.agregarMateriasAprobadas(algoritmos, arquitectura); // Ahora puede cursar PdeP
        Inscripcion QuimPdeP = new Inscripcion();
        QuimPdeP.agregarMaterias(pdep, quimica);
        Assert.assertTrue("A Tino le aceptan la inscripcion porque puede cursar todas las materias", QuimPdeP.aprobada(tino));
    }
    public void testApp8()
    {
        Materia algoritmos = new Materia();
        Materia arquitectura = new Materia();
        Materia pdep = new Materia();
        Materia quimica = new Materia();
        Materia disenio = new Materia();
        pdep.agregarCorrelativas(algoritmos, arquitectura);
        disenio.agregarCorrelativas(pdep);
        Alumno tino = new Alumno();
        tino.agregarMateriasAprobadas(pdep); // Ahora puede cursar Disenio
        Inscripcion QuimDisenio = new Inscripcion();
        QuimDisenio.agregarMaterias(disenio, quimica);
        Assert.assertTrue("A Tino le aceptan la inscripcion porque puede cursar todas las materias", QuimDisenio.aprobada(tino));
    }
}
