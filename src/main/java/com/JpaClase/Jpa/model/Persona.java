package com.JpaClase.Jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id_persona;
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(Long id_persona, String nombre, String apellido, int edad) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona() {
    }

    public long getId_persona() {
        return id_persona;
    }

    public void setId_persona(long id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}


