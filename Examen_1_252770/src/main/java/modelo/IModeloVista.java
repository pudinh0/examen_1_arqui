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

    public List<Alumno> getAlumnosEncontrados();

    public Alumno getAlumnoSeleccionado();

    public String getConstanciaTexto();
}
