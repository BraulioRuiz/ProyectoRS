    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 *
 * @author Pando
 */
public class FotografiaController implements Initializable {
    private Login reg= new Login();
        private Alert warning = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private TextField usuario;
    @FXML
    private PasswordField contraseña;
    @FXML
    private AnchorPane Registro;
    @FXML
    private AnchorPane editorial2;
    private AnchorPane Edit;
    @FXML
    private AnchorPane editorial;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido_p;
    @FXML
    private TextField apellido_m;
    @FXML
    private TextField telefono;
    @FXML
    private TextField correo;
    @FXML
    private TextField genero;
    @FXML
    private TextField id_TipoUsuario;
    @FXML
    private TextField ciudad;
    
    @FXML
    public void Ireditorial(){
        editorial2.toFront();
    }
    @FXML
    public void Iredit(MouseEvent event){
        try {
            Parent menu_parent = FXMLLoader.load(getClass().getResource("/Vista/Base.fxml"));
            Scene menu_scene = new Scene(menu_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(menu_scene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FotografiaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void btnLogin(MouseEvent event) {
        try {
            Parent menu_parent = FXMLLoader.load(getClass().getResource("/Vista/Base.fxml"));
            Scene menu_scene = new Scene(menu_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(menu_scene);
            app_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FotografiaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    
    public void registarUsuario(){
        if(!(nombre.getText().equals("")||apellido_p.getText().equals("")||apellido_m.getText().equals("")||genero.getText().equals("")||telefono.getText().equals("")||correo.getText().equals("")||id_TipoUsuario.getText().equals("")||ciudad.getText().equals(""))){
    boolean q=reg.registrarEditorial(nombre.getText(),apellido_p.getText(),apellido_m.getText(),genero.getText(),telefono.getText(),correo.getText(),id_TipoUsuario.getText(),ciudad.getText());
    if(q==true){
        warning.setContentText("Realizado con exito");
        warning.showAndWait();
        editorial.toFront();
    }else{
        warning.setContentText("Ha ocurrido un error");
        warning.showAndWait();
    }
   }else{
         warning.setContentText("Los campos no pueden estar vacios");
        warning.showAndWait();
    }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
