/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import objetos.usuario;

/**
 *
 * @author Pando
 */
public class Login {
   private static final String servidor="jdbc:mysql://localhost/sistema_fotografia";
    private static final String user="root";
    private static final String pass="";
    private Connection conexion;
    protected String sql;
    
    public void hacerConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection(servidor, user, pass);
		}catch(ClassNotFoundException | SQLException e) {   
                    e.printStackTrace();
		}
	}
	
        /**
         * Este es el metodo getter del parametro conexion
         * @return 
         */
	private Connection getConnection() {
		return conexion;
	}
	
        /**
         * Este es el metodo donde hace consultas a la base de datos que retrona un parametro del tipo boolean
         * @return  true/false
         */
	private boolean sql() {
		hacerConexion();
		Connection con = getConnection();
		PreparedStatement st;
		try {
			st= con.prepareStatement(sql);
                        st.executeUpdate(sql);
			con.close();
			st.close();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
        
          public boolean registrarEditorial(String nombre,String apellido_p, String apellido_m,String genero,String telefono,String correo,String id_TipoUsuario,String Ciudad){
            sql="Insert into usuario (nombre,apellido_p,apellido_m,genero,telefono,correo,id_TipoUsuario,ciudad) values ('"+nombre+"','"+apellido_p+"','"+apellido_m+"','"+genero+"','"+telefono+"','"+correo+"','"+id_TipoUsuario+"')";
            boolean q= sql();
            return q;
        }
    
}
