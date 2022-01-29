package geekOutMasters;

import javax.swing.*;
import java.util.Random;

/**
 * ModelGOM apply Geek out Masters rules.
 *
 * @author Leidy Estefania Parra Concha
 * Juan Senastian Ospina Maya
 * @version v1.0.0 date 15/01/2022
 */
public class ModelGOM {

    private Dado dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private int[] caras;
    private boolean flag = false;
    private ImageIcon imageDado, imageDragon, image42;
    private Random random;
    private int nuevaCara, i;
    


    public ModelGOM() {

        dado1 = new Dado();
        dado2 = new Dado();
        dado3 = new Dado();
        dado4 = new Dado();
        dado5 = new Dado();
        dado6 = new Dado();
        dado7 = new Dado();
        dado8 = new Dado();
        dado9 = new Dado();
        dado10 = new Dado();
        random = new Random();
        caras = new int[10];


    }

    /**
     *
     */
    public void calcularCara() {

        caras[0] = dado1.getCara();
        caras[1] = dado2.getCara();
        caras[2] = dado3.getCara();
        caras[3] = dado4.getCara();
        caras[4] = dado5.getCara();
        caras[5] = dado6.getCara();
        caras[6] = dado7.getCara();
        caras[7] = dado8.getCara();
        caras[8] = dado9.getCara();
        caras[9] = dado10.getCara();

    }

    public int[] getCaras() {

        return caras;
    }

    public void poderMupple(boolean activar) {

        if (activar == true) {

            JOptionPane.showMessageDialog(null, "Mupple");

        }
    }

    public void poderCohete(boolean activar) {

        if (activar == true) {

            JOptionPane.showMessageDialog(null, "Cohete");

            flag = true;

        }
    }

    public void poderDragon(boolean activar) {

        if (activar == true) {

            imageDragon = new ImageIcon(getClass().getResource("/resources/3.png"));

            JOptionPane.showMessageDialog(null, "Este dado te quitará los puntos obtenidos", "Dado Dragon", JOptionPane.PLAIN_MESSAGE, imageDragon);


        }

    }

    public void poderSuperHeroe(boolean activar) {

        if (activar == true) {

            JOptionPane.showMessageDialog(null, "SuperHeroe");

        }

    }

    public void poderCorazon(boolean activar) {

        if (activar == true)
        {

            nuevaCara = random.nextInt(6) + 1;
            imageDado = new ImageIcon(getClass().getResource("/resources/" + nuevaCara + ".png"));

            JOptionPane.showMessageDialog(null, "Corazón");

        }

    }

    public void poder42(boolean activar) {

        if (activar == true) {

            image42 = new ImageIcon(getClass().getResource("/resources/6.png"));

            JOptionPane.showMessageDialog(null, "Has punteado", "Dado 42", JOptionPane.PLAIN_MESSAGE, image42);
        }

    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
