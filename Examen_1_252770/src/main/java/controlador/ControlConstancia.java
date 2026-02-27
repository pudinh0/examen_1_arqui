/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.ConstanciaModelo;
import modelo.IControlModelo;

/**
 * clase que funge como el control en el modelo MVC, llamando a los metodos de IControlModelo
 * @author adell
 */
public class ControlConstancia {

    private final IControlModelo control = ConstanciaModelo.getInstance();
    
    /**
     * Metodo que envia la solicitud para generar la constancia
     */
    public void generarConstancia() {
        control.generarConstanciaAlumnoSeleccionado();
    }
    
    /**
     * Metodo que solicita filtrar por el id recibido
     * @param id contiene la id buscado
     */
    public void filtrar(String id) {
        control.mostrarAlumnosPorId(id);
    }
    
    /**
     * Metodo que hace la solicitud para seleccionar al alumno
     * @param id posicion del alumno en un arreglo
     */
    public void seleccionarAlumnoPorIndice(int id) {
        control.seleccionarAlumnoPorIndice(id);

    }

}
