/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author JulioXDDI
 */
public class RegistroFotografoController implements Initializable {

    @FXML
    private AnchorPane editorial2;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido_p;
    @FXML
    private TextField txtApellido_m;
    @FXML
    private TextField txtGelefono;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtCiudad;
    @FXML
    private TextField txtContraseña;
    @FXML
    private TextField txtGenero;
    @FXML
    private ComboBox<?> cboEquipo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Iredit(MouseEvent event) {
    }

    @FXML
    private void RegistrarInfo(ActionEvent event) {
    }
    
}
