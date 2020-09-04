package questao02.view;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

    JButton jButton;
    JTextField textField;

    public Home(String title) throws HeadlessException {
        super(title);

        setSize(150,120);

        setLayout(new FlowLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textField = new JTextField(10);
        add(textField);

        jButton = new JButton("Confirmar");
        add(jButton);

        setVisible(true);
    }

    public JButton getjButton() {
        return jButton;
    }

    public JTextField getTextField() {
        return textField;
    }
}
