/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.ConexionMysql;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;
import modelo.Equipo;
import modelo.TipoUsuario;
import modelo.Usuario;
import modelo.Login;

/**
 * FXML Controller class
 *
 * @author JulioXDDI
 */
public class RegistroEditorialController implements Initializable {

   @FXML
    private AnchorPane Registro;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCiudad;

    @FXML
    private PasswordField pass1;
    
    @FXML
    private PasswordField pass2;

    
    ConexionMysql conexion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexion = new ConexionMysql();
        
    }    

    @FXML
    private void registrarInfo(ActionEvent event) {
        
        if(txtNombre.getText().equals("") || txtCorreo.getText().equals("") || 
                txtTelefono.getText().equals("") || txtCiudad.getText().equals("") ){
          //  alert("campos");
        }else{
            try{
                
                conexion.establecerConexion();
                if(Usuario.acceder(conexion, txtCorreo.getText()) == null){
                    if(Usuario.acceder(conexion, txtCorreo.getText()) == null ){
                        if(pass1.getText().equals(pass2.getText())){
                     //       if(ckbTerminos.isSelected() == true){
                            Usuario a = new Usuario(0,txtNombre.getText(),
                            "","","",Integer.valueOf(txtTelefono.getText()),
                            txtCorreo.getText(),new TipoUsuario(1,"Editorial"),
                            new Equipo(1,"",""),
                            0,txtCiudad.getText(),1, pass1.getText());
                            
                        //  System.out.println(a.getNombre());
                            
                               int r = a.guardarInformacion(conexion);
                               Usuario b = Usuario.BuscarUsuario(conexion, txtCorreo.getText());
                              
                            
                               /*Login c = new Login(0,pass1.getText(),"",b.getId());
                               c.guardarInfo(conexion);*/
                                conexion.cerrarConexion();
                                
                                
                                if(r==1){
                                    Parent menu_parent;
                                    menu_parent = FXMLLoader.load(getClass().getResource
                                        ("/Vista/Login.fxml"));  
                                    Scene menu_scene = new Scene(menu_parent);
                                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    app_stage.hide();
                                    app_stage.setScene(menu_scene);
                                    app_stage.show();
                                }
                          /*  }else{
                                alert("terminos");
                            }*/

                        }else{
                    //        alert("contraseña");
                        System.out.println("contraseña");
                        }
                    }else{
                 //       alert("usuario");
                 System.out.println("usuario");
                    }
                }else{
              //      
              System.out.println("email");
                }
            }catch(Exception e){
     //           alert("campos");
     System.out.println(e);
            }
        }    
    }
    
    
}
