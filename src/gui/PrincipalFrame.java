/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.listener.EncabezadoListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author House
 */
public class PrincipalFrame extends JFrame{
    private ControlPanel pnlControl;
    private TableroPanel pnlTablero;
    public PrincipalFrame(String title){
        super(title);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(400, 600);
        super.setLayout(new BorderLayout());
        
        super.setJMenuBar(createMenu());
        
       
           pnlControl = new ControlPanel();
           pnlControl.setListener(new EncabezadoListener() {
            @Override
            public void btnJuegoOnClick(String minas, String tiempo) {
               pnlTablero.setMensaje(minas+" : "+tiempo);
            }
        });
           
           pnlTablero = new TableroPanel();
           
           
           super.add(pnlControl, BorderLayout.NORTH);
           super.add(pnlTablero, BorderLayout.CENTER);
           super.setVisible(true);

    }
    
    private JMenuBar createMenu(){
        JMenuBar menu = new JMenuBar();
        
        JMenu mmArchivo = new JMenu("Archivo");
        JMenuItem nnNuevo = new JMenuItem("Nuevo");
        nnNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
        nnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 System.out.println("Juego nuevo...");
            }
        });
        JMenuItem nnAbrir = new JMenuItem("Abrir...");
        nnAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Abrir...");
            }
        });
        JMenuItem nnGuardar = new JMenuItem("Guardar...");
        nnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Guardar...");
            }
        });
        JMenuItem nnSalir = new JMenuItem("Salir");
        nnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        mmArchivo.add(nnNuevo);
        
        mmArchivo.addSeparator();
        mmArchivo.add(nnAbrir);
        mmArchivo.add(nnGuardar);
        mmArchivo.addSeparator();
        mmArchivo.add(nnSalir);
        
        JMenu mmNiveles = new JMenu("Niveles");
        
       
        JRadioButtonMenuItem nnPrincipiante = new JRadioButtonMenuItem("Principiante");
        JRadioButtonMenuItem nnIntermedio = new JRadioButtonMenuItem("Intermedio");
        JRadioButtonMenuItem nnExperto = new JRadioButtonMenuItem("Experto");
        JRadioButtonMenuItem nnPersonalizado = new JRadioButtonMenuItem("Personalizado...");
         ButtonGroup btgopciones = new ButtonGroup();
        
        btgopciones.add(nnPrincipiante);
        btgopciones.add(nnIntermedio);
        btgopciones.add(nnExperto);
        btgopciones.add(nnPersonalizado);
        
        mmNiveles.add(nnPrincipiante);
        mmNiveles.add(nnIntermedio);
        mmNiveles.add(nnExperto);
        mmNiveles.addSeparator();
        mmNiveles.add(nnPersonalizado);

        JMenu mmAiuda = new JMenu("Ayuda");
        
        JMenuItem nnAbout = new JMenuItem("Acerca de...");
        
        mmAiuda.add(nnAbout);
        
        JMenu mmTest = new JMenu("Test", false);
        menu.add(mmArchivo);
        menu.add(mmNiveles);
        menu.add(mmAiuda);
        
        
        return menu;
    }
}
