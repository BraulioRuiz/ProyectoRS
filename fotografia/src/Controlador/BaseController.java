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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ayax9
 */
public class BaseController implements Initializable {

   
    @FXML
    private AnchorPane Base;
    
    private  AnchorPane home;
    private AnchorPane panel;
    
    @FXML private Button btnCompra;
    //Usuario baseUsuario = LoginController.usuario;
    /**
     * Initializes the controller class.
     */
    private static BaseController instance;
    
    public BaseController(){
        instance=this;
    }
    public static BaseController getInstance(){
        return instance;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    void mostrarInicio(MouseEvent event) {
        
    }
    
    @FXML
    void comprar(MouseEvent event) {
        createPage("Reportajes");
    }
    private void createPage(String inter){
              
        try {
            home = FXMLLoader.load(getClass().getResource("/Vista/"+ inter +".fxml"));
            setNode(home);
        } catch (IOException ex) {
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void createPage(AnchorPane ap,String inter){
        try {
            ap= FXMLLoader.load(getClass().getResource("/Vista/"+ inter +".fxml"));
            setNode(ap);
        } catch (IOException ex) {
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private  void setNode(Node node){
        Base.getChildren().clear();
        Base.getChildren().add((Node)node);
        
        FadeTransition ft = new FadeTransition(Duration.millis(500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
   
    
    
}
