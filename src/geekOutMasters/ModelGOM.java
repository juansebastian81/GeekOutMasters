package geekOutMasters;

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
        private int flag;


        public ModelGOM(){

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

            caras = new int[10];
            flag = 0;

        }

    /**
     *
     */
    public void calcularCara(){

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
}
