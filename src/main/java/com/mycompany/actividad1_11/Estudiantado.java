package com.mycompany.actividad1_11;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "estudiantado")
public class Estudiantado {

    private ArrayList<Estudiante> estudiantes;

    public Estudiantado() {
        estudiantes = new ArrayList<>();
    }

    @XmlElement(name = "estudiante")
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Estudiantado{" + "estudiantes=" + estudiantes + '}';
    }

}
