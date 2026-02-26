/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examen_1_252770;


import java.util.ArrayList;
import modelo.Alumno;

/**
 *
 * @author adell
 */
public class Examen_1_252770 {

    public static void main(String[] args) {
        Alumno adel = new Alumno(252770, 6, 6, "Adel", "ISW");
        Alumno norma = new Alumno(252102, 7, 6, "Norma", "ISW");
        Alumno denis = new Alumno(252450, 8, 6, "Denis", "ISW");
        Alumno peter = new Alumno(252627, 9, 6, "Peter", "ISW");
        
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(adel);
        alumnos.add(norma);
        alumnos.add(denis);
        alumnos.add(peter);
       
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(alumnos.get(i));
        }
        
       
        
    }
}
