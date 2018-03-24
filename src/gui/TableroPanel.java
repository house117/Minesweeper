/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author House
 */
public class TableroPanel extends JPanel {
    private JLabel mensaje;
    public TableroPanel(){
        super();
        super.setBackground(Color.BLUE);
        
        mensaje = new JLabel("asasdasd");
        super.add(mensaje);
    }
    public void setMensaje(String mensajito){
        mensaje.setText(mensajito);
    }
    /**
     * @return the textoDeField
     */
    public JLabel getTextoDeField() {
        return mensaje;
    }

    /**
     * @param textoDeField the textoDeField to set
     */
    public void setTextoDeField(JLabel textoDeField) {
        this.mensaje = textoDeField;
    }
}
