/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examen_1_252770;

import modelo.ConstanciaModelo;
import vista.FrameConstanciaPrincipal;
import vista.ISuscriptor;

/**
 *
 * @author adell
 */
public class Examen_1_252770 {

    public static void main(String[] args) {

        FrameConstanciaPrincipal.getInstancia().setVisible(true);
        ISuscriptor suscriptor = FrameConstanciaPrincipal.getInstancia();
        ConstanciaModelo.getInstance().addSuscriptor(suscriptor);

    }
}
