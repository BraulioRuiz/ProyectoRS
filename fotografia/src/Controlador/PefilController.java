/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.ConexionMysql;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author ayax9
 */
public class PefilController implements Initializable {

    @FXML private TextField txtNombre;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtGenero;
    @FXML private TextField txtApellidoP;
    @FXML private TextField txtApellidoM;
    @FXML private TextField txtCiudad;
    @FXML private TextField txtStatus;
    @FXML private TextField txtNivel;
    
    @FXML private Button btnGuardar;
    @FXML private Button btnEditar;
    
    private ConexionMysql conexion;    
    public static Usuario  usuario= LoginController.getInstance().getUsuario();
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
        llenarPerfil();
    }
     @FXML
    void editar(MouseEvent event) {
        habilitarCampos();
    }

    @FXML
    void guardar(MouseEvent event) {
        conexion = new ConexionMysql();        
       
        usuario.setNombre(txtCorreo.getText());
         usuario.setCorreo(txtCorreo.getText());
        usuario.setTelefono(Integer.valueOf(txtTelefono.getText()));
        usuario.setGenero(txtGenero.getText());
        usuario.setApellido_p(txtApellidoP.getText());
        usuario.setApellido_m(txtApellidoM.getText());
        usuario.setCiudad(txtCiudad.getText());
        usuario.setNivel(Integer.valueOf(txtNivel.getText()));
        
        conexion.establecerConexion();
        usuario.guardarInformacion(conexion);
        conexion.cerrarConexion();      
        
        deshabilitarCampos();
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
    public void habilitarCampos(){
        txtNombre.setEditable(true);
        txtCorreo.setEditable(true);
        txtTelefono.setEditable(true);
        txtGenero.setEditable(true);
        txtApellidoP.setEditable(true);
        txtApellidoM.setEditable(true);
        txtCiudad.setEditable(true);     
        txtNivel.setEditable(true);
        btnEditar.setVisible(false);
        btnGuardar.setVisible(true);  
        
    }
    public void deshabilitarCampos(){
        txtNombre.setEditable(false);
        txtCorreo.setEditable(false);
        txtTelefono.setEditable(false);
        txtGenero.setEditable(false);
        txtApellidoP.setEditable(false);
        txtApellidoM.setEditable(false);
        txtCiudad.setEditable(false);     
        txtNivel.setEditable(false);
        btnEditar.setVisible(true);
        btnGuardar.setVisible(false);  
        
    }
    
}
