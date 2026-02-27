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
 * Clase que funge como el modelo en MVC, contiene la logica para generar constancias, seleccionar alumno y filtrarlos
 * mediante la implmentacion de IControlModelo y IModeloVista
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
     * Metodo que retorna la instancia unica de la clase, si no existe la crea 
     * @return instancia unica de la clase
     */
    public static ConstanciaModelo getInstance() {
        if (instancia == null) {
            instancia = new ConstanciaModelo();
        }

        return instancia;
    }

    //metodos de IControlModelo
    /**
     *  Agrega a los alumnos que coincidan con el id buscado a una lista para mandarlos por medio del IModeloVista
     * @param busqueda atributo que funge como la matricula buscada
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
     * Selecciona el alumno que ha sido seleccionado
     * @param alumno  alumno seleccionado
     */
    private void seleccionarAlumno(Alumno alumno) {
        this.alumnoSeleccionado = alumno;
        this.constanciaTexto = "";
        notifyAllSuscribers();
    }
    
    /**
     * metodo que obtiene a los alumnos por medio de un arreglo.
     * @param index indice que se refiere al alumno dentro de un arreglo
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
     * Metodo que genera la constancia dandole un bloque de texto a un string
     * y llenandolos  con los datos del alumno seleccionado
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
    /**
     *  obtiene la lista de alumnos encontrados mediante la matricula ingresada
     * @return devuelve la lista de alumnos encontrados
     */
    @Override
    public List<Alumno> getAlumnosEncontrados() {
        return alumnosEncontrados;
    }
    
    /**
     * obtiene el alumno seleccionado
     * @return devuelve al alumno seleccionado
     */
    @Override
    public Alumno getAlumnoSeleccionado() {
        return alumnoSeleccionado;
    }
    /**
     * obtiene el texto de la constancia
     * @return  devuelve string con la constancia
     */
    @Override
    public String getConstanciaTexto() {
        return constanciaTexto;
    }

    //metodos del publisher
    /**
     * agrega un suscriptor a la lista de suscriptores
     * @param Suscriptor suscriptor que recibira las actualizaciones
     */
    public void addSuscriptor(ISuscriptor Suscriptor) {
        suscriptores.add(Suscriptor);
    }
    
    /**
     * Metodo que funciona para llamar el update de cada suscriptor en la lista de suscriptores
     */
    public void notifyAllSuscribers() {
        for (ISuscriptor suscriptor : suscriptores) {
            suscriptor.update(this);
        }
    }

}
