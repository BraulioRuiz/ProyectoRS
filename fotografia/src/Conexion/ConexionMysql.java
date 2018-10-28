package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JulioxDDI
 */
public class ConexionMysql {
    private Connection connection;
    private String url = "jdbc:Mysql://localhost/sistemafotografias";
    private String user = "root";
    private String pass = "xddi";
    
    
    //Conectar Base de Datos
    public void establecerConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Desconectar la Base de DAtos
    public void cerrarConexion(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Obtener Coneccion
    public Connection getConexion(){
        return connection;
    }
}
