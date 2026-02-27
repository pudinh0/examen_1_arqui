/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vista;

import modelo.IModeloVista;

/**
 * Interfaz que contiene el metodo update siendo implementado por FrameConstanciaPrincipal
 * @author adell
 */
public interface ISuscriptor {
    /**
     * metodo que actualizara la vista por medio de modeloVista
     * @param modeloVista instancia que tendra los getters para actualizar la vista
     */
    public void update(IModeloVista modeloVista);
}
