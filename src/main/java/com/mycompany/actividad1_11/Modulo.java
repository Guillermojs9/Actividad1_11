package com.mycompany.actividad1_11;

import jakarta.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

public class Modulo {
private String id;
private String denominacion;
private int horas;

    public Modulo() {
    }

    public Modulo(String id, String denominacion, int horas) {
        this.id = id;
        this.denominacion = denominacion;
        this.horas = horas;
    }

    @XmlAttribute (name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @XmlElement
    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id='" + id + '\'' +
                ", denominacion='" + denominacion + '\'' +
                ", horas=" + horas +
                '}';
    }
}
