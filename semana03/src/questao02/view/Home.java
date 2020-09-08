package questao02.view;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

    JButton jButton;
    JTextField textField;
    JTextField threadField;

    JLabel labelIntervalo;
    JLabel labelThread;

    public Home(String title) throws HeadlessException {
        super(title);

        setSize(150,155);

        setLayout(new FlowLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelIntervalo = new JLabel("Intervalo:"); add(labelIntervalo);

        textField = new JTextField(10);
        add(textField);

        labelThread = new JLabel("Threads:"); add(labelThread);

        threadField = new JTextField(10);
        add(threadField);


        jButton = new JButton("Confirmar");
        add(jButton);

        setVisible(true);
    }

    public JTextField getThreadField() {return threadField;}
    public JButton getjButton() {
        return jButton;
    }
    public JTextField getTextField() {
        return textField;
    }
}
