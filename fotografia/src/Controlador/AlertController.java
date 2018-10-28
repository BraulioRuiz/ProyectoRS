/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

/**
 * FXML Controller class
 *
 * @author JulioXDDI
 */
public class AlertController implements Initializable {

    @FXML
    private Label lbMensaje;
    @FXML
    private Label lbAceptar;
    
    private Button btnGuardar;
    
    public static String mensaje;
    public static boolean estado;
    public static AnchorPane miPane;
    @FXML
    private FontAwesomeIconView fwicon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbMensaje.setText(mensaje);
        if(estado == false){
            fwicon.setGlyphName("CLOSE");
        }
    }    

    @FXML
    private void openAceptar(MouseEvent event) {
        MenuAdminController.getInstance().eliminarAlert(miPane);
    }
    
}
