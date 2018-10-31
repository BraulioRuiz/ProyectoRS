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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author JulioXDDI
 */
public class PanelEditorialController implements Initializable {
@FXML
    private AnchorPane apBaseEditorial;

    @FXML
    private Label lbTitulo;

    @FXML
    private Label lbTelefono;

    @FXML
    private Label lbCorreo;

    @FXML
    private Label lbCiudad;

    @FXML
    private Label lbEliminar;
    
    private ConexionMysql conexion;

   
     private static PanelEditorialController instance;
    
    
    public PanelEditorialController(){
        instance=this;
    }
    
    public static PanelEditorialController getInstance(){
        return instance;
    }
    
    private Usuario editorialUser;

    public static Usuario editorial;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       lbTitulo.setText(editorial.getNombre());
       lbTelefono.setText(String.valueOf(editorial.getTelefono()));
       lbCorreo.setText(editorial.getCorreo());
       lbCiudad.setText(editorial.getCiudad());
       conexion = new ConexionMysql();
       editorialUser = new Usuario();
       editorialUser = editorial;
    }    
    
    
    @FXML
    public void eliminarSuscripcion(MouseEvent event) {
        BaseController.getInstance().Alert("Se ha Quitado Suscripción Correctamete", true);
        conexion.establecerConexion();
        Usuario.eliminarUsuario(conexion, editorialUser.getId());
        conexion.cerrarConexion();
        PanelSuscripcionesController.getInstance().eliminarEditorial(apBaseEditorial);
    }

    
}
