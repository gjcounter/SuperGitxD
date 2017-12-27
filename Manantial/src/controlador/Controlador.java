/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JOptionPane;
import modelo.Modelo;
import vista.Interfaz;
import vista.InterfazVenta;


/**
 *
 * @author Duoc UC
 */
public class Controlador implements ActionListener,MouseListener {

    Interfaz interfaz = new Interfaz();
    InterfazVenta interfazVenta = new InterfazVenta();
    
    //modelo
    private Modelo modelo = new Modelo();
    
    public enum Accion{
        boton_login,
        //boton_eliminar,
        //boton_buscar,
        //boton_modificar,
    }
    
    public Controlador() {
         try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(interfaz);
            SwingUtilities.updateComponentTreeUI(interfazVenta);
            interfaz.setTitle("Tienda de Agua");
            interfazVenta.setTitle("Tienda SECRETA de Agua");

        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {}
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}
        interfaz.setVisible(true);
    }
    
    public void iniciar(){
        //Escuchamos los botones
        interfaz.boton_login.setActionCommand( "boton_login" );
        interfaz.boton_login.addActionListener(this);
        
        //Interactuar con la tabla
       /* interfazmostrar.tabla.addMouseListener(this);*/
    }

    //asignamos acciones a los clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        switch ( Accion.valueOf( e.getActionCommand() ) ){
            case boton_login:
                
                String usuario;
                String correo;
                usuario = interfaz.nombreusuario.getText();
                correo = interfaz.correo.getText();
                
                if (modelo.getLogin(usuario,correo)) {
                    // si loguea
                     interfazVenta.setVisible(true);
                     interfaz.loginmsg.setForeground(Color.BLUE);
                     interfaz.loginmsg.setText("Bienvenido");
                } else {
                    //si no loguea
                   interfaz.loginmsg.setText("El usuario y el correo no coinciden");
                    
                }
                
                
               
            break;
            /*
            case boton_eliminar:
                if (interfazeliminar.tf_eliminar.getText().length() > 0){
                    //asdf
                   if(this.modelo.eliminar(Integer.valueOf(interfazeliminar.tf_eliminar.getText())) == true) {
                       //eliminado
                       JOptionPane.showMessageDialog(null, "Se ha eliminado el registro", "Pelicula Eliminada", JOptionPane.INFORMATION_MESSAGE);
                   } else {
                       JOptionPane.showMessageDialog(null, "No existe una película con ese código", "Error", JOptionPane.WARNING_MESSAGE);
                   }
                }
                
            break;
            */
        }  
    }
    
    //asignamos acciones cuando se clickea la tabla
    @Override
    public void mouseClicked(MouseEvent e) {
        /* if( e.getButton()== 1){
            //Muestro datos de producto a modificar
             int fila = interfazmostrar.tabla.rowAtPoint(e.getPoint());
             if (fila > -1){
                /* aqui poblamos los campos segun el modelo de la tabla */
                
                /*
                data[i][0] = res.getString( "codigo" );
                data[i][1] = res.getString( "nombre" );
                data[i][2] = nombre_categoria (Integer.parseInt(res.getString( "id_categoria" )));
                data[i][3] = res.getString( "precio" );
                data[i][4] = res.getString( "formato4k" );
                */
                /*
                interfazmostrar.tf_modificar_codigo.setText(String.valueOf(interfazmostrar.tabla.getValueAt(fila, 0) ));
                interfazmostrar.tf_modificar_nombre.setText(String.valueOf(interfazmostrar.tabla.getValueAt(fila, 1) ));                
                
                
                int selectedindex = 0;
                if (interfazmostrar.tabla.getValueAt(fila, 2).toString().equals("Largometraje")){
                     selectedindex = 1;
                } else if (interfazmostrar.tabla.getValueAt(fila, 2).toString().equals("Infantil")){
                   selectedindex = 2; 
                } else if (interfazmostrar.tabla.getValueAt(fila, 2).toString().equals("Documental")){
                    selectedindex = 3;
                } else if (interfazmostrar.tabla.getValueAt(fila, 2).toString().equals("Musical")){
                    selectedindex = 4;
                }
                interfazmostrar.cb_modificar_categoria.setSelectedIndex(selectedindex);
                interfazmostrar.tf_modificar_precio.setText(String.valueOf(interfazmostrar.tabla.getValueAt(fila, 3) ));
                if (interfazmostrar.tabla.getValueAt(fila, 4).toString().equals("S")){
                    interfazmostrar.radio_modificar_si.setSelected(true);
                    interfazmostrar.radio_modificar_no.setSelected(false);
                } else {
                    interfazmostrar.radio_modificar_no.setSelected(true);
                    interfazmostrar.radio_modificar_si.setSelected(false);
                }
             }
        }
    */
    
    }
    
    /* de aqui para abajo no se usa */
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
