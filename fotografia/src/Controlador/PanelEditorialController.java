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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author JulioXDDI
 */
public class PanelEditorialController implements Initializable {

    @FXML
    private AnchorPane apBaseEditorial;

    @FXML
    private Label lbAceptar;

    @FXML
    private Label lbRechazar;

    @FXML
    private Label llbVerMas;
    



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void openAceptar(MouseEvent event) {
        BaseController.getInstance().Alert("Se ha Aceptado Correctamete su Editorial", true);
        PanelSuscripcionesController.getInstance().eliminarEditorial(apBaseEditorial);
    }

    @FXML
    void openRechazar(MouseEvent event) {
        BaseController.getInstance().Alert("Se ha Rechazado Correctamete su Editorial", true);
        PanelSuscripcionesController.getInstance().eliminarEditorial(apBaseEditorial);
    }

    @FXML
    void openVerMas(MouseEvent event) {
        BaseController.getInstance().Alert("Falta Perfil xD", false);
    }

    
}
