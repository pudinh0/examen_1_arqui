/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import dominio.Alumno;
import java.util.List;

/**
 *
 * @author adell
 */
public interface IModeloVista {
    
    /**
     * Metodo que devuelve la lista de alumnos encontrados
     * @return  lista de alumnos encontrados
     */
    public List<Alumno> getAlumnosEncontrados();
    /**
     * Metodo que devuelve al alumno seleccionado
     * @return Alumno seleccionado
     */
    public Alumno getAlumnoSeleccionado();
    
    /**
     * Metodo que obtiene la constancia del alumno seleccionado
     * @return Constancia generada
     */
    public String getConstanciaTexto();
}
