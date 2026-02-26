/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.LinkedList;
import java.util.List;
import vista.ISuscriptor;

/**
 *
 * @author adell
 */
public class ConstanciaModelo implements IControlModelo, IModeloVista{
    public static ConstanciaModelo instancia;
    private List<ISuscriptor> suscriptores;
    public Alumno alumnoActual;
    
    
    public ConstanciaModelo() {
        this.suscriptores = new LinkedList<>();
       
    }

    @Override
    public void mostrarAlumnoPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void generarConstanciaAlumnoSeleccionado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
   
    
    
    
}
