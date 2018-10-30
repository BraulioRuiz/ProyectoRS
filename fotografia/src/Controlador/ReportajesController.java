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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import modelo.Reportaje;

/**
 * FXML Controller class
 *
 * @author ayax9
 */
public class ReportajesController implements Initializable {

    @FXML
    private TextField labelTituloReportaje;
    public  AnchorPane miPane;
    
    
    @FXML
    private ListView<AnchorPane> listaReportajes;
    
    private ObservableList<AnchorPane> paneReportajes;
    public static ObservableList<Reportaje> reportajes;
    private ConexionMysql conexion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reportajes = FXCollections.observableArrayList();
        paneReportajes=FXCollections.observableArrayList();
        conexion = new ConexionMysql();
        conexion.establecerConexion();
        Reportaje.llenarInformacion(conexion, reportajes);
        conexion.establecerConexion();
        llenarPanel();
        llenarMenu();
    }    
     public void llenarPanel(){
        for(Reportaje aux: reportajes){
            miPane = new AnchorPane();
            PanelReportajeController.reportaje = aux;
            createPage();            
        }
    }
    
    private void createPage(){
        try {
            
            miPane = FXMLLoader.load(getClass().getResource("/Vista/PanelReportaje.fxml"));
         //   pane.setLayoutX(9);
         //   pane.setLayoutY(y+=59);
          
            paneReportajes.add(miPane);
          PanelReportajeController.anchor = miPane;
        } catch (IOException ex) {
            Logger.getLogger(BaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void llenarMenu(){
        listaReportajes.setItems(paneReportajes);
    }

    @FXML
    private void comprar(MouseEvent event) {
        BaseController.getInstance().createPage(miPane, "Compra");
    }
    
}
