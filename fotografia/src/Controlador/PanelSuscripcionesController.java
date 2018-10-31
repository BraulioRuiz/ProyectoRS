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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import modelo.Usuario;

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
    
    private ObservableList<AnchorPane> PanelEditoriales;
    
    private static PanelSuscripcionesController instance;
    
    
    public PanelSuscripcionesController(){
        instance=this;
    }
    
    public static PanelSuscripcionesController getInstance(){
        return instance;
    }
    
     //Colecciones
    private ObservableList<Usuario> editoriales;
    
    //Mysql
    private ConexionMysql conexion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PanelEditoriales = FXCollections.observableArrayList();
        editoriales = FXCollections.observableArrayList();
        conexion = new ConexionMysql();
        conexion.establecerConexion();
        Usuario.llenarInformacionEditorial(conexion, editoriales);
        conexion.cerrarConexion();
        llenarEditorial();
    }    
    
    public void llenarEditorial(){
        for(Usuario aux:editoriales){
            panel = new AnchorPane(); 
            PanelEditorialController.editorial=aux;
            createPage("PanelEditorial");
        }
        lvEditoriales.setItems(PanelEditoriales);
    }
    
    
     private void createPage(String inter){
        
        try {
            panel = FXMLLoader.load(getClass().getResource("/Vista/"+ inter +".fxml"));
            PanelEditoriales.add(panel);
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
