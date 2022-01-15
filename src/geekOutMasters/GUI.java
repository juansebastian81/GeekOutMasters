package geekOutMasters;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used as View of Geek out masters
 * @autor Leidy Estefania Parra Concha parra.leidy@correounivalle.edu.co
 * Juan Sebastian Ospina Maya juan.sebastian.ospina@correounivalle.edu.co
 * @version v.1.0.0 date:13/01/2022
 */
public class GUI extends JFrame {

    private static final String MENSAJE_INICIO="Bienvenido a Craps \n"
            +"Oprime el boton lanzar para iniciar el juego"
            +"\nSi tu tiro de salida es 7 u 11 ganas con Natural"
            +"\nSi tu tiro de salida es 2, 3 u 11 pierdes con Craps"
            +"\nSi sacas cualquier otro valor estableceras el Punto"
            +"\nEstado en punto podras seguir lanzando los dados"
            +"\npero ahora ganaras si vueles a sacar el valor de punto"
            +"\nsin que previamente hayas sacado 7";

    private Header headerProject;
    private JLabel dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private JButton ayuda,salir,lanzar, limpiar;
    private JPanel panelDadosInactivos, panelDadosUtilizados, panelDadosActivos;
    private ImageIcon imageDado;
    private JTextArea mensajeSalida, resultadosDados;
    //private Escucha escucha;
    private ModelGOM modelGOM;

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
        //escucha = new Escucha();
        modelGOM = new ModelGOM();

        //Set up JComponents
        headerProject = new Header("Mesa de Juego Geek out Masters", Color.BLACK);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);

        ayuda = new JButton(" ? ");
        //ayuda.addActionListener();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_START;
        this.add(ayuda,constraints);

        salir = new JButton(" Salir ");
        //salir.addActionListener();
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

        //panel 1
        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(400,220));
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
        panelDadosUtilizados.setPreferredSize(new Dimension(400,220));
        panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder(" Dados Utilizados "));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(panelDadosUtilizados,constraints);

        //panel 3
        panelDadosActivos = new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(400,150));
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


        mensajeSalida = new JTextArea(4,29);
        mensajeSalida.setText(" Usa el boton (?) para ver las reglas del juego ");
        mensajeSalida.setBorder(BorderFactory.createTitledBorder(" Tablero "));
        mensajeSalida.setEditable(false);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(mensajeSalida,constraints);

        lanzar = new JButton("lanzar");
        //lanzar.addActionListener();
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(lanzar,constraints);

        limpiar = new JButton("limpiar");
        //limpiar.addActionListener();
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


}

