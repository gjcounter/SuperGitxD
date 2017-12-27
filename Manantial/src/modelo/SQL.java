/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Duoc UC
 */
public class SQL {
    
    /* DATOS PARA LA CONEXION */
    private String db = "cachosduoc";
    /** usuario */
    private String user = "german@duocsql";
    /** contraseña de MySql*/
    private String password = "#Loquesea2008";
    /** Cadena de conexion */
    private String url = "jdbc:mysql://duocsql.mysql.database.azure.com/";
    /** variable para trabajar con la conexion a la base de datos */
    private Connection conn = null;

     /** Constructor de clase */
     public SQL(){
          this.url = this.url+this.db;
         try{
           //obtenemos el driver de para mysql
           Class.forName("com.mysql.jdbc.Driver");
           //obtenemos la conexión
           conn = DriverManager.getConnection( this.url, this.user , this.password );         
        }catch(SQLException e){
           System.err.println( e.getMessage() );
        }catch(ClassNotFoundException e){
           System.err.println( e.getMessage() );
        }
     }

    public Connection getConexion(){
        return this.conn;
    }
}
