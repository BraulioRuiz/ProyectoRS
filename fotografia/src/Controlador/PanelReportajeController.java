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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import modelo.Reportaje;

/**
 * FXML Controller class
 *
 * @author ayax9
 */
public class PanelReportajeController implements Initializable {

    @FXML
    private TextField labelTituloReportaje;
    
    public static Reportaje reportaje=null;
    public static AnchorPane anchor;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void comprar(MouseEvent event) {
         BaseController.getInstance().createPage(anchor, "Compra");
    }
    
}
