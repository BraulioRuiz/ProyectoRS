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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author JulioXDDI
 */
public class PanelSuscripcionesController implements Initializable {

    @FXML
    private AnchorPane apBaseSuscripciones;
    private AnchorPane panel;
    @FXML
    private ListView<AnchorPane> lvEditoriales;
    
    private ObservableList<AnchorPane> listaEditoriales;
    
    private static PanelSuscripcionesController instance;
    
    public PanelSuscripcionesController(){
        instance=this;
    }
    
    public static PanelSuscripcionesController getInstance(){
        return instance;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaEditoriales = FXCollections.observableArrayList();
        llenarEditorial();
    }    
    
    public void llenarEditorial(){
        for(int i=0;i<4;i++){
            panel = new AnchorPane(); 
            createPage("PanelEditorial");
            
        }
        lvEditoriales.setItems(listaEditoriales);
    }
    
    
     private void createPage(String inter){
        
        try {
            panel = FXMLLoader.load(getClass().getResource("/Vista/"+ inter +".fxml"));
            listaEditoriales.add(panel);
        } catch (IOException ex) {
            Logger.getLogger(PanelSuscripcionesController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
          //  NotificacionController.solicitud =  b;
        //    NotificacionController.getInstance().setPanel(home);
    }
     
     public void eliminarEditorial(AnchorPane pane){
         lvEditoriales.getItems().remove(pane);
     }
    
}
