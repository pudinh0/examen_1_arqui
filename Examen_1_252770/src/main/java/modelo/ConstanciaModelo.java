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
 * 
 */
public class ConstanciaModelo implements IControlModelo, IModeloVista {

    public static ConstanciaModelo instancia;
    private final List<ISuscriptor> suscriptores;

    private final List<Alumno> alumnosEncontrados = new ArrayList<>();
    private Alumno alumnoSeleccionado;
    private String constanciaTexto = "";

    public ConstanciaModelo() {
        this.suscriptores = new LinkedList<>();

    }
    /**
     * 
     * @return 
     */
    public static ConstanciaModelo getInstance() {
        if (instancia == null) {
            instancia = new ConstanciaModelo();
        }

        return instancia;
    }

    //metodos de IControlModelo
    /**
     * 
     * @param busqueda 
     */
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
    
    /**
     * 
     * @param alumno 
     */
    private void seleccionarAlumno(Alumno alumno) {
        this.alumnoSeleccionado = alumno;
        this.constanciaTexto = "";
        notifyAllSuscribers();
    }
    
    /**
     * 
     * @param index 
     */
    @Override
    public void seleccionarAlumnoPorIndice(int index) {

        List<Alumno> listaActual = getAlumnosEncontrados();

        if (index >= 0 && index < listaActual.size()) {
            Alumno a = listaActual.get(index);

            seleccionarAlumno(a);
        }
    }
    
    /**
     * 
     */
    @Override
    public void generarConstanciaAlumnoSeleccionado() {
        if (alumnoSeleccionado != null) {
            String separador = "------------------------------------------------------------------------------------------\n";

            this.constanciaTexto = "\n"
                    + "\t            SISTEMA DE CONTROL ESCOLAR\n"
                    + "\t         CONSTANCIA OFICIAL DE ESTUDIOS\n"
                    + separador
                    + "\n"
                    + "  A QUIEN CORRESPONDA:\n\n"
                    + "  Por medio de la presente, se hace constar que el estudiante:\n\n"
                    + "  NOMBRE:  " + alumnoSeleccionado.getNombre().toUpperCase() + "\n"
                    + "  ID:      " + alumnoSeleccionado.getId() + "\n"
                    + "  CARRERA: " + alumnoSeleccionado.getCarrera() + "\n\n"
                    + "  Se encuentra actualmente inscrito de manera regular,\n"
                    + "  cursando un total de (" + alumnoSeleccionado.getCantidadMaterias() + ") materias\n"
                    + "  correspondientes al semestre numero " + alumnoSeleccionado.getNumeroSemestre() + ".\n\n"
                    + "  Se extiende la presente para los fines legales que al interesado\n"
                    + "  convengan, con fecha de hoy: " + new java.util.Date().toString() + "\n\n"
                    + "\n"
                    + "\t                     Popusitas\n"
                    + "\t                ____________________\n"
                    + "\t                 FIRMA DIGITAL\n"
                    + "\n"
                    + separador;

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
