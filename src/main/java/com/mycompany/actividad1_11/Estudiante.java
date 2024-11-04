package com.mycompany.actividad1_11;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;

public class Estudiante {

    private int idMatricula;
    private String nombre;
    private String telefono;
    private String email;
    private Direccion direccion;
    private ArrayList<Modulo> matricula;

    public Estudiante() {
    }
    
    public Estudiante(int idMatricula, String nombre, Direccion direccion, String telefono, String email, ArrayList<Modulo> matricula) {
        this.idMatricula = idMatricula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.matricula = matricula;
    }


    @XmlAttribute
    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @XmlElementWrapper(name = "matricula")
    @XmlElement(name = "modulo")
    public ArrayList<Modulo> getMatricula() {
        return matricula;
    }

    public void setMatricula(ArrayList<Modulo> matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "idMatricula=" + idMatricula + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", direccion=" + direccion + ", matricula=" + matricula + '}';
    }

}
