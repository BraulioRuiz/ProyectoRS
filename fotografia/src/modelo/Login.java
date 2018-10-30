/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Conexion.ConexionMysql;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JulioXDDI
 */
public class Login {
    int id;
    String contraseña;
    String nickname;
    int id_Usuario;

    public Login(int id, String contraseña, String nickname, int id_Usuario) {
        this.id = id;
        this.contraseña = contraseña;
        this.nickname = nickname;
        this.id_Usuario = id_Usuario;
    }

    public Login() {
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }
    
    public int guardarInfo(ConexionMysql cn){
        String sSQL = "INSERT INTO login(contraseña,nickname,id_Usuario) VALUES (?,?,?)";
            
        try {  
            PreparedStatement pst = cn.getConexion().prepareStatement(sSQL);
            pst.setString(1,contraseña);
            pst.setString(2,nickname);
            pst.setInt(3,id_Usuario);
            
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }  
    
}
