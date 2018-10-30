/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.ConexionMysql;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author JulioXDDI
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField pwfContraseña;
    
    private ConexionMysql conexion;
    
    public static Usuario usuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexion = new ConexionMysql();
        usuario = null;
    }    

    @FXML
    private void btnLogin(MouseEvent event) {
    }

    @FXML
    private void ingresarMenu(ActionEvent event) {
        ingresarUsuario(event);
    }

    @FXML
    private void Ireditorial(MouseEvent event) {
    }

    @FXML
    private void entrarRegistro(ActionEvent event) {
         try {
            Parent menu_parent = FXMLLoader.load(getClass().getResource("/Vista/RegistroEditorial.fxml"));
            Scene menu_scene = new Scene(menu_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(menu_scene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ingresarUsuario(Event event){
        try{
            String contraseña=null;
            if(!txtUsuario.getText().equals("")){
                conexion.establecerConexion();
                contraseña = Usuario.acceder(conexion,txtUsuario.getText());
                conexion.cerrarConexion();
                if (!pwfContraseña.getText().equals("")){
                    if(contraseña != null){
                        if(contraseña.equals(pwfContraseña.getText())){
                            
                            Parent menu_parent = FXMLLoader.load(getClass().getResource
                            ("/Vista/Base.fxml"));
                            
                            Scene menu_scene = new Scene(menu_parent);
                            
                            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            
                            app_stage.hide();
                            
                            app_stage.setScene(menu_scene);
                             
                            app_stage.show();
                           
                            conexion.establecerConexion();
                            usuario = Usuario.BuscarUsuario(conexion, txtUsuario.getText());
                            conexion.cerrarConexion();
                           
                        }else{
                     
                       //     lblError.setVisible(true);
                            pwfContraseña.setText("");
                        }
                    }else{
                  
                     //   lblError.setVisible(true);
                        pwfContraseña.setText("");
                    }
                }else{
              //      lblErrorPass.setText("No ha ingresado contraseña");
                //    lblErrorPass.setVisible(true);
                }
            }else{
           //     lblErrorUsuario.setText("No ha ingresado usuario");
             //   lblErrorUsuario.setVisible(true);
            }
            
        }catch(Exception e){
          //  lblError.setVisible(true);
        }
    }
    
}
