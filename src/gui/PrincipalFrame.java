/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Objects.GameEst;
import Objects.Juego;
import controller.Buscaminas;
import controller.GestionadorArchivo;
import gui.listener.EncabezadoListener;
import gui.listener.TableroListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author House
 */
public class PrincipalFrame extends JFrame{
    private ControlPanel pnlControl;
    private TableroPanel pnlTablero;
    private Buscaminas buscaminas;
    public PrincipalFrame(String title){
        super(title);
       
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(400, 600);
        super.setLayout(new BorderLayout());
        super.setJMenuBar(createMenu());
        super.setLocationRelativeTo(null);
        
        
        buscaminas = new Buscaminas(10, 10, 10);
        
        
        pnlControl = new ControlPanel();
        pnlControl.setListener(new EncabezadoListener() {
            @Override
            public void btnJuegoOnClick() {
               //pnlTablero.setMensaje(minas+" : "+tiempo);
               buscaminas = new Buscaminas(10, 10, 10);
               pnlTablero.removeAll();
               pnlTablero.drawTablero(buscaminas);
               PrincipalFrame.this.repaint();
            }
        });
           
           
        pnlTablero = new TableroPanel();
        pnlTablero.drawTablero(buscaminas);
        pnlTablero.setListener(new TableroListener() {
            @Override
            public void btnCasillaOnClick(Integer x, Integer y) {
                System.out.printf("hicieron click en [%d][%d]",x,y);
                buscaminas.abrirCelda(x, y);
                if(buscaminas.getEstado() == GameEst.Sigue){
                    pnlTablero.removeAll();
                    pnlTablero.drawTablero(buscaminas);
                    PrincipalFrame.this.repaint();
                }else{
                    System.out.println(buscaminas.getEstado());
                }
                //AGREGAR CONDICIONES SI GANAS O PIERDES!!!!!
                //AGREGAR NIVELES DE DIFICULTAD
                //AGREGAR VENTANA RESIZABLE FALSE Y QUE SE REDIMENSIONE
                //DE ACUERDO A LA DIFICULTAD, QUE EL BOTON CAMBIE DE CARITA FELIZ A TRISTE.
                //O SI GANAS QUE SE PONGA LOS LENTES!!!
                
            }
            @Override
            public void onRightClickButton(Integer x, Integer y){
               System.out.printf("hicieron click en [%d][%d]",x,y);
               buscaminas.marcarCelda(x, y);
               pnlTablero.removeAll();
               pnlTablero.drawTablero(buscaminas);
               PrincipalFrame.this.repaint();
               /*
               
               SI GANO O PERDIO, EL CAMBIO DEL ICONITO, LENTES O MUERTO
               */
            }
        });
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
            JFileChooser fc = new JFileChooser();
                if (fc.showOpenDialog(PrincipalFrame.this) == JFileChooser.APPROVE_OPTION){
                    //cargar el archivo 
                    try {
                        buscaminas = GestionadorArchivo.abrirArchivo(fc.getSelectedFile());
                        pnlTablero.removeAll();
                        pnlTablero.drawTablero(buscaminas);
                        PrincipalFrame.this.repaint();
                    } catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(PrincipalFrame.this, "Archivo no encontrado", 
                                "Alerta", JOptionPane.ERROR_MESSAGE);
                    } catch (IOException ex) {
                    Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                }
            }
        });
        JMenuItem nnGuardar = new JMenuItem("Guardar...");
        nnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               JFileChooser fc = new JFileChooser();
               if(fc.showSaveDialog(PrincipalFrame.this) == JFileChooser.APPROVE_OPTION){

                   System.out.println(fc.getSelectedFile());
                   File f = new File(fc.getSelectedFile().toString());
                   if(f.exists()){
                       JOptionPane.showMessageDialog(PrincipalFrame.this, "Ese archivo ya existe",
                               "Cuidado...",
                               JOptionPane.WARNING_MESSAGE);
                   }else{
                      try {
                          GestionadorArchivo.guardarArchivito(buscaminas, fc.getSelectedFile().toString());
                      } catch (IOException ex) {
                          Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                      }
                       
                   }
               }
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
