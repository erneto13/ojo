package abc_eclipse;
import javax.swing.JFrame;

import jdbc_ejemplo1.abc_limpio;

public class main {

    public static void main(String[] args) {
        abc_limpio abc = new abc_limpio();
        abc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        abc.setSize(400,200);
        abc.setVisible(true);
    }

}