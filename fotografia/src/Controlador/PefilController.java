/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.ConexionMysql;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author ayax9
 */
public class PefilController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtGenero;
    @FXML
    private TextField txtApellidoP;
    @FXML
    private TextField txtApellidoM;
    @FXML
    private TextField txtCiudad;
    @FXML
    private TextField txtStatus;
    @FXML
    private TextField txtNivel;
    
    private ConexionMysql conexion;    
    public static Usuario  usuario= LoginController.usuario;
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
        llenarPerfil();
    }    
    
    public void llenarPerfil(){
        txtNombre.setText(usuario.getNombre());
        txtCorreo.setText(usuario.getCorreo());
        txtTelefono.setText(String.valueOf(usuario.getTelefono()));
        txtGenero.setText(usuario.getGenero());
        txtApellidoP.setText(usuario.getApellido_p());
        txtApellidoM.setText(usuario.getApellido_m());
        txtCiudad.setText(usuario.getCiudad());     
        txtNivel.setText(String.valueOf(usuario.getNivel()));
    }
    
}
