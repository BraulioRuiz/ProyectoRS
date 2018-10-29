/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Pando
 */
public class usuario {
    
    private String Nombre;
    private String Apellido_p;
    private String Apellido_m;
    private String Genero;
    private int Telefono;
    private String Correo;
    private String Password;
    
    
    public usuario(String Nombre,String Apellido_p,String Apellido_m,String Genero,int Telefono, String Correo){
        this.Nombre = Nombre;
        this.Apellido_p = Apellido_p;
        this.Apellido_m = Apellido_m;
        this.Genero=Genero;
        this.Telefono= Telefono;
        this.Correo=Correo;
    }
   
    public String getNombre() {
        return Nombre;
    }

 
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


    public String getApellido_p() {
        return Apellido_p;
    }

    public void setApellido_p(String Apellido_p) {
        this.Apellido_p = Apellido_p;
    }

     public String getApellido_m() {
        return Apellido_m;
    }

    public void setApellido_m(String Apellido_m) {
        this.Apellido_m = Apellido_m;
    }
    
    public String getCorreo(){
        return Correo;
    }
    
    public void setCorreo(String Correo){
        this.Correo=Correo;
    }
    
    
    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }


    public int getTelefono() {
        return Telefono;
    }


    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    
    public String getPassword() {
        return Password;
    }
    
   
    
    
}
   