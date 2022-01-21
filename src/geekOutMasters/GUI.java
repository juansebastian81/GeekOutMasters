package geekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class is used as View of Geek out masters
 * @autor Leidy Estefania Parra Concha parra.leidy@correounivalle.edu.co
 * Juan Sebastian Ospina Maya juan.sebastian.ospina@correounivalle.edu.co
 * @version v.1.0.0 date:13/01/2022
 */
public class GUI extends JFrame {

    private static final String MENSAJE_AYUDA="Bienvenido a Geek Out Masters \n"
            +"Oprime el boton lanzar para iniciar el juego"
            +"\nBasarse en el panel de dados activos para ver la disponibilidad"
            +"\nde dados que tienes para jugar.";

    private Header headerProject;
    private JLabel dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private JButton ayuda,salir,lanzar, limpiar;
    private JPanel panelDadosInactivos, panelDadosUtilizados, panelDadosActivos;
    private ImageIcon imageDado, imageReglas;
    private JTextArea tablero;
    private Escucha escucha;
    private ModelGOM modelGOM;
    private Boolean flag = false;
    private int[] caras;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setUndecorated(true);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {

        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object and Control Object
        escucha = new Escucha();
        modelGOM = new ModelGOM();

        //Set up JComponents
        headerProject = new Header("Mesa de Juego Geek out Masters", Color.BLACK);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);

        ayuda = new JButton(" ? ");
        ayuda.addMouseListener(escucha);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(ayuda,constraints);

        salir = new JButton(" Salir ");
        salir.addMouseListener(escucha);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        this.add(salir,constraints);

        imageDado = new ImageIcon(getClass().getResource("/resources/dado.png"));
        dado1 = new JLabel(imageDado);

        dado2 = new JLabel(imageDado);

        dado3 = new JLabel(imageDado);

        dado4 = new JLabel(imageDado);

        dado5 = new JLabel(imageDado);

        dado6 = new JLabel(imageDado);

        dado7 = new JLabel(imageDado);

        dado8 = new JLabel(imageDado);

        dado9 = new JLabel(imageDado);

        dado10 = new JLabel(imageDado);


        imageReglas = new ImageIcon(getClass().getResource("/resources/reglas.png"));

