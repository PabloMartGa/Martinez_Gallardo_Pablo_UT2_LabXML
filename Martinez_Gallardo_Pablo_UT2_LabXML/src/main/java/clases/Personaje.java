/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author DAM2P
 */
@XmlRootElement(name = "personaje")
public class Personaje {
    
    private String nombre;
    private String rango;

    public Personaje() {
    }

    public Personaje(String nombre, String rango) {
        this.nombre = nombre;
        this.rango = rango;
    }

    /**
     * @return the nombre
     */
    @XmlElement
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the rango
     */
    @XmlElement
    public String getRango() {
        return rango;
    }

    /**
     * @param rango the rango to set
     */
    public void setRango(String rango) {
        this.rango = rango;
    }
    
    
}
