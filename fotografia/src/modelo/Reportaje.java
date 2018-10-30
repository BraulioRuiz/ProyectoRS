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
import java.sql.Date;
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
    private Usuario fotografo;
    
    
    public Reportaje(int id, String titulo, String descripcion,
            int precio, int numFotos, Date fecha, int id_Tematica,
            Usuario fotografo){
    this.id=id;
    this.titulo=titulo;
    this.descripcion=descripcion;
    this.precio=precio;
    this.numFotos=numFotos;
    this.fecha=fecha;
    this.id_Tematica=id_Tematica;
    this.fotografo=fotografo;
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
    public Usuario getIdUsuario(){
        return fotografo;
    }
    
    public static void llenarInformacion(ConexionMysql cn,ObservableList<Reportaje> lista){
        String sSQL ="SELECT r.id, r.titulo, r.descripcion, r.precio, r.numFotos, r.fecha, r.id_Tematica, r.id_usuario," +
                        "t.id, t.nombre, " +
                        "u.id, u.nombre, u.apellido_p, u.apellido_m, u.genero, u.telefono, u.correo, " +
                        "u.id_TipoUsuario, u.id_Equipo , u.nivel, u.ciudad,u.status "+
                        "FROM reportajes r " +
                        "inner join tematicas t " +
                        "on r.id_tematica = t.id " +
                        "inner join usuarios u " +
                        "on r.id_usuario = u.id";
        try {  
            Statement st = cn.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while(rs.next()){                
                Usuario a = new Usuario(rs.getInt("u.id"),rs.getString("u.nombre"),
                        rs.getString("u.apellido_p"),rs.getString("u.apellido_m"),
                        rs.getString("u.genero"),rs.getInt("u.telefono"),
                        rs.getString("u.correo"), new TipoUsuario(rs.getInt("u.id_TipoUsuario"),
                         "prueba"), new Equipo(rs.getInt("u.id_Equipo"),"nombre", "calidad"),
                         rs.getInt("u.nivel"),rs.getString("u.ciudad"), rs.getInt("u.status"));
                
                lista.add(new Reportaje(rs.getInt("r.id"),rs.getString("r.titulo"),
                        rs.getString("r.descripcion"),rs.getInt("r.precio"),
                        rs.getInt("r.numFotos"),rs.getDate("r.fecha"), rs.getInt("r.id_Tematica"),
                        a));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);    
        }
    } 
    
    
}
