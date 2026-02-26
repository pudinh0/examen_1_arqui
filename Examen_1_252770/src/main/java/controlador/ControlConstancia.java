/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.ConstanciaModelo;
import modelo.IControlModelo;

/**
 *
 * @author adell
 */
public class ControlConstancia {

    private final IControlModelo control = ConstanciaModelo.getInstance();

    public void generarConstancia() {
        control.generarConstanciaAlumnoSeleccionado();
    }

    public void filtrar(String id) {
        control.mostrarAlumnosPorId(id);
    }

    public void seleccionarAlumnoPorIndice(int id) {
        control.seleccionarAlumnoPorIndice(id);

    }

}
