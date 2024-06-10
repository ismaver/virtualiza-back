package com.web.modelo;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Calificacion implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
	private int codigo;
    private String nombre;
    private String apellido;
    private double nota;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

	@Override
	public String toString() {
		return "Calificacion [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", nota=" + nota + "]";
	}
}
