/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.PrintStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duoc UC
 */
public class Modelo {
    
    public Modelo (){}
    
    SQL laconexion = new SQL();
    
    public boolean getLogin(String nombre, String correo){
        boolean valor=false;
        String q = "SELECT id FROM cachosduoc.usuarios WHERE usuario = '"+nombre+"';";
        int idusuario = 0;
        int idcorreo = -1;
        try {
            PreparedStatement pstm = laconexion.getConexion().prepareStatement(q);
            ResultSet resultadou = pstm.executeQuery();
            if (resultadou.next()){
                idusuario = resultadou.getInt("id");
                resultadou.close();  
            }
        }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        
        String r = "SELECT id FROM cachosduoc.usuarios WHERE correo = '"+correo+"';";
        try {
            PreparedStatement pstm = laconexion.getConexion().prepareStatement(r);
            ResultSet resultadoc = pstm.executeQuery();
            if (resultadoc.next()) {
                idcorreo = resultadoc.getInt("id");
                resultadoc.close();  
            }
        }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        
        if (idusuario == idcorreo){
            valor = true;
        }
        
        return valor;
    }
    
}
