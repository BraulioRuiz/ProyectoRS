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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author JulioXDDI
 */
public class Usuario {
   int id; 
   String nombre;
   String apellido_p;
   String apellido_m;
   String genero;
   int telefono;
   String correo;
   TipoUsuario tipoUsuario;
   Equipo equipo;
   int nivel;
   String ciudad;
   int status;

    public Usuario(int id, String nombre, String apellido_p, String apellido_m, String genero, int telefono, String correo, TipoUsuario tipoUsuario, Equipo equipo, int nivel, String ciudad, int status) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.genero = genero;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
        this.equipo = equipo;
        this.nivel = nivel;
        this.ciudad = ciudad;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
   
     public static void llenarInformacionEditorial(ConexionMysql cn, ObservableList<Usuario> lista){
            //ObservableList lista2 = FXCollections.observableArrayList();
        String sSQL = "select A.id, A.nombre,A.telefono,A.correo,A.nivel,B.Id,A.ciudad,A.status,B.Nombre "
                + "from usuarios A inner join tipousuarios B on (A.id_TipoUsuario = B.id)  where id_TipoUsuario=1 ";
            
        try {  
            Statement st = cn.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while(rs.next()){
               
                lista.add(new Usuario(rs.getInt("id"),rs.getString("nombre"),
                        null,null,null,rs.getInt("telefono"),
                        rs.getString("correo"),new TipoUsuario(rs.getInt("ID"),rs.getString("Nombre")),
                        new Equipo(0,null,null),
                        rs.getInt("nivel"),rs.getString("ciudad"),rs.getInt("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
    /*public static void llenarInformacionEditorial(ConexionMysql cn, ObservableList<Usuario> lista){
            //ObservableList lista2 = FXCollections.observableArrayList();
        String sSQL = "select A.id, A.nombre,A.telefono,A.correo,A.nivel,B.Id,A.ciudad,A.status,B.Nombre "
                + "from usuarios A inner join tipousuarios B on (A.id_TipoUsuario = B.id)  where id_TipoUsuario=1 ";
            
        try {  
            Statement st = cn.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while(rs.next()){
               
                lista.add(new Usuario(rs.getInt("id"),rs.getString("nombre"),
                        rs.getString("apellido_p"),rs.getString("apellido_m"),
                        rs.getString("genero"),rs.getInt("telefono"),
                        rs.getString("correo"),new TipoUsuario(rs.getInt("ID"),rs.getString("Nombre")),
                        new Equipo(0,null,null),
                        rs.getInt("nivel"),rs.getString("ciudad"),rs.getInt("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
