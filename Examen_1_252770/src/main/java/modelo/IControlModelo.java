/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 * interface que contiene los metodos que seran implementados por ConstanciaModelo
 * @author adell
 */
public interface IControlModelo {
        /**
         * Metodo que muestra los alumnos que coincidan con la busqueda
         * @param busqueda matricula que recibira y hara la busqueda
         */
        public void mostrarAlumnosPorId(String busqueda);
        
        /**
         * Genera y asigna la constancia al alumno seleccionado
         */
        public void generarConstanciaAlumnoSeleccionado();
        
        /**
         * selecciona al alumno al que se le generara una constancia de estudio
         * @param id que hace referencia al alumno dentro de un arreglo
         */
        public void seleccionarAlumnoPorIndice(int id);
}
