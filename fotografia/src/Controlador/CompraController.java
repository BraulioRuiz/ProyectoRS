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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ayax9
 */
public class CompraController implements Initializable {
    
    @FXML
    private TextField textFecha;

    @FXML
    private TextField txtReferencia;

    @FXML
    private TextField txtTotal;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtConcepto;

    @FXML
    private TextField txtNumPago;
    
    @FXML
    private Button btnComprar;
    private ConexionMysql conexion;
    //public static Usuario usuarioLogin= LoginController.usuario;
    //public static Reportaje reportajecompra=;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    void comprar(MouseEvent event) {
        
    }
    
    
}
