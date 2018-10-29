/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author ayax9
 */
public class Reportaje {
    private int id;
    private String titulo;
    private String descripcion;
    private int precio;
    private int numFotos;
    private Date fecha;
    private int id_Tematica;
    private int id_usaurio;
    
    public Reportaje(int id, String titulo, String descripcion,
            int precio, int numFotos, Date fecha, int id_Tematica,
            int id_usaurio){
    this.id=id;
    this.titulo=titulo;
    this.descripcion=descripcion;
    this.precio=precio;
    this.numFotos=numFotos;
    this.fecha=fecha;
    this.id_Tematica=id_Tematica;
    this.id_usaurio=id_usaurio;
    }
    public Reportaje(){
    }
    public int getId(){
     return id;
    }
    public String getTitulo(){
     return titulo;
    }
    public String getDescripcion(){
     return descripcion;
    }
    public int getPrecio(){
     return precio;
    }
    public int getnumFotos(){
     return numFotos;
    }
    public Date getFecha(){
     return fecha;
    }
    public int getIdTematica(){
     return id_Tematica;
    }
    public int getIdUsuario(){
        return id_usaurio;
    }
    
    
}
