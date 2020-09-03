package questao01.view;

import javax.swing.*;

public class menssagem {

    public static void messageError(String titulo, String menssagem){

        JOptionPane.showMessageDialog(null, menssagem, titulo, JOptionPane.ERROR_MESSAGE);

    }

}
