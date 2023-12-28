package com.example.cashgree;

public class UserModel {
    String nombre, email, documento, contrasena, celular;

    public UserModel(String nombre, String email, String documento, String contrasena, String celular) {
        this.nombre = nombre;
        this.email = email;
        this.documento = documento;
        this.contrasena = contrasena;
        this.celular = celular;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}