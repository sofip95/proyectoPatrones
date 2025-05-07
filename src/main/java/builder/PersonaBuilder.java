/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package builder;

import model.Persona;

/**
 *
 * @author Victus
 */
public class PersonaBuilder {
<<<<<<< HEAD

=======
>>>>>>> b6b076b6c84292c5028572244ef20bf21fcef837
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String rol;
    private String password;
<<<<<<< HEAD

    public void reset() {
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.correo = "";
        this.rol = "";
        this.password = "";
    }

    private PersonaBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    private PersonaBuilder setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    private PersonaBuilder setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    private PersonaBuilder setCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    private PersonaBuilder setRol(String rol) {
        this.rol = rol;
        return this;
    }

    private PersonaBuilder setPassword(String password) {
        this.password = password;
        return this;
    }
    
    public Persona getPersona(){
        Persona persona = new Persona(id,nombre,apellido,edad,correo,rol,password);
        reset();        
        return persona;
    }

=======
    
    public void reset(){
    this.id = 0;
    this.nombre = "";
    this.apellido = "";
    this.edad = 0;
    this.correo = "";
    this.rol = "";
    this.password = "";
    }
    
    public PersonaBuilder setNombre(String nombre){
    this.nombre = nombre;
    return this;
    }
    public PersonaBuilder setApellido(String apellido){
    this.apellido = apellido;
    return this;
    }
    public PersonaBuilder setEdad(int edad){
    this.edad = edad;
    return this;
    }
    public PersonaBuilder setCorreo(String correo){
    this.correo = correo;
    return this;
    }
    public PersonaBuilder setRol(String rol){
    this.rol = rol;
    return this;
    }
    public PersonaBuilder setPassword(String password){
    this.password = password;
    return this;
    }
    public Persona getPersona(){
        Persona persona = new Persona(id,nombre,apellido,edad,correo,rol,password);
        reset(); 
        return persona;
    }
>>>>>>> b6b076b6c84292c5028572244ef20bf21fcef837
}
