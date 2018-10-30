/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Conexion.ConexionMysql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

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
    
    public static void llenarInfo(ConexionMysql cn,ObservableList<Reportaje> lista){
        String sSQL ="use sistema_fotografia;\n" +
                        "SELECT r.id, r.titulo, r.descripcion, r.precio, r.numFotos, r.fecha, r.id_Tematica, r.id_usuario,\n" +
                        "t.id, t.nombre, \n" +
                        "u.id, u.nombre, u.apellido_p, u.apellido_m, u.genero, u.telefono, u.correo\n" +
                        "u.ciudad, u.nivel,u.status "+
                        "FROM reportajes r \n" +
                        "inner join tematicas t\n" +
                        "on r.id_tematica = t.id\n" +
                        "inner join usuarios u\n" +
                        "on r.id_usuario = u.id";
        try {  
            Statement st = cn.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while(rs.next()){
                Usuario a = new Usuario(rs.getInt("u.id"),rs.getString("u.nombre"),
                        rs.getString(" u.apellido_p"),rs.getString(" u.apellido_m"),
                        rs.getString("u.genero"),rs.getInt("u.telefono"),
                        rs.getString("u.correo"),new Carrera(rs.getInt("idCarrera"),
                                                             rs.getString("nombreCarrera")),
                        rs.getString("contraseña"),rs.getString("nick"));
                
                lista.add(new Proyecto(rs.getInt("idProyecto"),rs.getString("titulo"),
                        rs.getString("descripcion"),rs.getString("requisitos"),
                        rs.getInt("numIntegrantes"),rs.getString("estado"),a));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);    
        }
    } 
    
    
}
