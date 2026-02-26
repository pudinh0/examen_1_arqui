/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 * 
 * @author adell
 */
public class Alumno {

    private int id, cantidadMaterias, numeroSemestre;
    private String nombre, carrera;
    public static ArrayList<Alumno> alumnos = new ArrayList<>();

    public Alumno(int id, int cantidadMaterias, int numeroSemestre, String nombre, String carrera) {
        this.id = id;
        this.cantidadMaterias = cantidadMaterias;
        this.numeroSemestre = numeroSemestre;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    static {
        Alumno adel = new Alumno(252770, 6, 6, "Adel", "ISW");
        Alumno norma = new Alumno(252102, 7, 6, "Norma", "ISW");
        Alumno denis = new Alumno(252450, 8, 6, "Denis", "ISW");
        Alumno peter = new Alumno(252627, 9, 6, "Peter", "ISW");
        Alumno mafer= new Alumno(247430, 10,8,"mafer","MVZ");
        
        alumnos.add(mafer);
        alumnos.add(adel);
        alumnos.add(norma);
        alumnos.add(denis);
        alumnos.add(peter);
    }
    
    public static void imprimirLista(){
        for (Alumno alumno: alumnos ) {
            System.out.println(alumno);
        }
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(int cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public int getNumeroSemestre() {
        return numeroSemestre;
    }

    public void setNumeroSemestre(int numeroSemestre) {
        this.numeroSemestre = numeroSemestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", cantidadMaterias=" + cantidadMaterias + ", numeroSemestre=" + numeroSemestre + ", nombre=" + nombre + ", carrera=" + carrera + '}';
    }

}
