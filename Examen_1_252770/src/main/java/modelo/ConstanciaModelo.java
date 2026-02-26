/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dominio.Alumno;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import vista.ISuscriptor;

/**
 *
 * @author adell
 */
public class ConstanciaModelo implements IControlModelo, IModeloVista {

    public static ConstanciaModelo instancia;
    private final List<ISuscriptor> suscriptores;

    private final List<Alumno> alumnosEncontrados = new ArrayList<>();
    public Alumno alumnoSeleccionado;
    private String constanciaTexto = "";

    public ConstanciaModelo() {
        this.suscriptores = new LinkedList<>();

    }

    public static ConstanciaModelo getInstance() {
        if (instancia == null) {
            instancia = new ConstanciaModelo();
        }

        return instancia;
    }

    //metodos de IControlModelo
    @Override
    public void mostrarAlumnosPorId(String busqueda) {
        alumnosEncontrados.clear();
        for (Alumno alumno : Alumno.alumnos) {
            if (String.valueOf(alumno.getId()).startsWith(busqueda)) {
                alumnosEncontrados.add(alumno);    
            }
        }
        notifyAllSuscribers();
    }

    public void seleccionarAlumno(Alumno alumno) {
        this.alumnoSeleccionado = alumno;
        this.constanciaTexto = "";
        notifyAllSuscribers();
    }

    @Override
    public void seleccionarAlumnoPorIndice(int index) {

        List<Alumno> listaActual = getAlumnosEncontrados();

        if (index >= 0 && index < listaActual.size()) {
            Alumno a = listaActual.get(index);

            seleccionarAlumno(a);
        }
    }

    @Override
    public void generarConstanciaAlumnoSeleccionado() {
        if (alumnoSeleccionado != null) {
            this.constanciaTexto = "CONSTANCIA DE ESTUDIOS\n"
                    + "El alumno " + alumnoSeleccionado.getNombre()
                    + " con ID " + alumnoSeleccionado.getId()
                    + " esta inscrito en " + alumnoSeleccionado.getCarrera()
                    + " cursando " + alumnoSeleccionado.getCantidadMaterias() + " materias.";
            notifyAllSuscribers();
        } else {
            System.out.println(" Error: no hay ningun alumno seleccionado actualmente");
        }

    }

    // metodos de IModeloVista
    @Override
    public List<Alumno> getAlumnosEncontrados() {
        return alumnosEncontrados;
    }

    @Override
    public Alumno getAlumnoSeleccionado() {
        return alumnoSeleccionado;
    }

    @Override
    public String getConstanciaTexto() {
        return constanciaTexto;
    }

    //metodos del publisher
    public void addSuscriptor(ISuscriptor Suscriptor) {
        suscriptores.add(Suscriptor);
    }

    public void notifyAllSuscribers() {
        for (ISuscriptor suscriptor : suscriptores) {
            suscriptor.update(this);
        }
    }

}
