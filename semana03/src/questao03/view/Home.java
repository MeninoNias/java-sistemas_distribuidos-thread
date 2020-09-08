package questao03.view;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

    private JLabel labelThreads;
    private JTextField fieldThreads;
    private JLabel labelNumero;
    private JTextField fieldNumero;

    private JButton buttonConformar;

    public Home(String title){
        super(title);
        setSize(145,155);
        setLayout(new FlowLayout());

        labelThreads = new JLabel("Nº Threads: "); add(labelThreads);
        fieldThreads = new JTextField(10); add(fieldThreads);

        labelNumero = new JLabel("Nº: "); add(labelNumero);
        fieldNumero = new JTextField(10); add(fieldNumero);

        buttonConformar = new JButton("Confirmar"); add(buttonConformar);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public JLabel getLabelThreads() {
        return labelThreads;
    }

    public JTextField getFieldThreads() {
        return fieldThreads;
    }

    public JLabel getLabelNumero() {
        return labelNumero;
    }

    public JTextField getFieldNumero() {
        return fieldNumero;
    }

    public JButton getButtonConformar() {
        return buttonConformar;
    }

}
