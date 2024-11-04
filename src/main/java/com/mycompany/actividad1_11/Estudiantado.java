package com.mycompany.actividad1_11;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Estudiantado {

    @XmlElement (name = "estudiante")
    private List<Estudiante> estudiantado;

    public Estudiantado() {
    }

    public Estudiantado(List<Estudiante> estudiantes) {
        this.estudiantado = estudiantes;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantado;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantado = estudiantes;
    }

    @Override
    public String toString() {
        return "Estudiantado{" +
                "estudiantes=" + estudiantado +
                '}';
    }
}
