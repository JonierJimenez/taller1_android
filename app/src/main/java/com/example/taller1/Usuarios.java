package com.example.taller1;

import java.util.Objects;

public class Usuarios {
    public String usuario;
    public String apellido;
    public String correo;
    public String password;
    public String sexo;


    public Usuarios(String nombre, String password){
        this.usuario=nombre;
        this.password=password;
    }

    public Usuarios(String usuario, String apellido,String correo,String password) {
        this.usuario = usuario;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
    }

    public Usuarios(String usuario, String apellido, String correo, String password, String sexo) {

        this.usuario = usuario;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuario1 = (Usuarios) o;
        return Objects.equals(usuario, usuario1.usuario) &&
                Objects.equals(password, usuario1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, password);
    }
}
