/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotografia;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ayax9
 */
public class Fotografia extends Application{

    /**
     * @param args the command line arguments
     */

     @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent_login = FXMLLoader.load(getClass().getResource("/Vista/Base.fxml"));
        Scene login_scene = new Scene(parent_login);
        primaryStage.setScene(login_scene);
       // primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }
    
    public static void main(String[]args){ 
        launch(args);
    }
    
    
}
