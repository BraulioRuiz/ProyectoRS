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
import javafx.animation.FadeTransition;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
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
     @FXML
    private StackPane stkBase;

    @FXML
    private AnchorPane apBase;
    
    private AnchorPane home;
    
    private ConexionMysql conexion;
    
    public static Usuario usuario;
    
    private static LoginController instance;
    
    public LoginController(){
        instance=this;
    }
    public static LoginController getInstance(){
        return instance;
    }
    

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
                             LoginController.getInstance().Alert("Contraseña Incorrecta", false);
                       //     lblError.setVisible(true);
                            pwfContraseña.setText("");
                        }
                    }else{
                       // LoginController.getInstance().Alert("Por Favor Escribir Una Contrasña", false);
                     //   lblError.setVisible(true);
                        pwfContraseña.setText("");
                    }
                }else{
                    LoginController.getInstance().Alert("No ha ingresado contraseña", false);
              //      lblErrorPass.setText("No ha ingresado contraseña");
                //    lblErrorPass.setVisible(true);
                }
            }else{
                LoginController.getInstance().Alert("No ha ingresado usuario", false);
           //     lblErrorUsuario.setText("No ha ingresado usuario");
             //   lblErrorUsuario.setVisible(true);
            }
            
        }catch(Exception e){
          //  lblError.setVisible(true);
        }
    }
    
    private  void setNode2(Node node){
        
        stkBase.getChildren().add((Node)node);
        
        FadeTransition ft = new FadeTransition(Duration.millis(500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
    }
      public void Alert(String mensaje,boolean estado){ 
        try {
            AlertController.estado = estado;
            AlertController.mensaje = mensaje;
            AlertController.vista = "login";
            apBase.setDisable(true);
            home = FXMLLoader.load(getClass().getResource("/Vista/Alert.fxml"));
            AlertController.miPane = home;
            setNode2(home);
        } catch (IOException ex) {
            Logger.getLogger(MenuAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }
     
     public void eliminarAlert(AnchorPane pane){
        stkBase.getChildren().remove(pane);
        apBase.setDisable(false);
    }
    
}