        //panel 1
        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(500,250));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder(" Dados Inactivos "));
        panelDadosInactivos.add(dado1);
        panelDadosInactivos.add(dado2);
        panelDadosInactivos.add(dado3);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelDadosInactivos,constraints);

        //panel 2
        panelDadosUtilizados = new JPanel();
        panelDadosUtilizados.setPreferredSize(new Dimension(500,250));
        panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder(" Dados Utilizados "));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelDadosUtilizados,constraints);

        //panel 3
        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(500,150));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder(" Dados Activos "));
        panelDadosActivos.add(dado4);
        panelDadosActivos.add(dado5);
        panelDadosActivos.add(dado6);
        panelDadosActivos.add(dado7);
        panelDadosActivos.add(dado8);
        panelDadosActivos.add(dado9);
        panelDadosActivos.add(dado10);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelDadosActivos,constraints);


        tablero = new JTextArea(4,29);
        tablero.setText(" Usa el boton (?) para ver las reglas del juego ");
        tablero.setBorder(BorderFactory.createTitledBorder(" Tablero "));
        tablero.setEditable(false);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(tablero,constraints);

        lanzar = new JButton(" lanzar ");
        lanzar.addMouseListener(escucha);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(lanzar,constraints);

        limpiar = new JButton(" limpiar ");
        limpiar.addMouseListener(escucha);
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(limpiar,constraints);

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    private class Escucha extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {

            if(e.getSource() == ayuda){

                JOptionPane.showMessageDialog(null,MENSAJE_AYUDA,"Ayuda",JOptionPane.PLAIN_MESSAGE,imageReglas);

            }else if(e.getSource() == lanzar) {


                modelGOM.calcularCara();

                caras = modelGOM.getCaras();

                imageDado = new ImageIcon(getClass().getResource("/resources/"+ caras[0] +".png"));
                dado1.setIcon(imageDado);


                imageDado = new ImageIcon(getClass().getResource("/resources/"+ caras[1] +".png"));
                dado2.setIcon(imageDado);


                imageDado = new ImageIcon(getClass().getResource("/resources/"+ caras[2] +".png"));
                dado3.setIcon(imageDado);


                imageDado = new ImageIcon(getClass().getResource("/resources/"+ caras[3] +".png"));
                dado4.setIcon(imageDado);
                dado4.addMouseListener(escucha);

                imageDado = new ImageIcon(getClass().getResource("/resources/"+ caras[4] +".png"));
                dado5.setIcon(imageDado);
                dado5.addMouseListener(escucha);

                imageDado = new ImageIcon(getClass().getResource("/resources/"+ caras[5] +".png"));
                dado6.setIcon(imageDado);
                dado6.addMouseListener(escucha);

                imageDado = new ImageIcon(getClass().getResource("/resources/"+ caras[6] +".png"));
                dado7.setIcon(imageDado);
                dado7.addMouseListener(escucha);

                imageDado = new ImageIcon(getClass().getResource("/resources/"+ caras[7] +".png"));
                dado8.setIcon(imageDado);
                dado8.addMouseListener(escucha);

                imageDado = new ImageIcon(getClass().getResource("/resources/"+ caras[8] +".png"));
                dado9.setIcon(imageDado);
                dado9.addMouseListener(escucha);

                imageDado = new ImageIcon(getClass().getResource("/resources/"+ caras[9] +".png"));
                dado10.setIcon(imageDado);
                dado10.addMouseListener(escucha);

                revalidate();
                repaint();

            }else if(e.getSource() == limpiar) {


                revalidate();
                repaint();

            }else if(e.getSource() == salir) {

                System.exit(0);

            }

           if(e.getSource() == dado4){

               panelDadosActivos.remove(dado4);
               panelDadosUtilizados.add(dado4);
               dado4.removeMouseListener(escucha);

               //Imagen Mupple
               if(caras[3] == 1){
                   JOptionPane.showMessageDialog(null,"Mupple");

               }
               //Imagen Cohete
               else if(caras[3] == 2){
                   JOptionPane.showMessageDialog(null,"Cohete");

               }
               //Imagen Dragón
               else if(caras[3] == 3){
                   JOptionPane.showMessageDialog(null,"Dragón");

               }
               //Imagen SuperHeroe
               else if(caras[3] == 4){
                   JOptionPane.showMessageDialog(null,"SuperHeroe");

               }
               //Imagen Corazón
               else if(caras[3] == 5){
                   JOptionPane.showMessageDialog(null,"Corazón");

               }
               //Imagen 42
               else if(caras[3] == 6){
                   JOptionPane.showMessageDialog(null,"42");

               }
           }
            if(e.getSource() == dado5){

                panelDadosActivos.remove(dado5);
                panelDadosUtilizados.add(dado5);
                dado5.removeMouseListener(escucha);

                //Imagen Mupple
                if(caras[4] == 1){
                    JOptionPane.showMessageDialog(null,"Mupple");

                }
                //Imagen Cohete
                else if(caras[4] == 2){
                    JOptionPane.showMessageDialog(null,"Cohete");

                }
                //Imagen Dragón
                else if(caras[4] == 3){
                    JOptionPane.showMessageDialog(null,"Dragón");

                }
                //Imagen SuperHeroe
                else if(caras[4] == 4){
                    JOptionPane.showMessageDialog(null,"SuperHeroe");

                }
                //Imagen Corazón
                else if(caras[4] == 5){
                    JOptionPane.showMessageDialog(null,"Corazón");

                }
                //Imagen 42
                else if(caras[4] == 6){
                    JOptionPane.showMessageDialog(null,"42");

                }
            }
            if(e.getSource() == dado6){

                panelDadosActivos.remove(dado6);
                panelDadosUtilizados.add(dado6);
                dado6.removeMouseListener(escucha);

                //Imagen Mupple
                if(caras[5] == 1){
                    JOptionPane.showMessageDialog(null,"Mupple");

                }
                //Imagen Cohete
                else if(caras[5] == 2){
                    JOptionPane.showMessageDialog(null,"Cohete");

                }
                //Imagen Dragón
                else if(caras[5] == 3){
                    JOptionPane.showMessageDialog(null,"Dragón");

                }
                //Imagen SuperHeroe
                else if(caras[5] == 4){
                    JOptionPane.showMessageDialog(null,"SuperHeroe");

                }
                //Imagen Corazón
                else if(caras[5] == 5){
                    JOptionPane.showMessageDialog(null,"Corazón");

                }
                //Imagen 42
                else if(caras[5] == 6){
                    JOptionPane.showMessageDialog(null,"42");

                }
            }
            if(e.getSource() == dado7){

                panelDadosActivos.remove(dado7);
                panelDadosUtilizados.add(dado7);
                dado7.removeMouseListener(escucha);

                //Imagen Mupple
                if(caras[6] == 1){
                    JOptionPane.showMessageDialog(null,"Mupple");

                }
                //Imagen Cohete
                else if(caras[6] == 2){
                    JOptionPane.showMessageDialog(null,"Cohete");

                }
                //Imagen Dragón
                else if(caras[6] == 3){
                    JOptionPane.showMessageDialog(null,"Dragón");

                }
                //Imagen SuperHeroe
                else if(caras[6] == 4){
                    JOptionPane.showMessageDialog(null,"SuperHeroe");

                }
                //Imagen Corazón
                else if(caras[6] == 5){
                    JOptionPane.showMessageDialog(null,"Corazón");

                }
                //Imagen 42
                else if(caras[6] == 6){
                    JOptionPane.showMessageDialog(null,"42");

                }
            }
            if(e.getSource() == dado8){

                panelDadosActivos.remove(dado8);
                panelDadosUtilizados.add(dado8);
                dado8.removeMouseListener(escucha);

                //Imagen Mupple
                if(caras[7] == 1){
                    JOptionPane.showMessageDialog(null,"Mupple");

                }
                //Imagen Cohete
                else if(caras[7] == 2){
                    JOptionPane.showMessageDialog(null,"Cohete");

                }
                //Imagen Dragón
                else if(caras[7] == 3){
                    JOptionPane.showMessageDialog(null,"Dragón");

                }
                //Imagen SuperHeroe
                else if(caras[7] == 4){
                    JOptionPane.showMessageDialog(null,"SuperHeroe");

                }
                //Imagen Corazón
                else if(caras[7] == 5){
                    JOptionPane.showMessageDialog(null,"Corazón");

                }
                //Imagen 42
                else if(caras[7] == 6){
                    JOptionPane.showMessageDialog(null,"42");

                }
            }
            if(e.getSource() == dado9){

                panelDadosActivos.remove(dado9);
                panelDadosUtilizados.add(dado9);
                dado9.removeMouseListener(escucha);

                //Imagen Mupple
                if(caras[8] == 1){
                    JOptionPane.showMessageDialog(null,"Mupple");

                }
                //Imagen Cohete
                else if(caras[8] == 2){
                    JOptionPane.showMessageDialog(null,"Cohete");

                }
                //Imagen Dragón
                else if(caras[8] == 3){
                    JOptionPane.showMessageDialog(null,"Dragón");

                }
                //Imagen SuperHeroe
                else if(caras[8] == 4){
                    JOptionPane.showMessageDialog(null,"SuperHeroe");

                }
                //Imagen Corazón
                else if(caras[8] == 5){
                    JOptionPane.showMessageDialog(null,"Corazón");

                }
                //Imagen 42
                else if(caras[8] == 6){
                    JOptionPane.showMessageDialog(null,"42");

                }
            }
            if(e.getSource() == dado10){

                panelDadosActivos.remove(dado10);
                panelDadosUtilizados.add(dado10);
                dado10.removeMouseListener(escucha);

                //Imagen Mupple
                if(caras[9] == 1){
                    JOptionPane.showMessageDialog(null,"Mupple");

                }
                //Imagen Cohete
                else if(caras[9] == 2){
                    JOptionPane.showMessageDialog(null,"Cohete");

                }
                //Imagen Dragón
                else if(caras[9] == 3){
                    JOptionPane.showMessageDialog(null,"Dragón");

                }
                //Imagen SuperHeroe
                else if(caras[9] == 4){
                    JOptionPane.showMessageDialog(null,"SuperHeroe");

                }
                //Imagen Corazón
                else if(caras[9] == 5){
                    JOptionPane.showMessageDialog(null,"Corazón");

                }
                //Imagen 42
                else if(caras[9] == 6){
                    JOptionPane.showMessageDialog(null,"42");

                }
            }

            revalidate();
            repaint();
        }

    }
}

