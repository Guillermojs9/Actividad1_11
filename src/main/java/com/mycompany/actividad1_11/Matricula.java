package com.mycompany.actividad1_11;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Matricula {

    private ArrayList<Modulo> modulos;

    public Matricula() {
        modulos = new ArrayList<>();
    }

    @XmlElement(name = "modulo")
    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(ArrayList<Modulo> modulos) {
        this.modulos = modulos;
    }

    @Override
    public String toString() {
        return "Matricula{" + "modulos=" + modulos + '}';
    }

}
