package geekOutMasters;

import java.util.Random;

/**
 * Class Dado generate a Random value between 1 and 6
 * @author Leidy Estefania Parra Concha
 * Juan Sebastian Ospina Maya
 * @version v1.0.0 date 14/01/2021
 */
public class Dado {

    private int cara;

    /**
     * Method that generate and random value to cara
     * @return number between (1,6)
     */
    public int getCara() {
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6) + 1;
        return cara;
    }
}
