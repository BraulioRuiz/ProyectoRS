/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author JulioXDDI
 */
public class MenuAdminController implements Initializable {
   
    @FXML
    private AnchorPane apBaseAdmin;
    
    private AnchorPane panel;
    
    @FXML
    private StackPane stkBase;
    
    @FXML
    private AnchorPane apBase;

    private static MenuAdminController instance;
    
    public MenuAdminController(){
        instance=this;
    }
    
    public static MenuAdminController getInstance(){
        return instance;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openSolicitudes(ActionEvent event) {
        panel = new AnchorPane();
        try {
            panel = FXMLLoader.load(getClass().getResource("/Vista/PanelSolicitudes.fxml"));
            setNode(panel);  
        } catch (IOException ex) {
            Logger.getLogger(MenuAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }

    @FXML
    private void openSuscripciones(ActionEvent event) {
        panel = new AnchorPane();
        try {
            panel = FXMLLoader.load(getClass().getResource("/Vista/PanelSuscripciones.fxml"));
            setNode(panel);  
        } catch (IOException ex) {
            Logger.getLogger(MenuAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private  void setNode(Node node){
        
        apBaseAdmin.getChildren().clear();
        apBaseAdmin.getChildren().add((Node)node);
        
        FadeTransition ft = new FadeTransition(Duration.millis(500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
    }
    
    
    
   
    
}
