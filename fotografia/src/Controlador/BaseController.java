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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author ayax9
 */
public class BaseController implements Initializable {

   
    @FXML
    private AnchorPane Base;
    @FXML
    private StackPane superBase;
    
    private  AnchorPane home;
    private AnchorPane panel;
    
    @FXML private Button btnCompra;
    
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    
    private static BaseController instance;
    
    public BaseController(){
        instance = this;
        usuario = LoginController.usuario;
    }
    public static BaseController getInstance(){
        return instance;
    }
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        if(usuario.getNombre().equals("admin")){
            createPage("MenuAdmin");
        }else{
            createPage("Reportajes");
        }
         
       
    }    
    @FXML
    void mostrarInicio(MouseEvent event) {
        if(usuario.getNombre().equals("admin")){
            createPage("MenuAdmin");
        }else{
            createPage("Reportajes");
        }
    }
     @FXML
    void mostrarPerfil(MouseEvent event) {
        createPage("Pefil");
    }
    
    @FXML
    void verReportajes(MouseEvent event) {
        createPage("Reportajes");
    }
    void close(MouseEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }    
    @FXML
    void CerrarSesion(MouseEvent event) {
        try {
            this.close(event);
            Parent menu_parent = FXMLLoader.load(getClass().getResource
                                    ("/Vista/Login.fxml"));
            Scene menu_scene = new Scene(menu_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(menu_scene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    private  void setNode2(Node node){
        
        superBase.getChildren().add((Node)node);
        
        FadeTransition ft = new FadeTransition(Duration.millis(500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
    }
      public void Alert(String mensaje,boolean estado){ 
        try {
            AlertController.estado = estado;
            AlertController.mensaje = mensaje;
            Base.setDisable(true);
            panel = FXMLLoader.load(getClass().getResource("/Vista/Alert.fxml"));
            AlertController.miPane = panel;
            setNode2(panel);
        } catch (IOException ex) {
            Logger.getLogger(MenuAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }
     
     public void eliminarAlert(AnchorPane pane){
        superBase.getChildren().remove(pane);
        Base.setDisable(false);
    }
   
    
    
}
