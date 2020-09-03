package questao01.view;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

    private JTextField textField;
    private JButton btn;
    private JLabel lbl;

    public Home(String tittle){
        super(tittle);

        setSize(500,65);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        textField = new JTextField(30);
        add(textField);

        btn = new JButton("Confirmar");
        add(btn);

        lbl = new JLabel();
        add(lbl);

        setVisible(true);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JButton getBtn() {
        return btn;
    }

    public void setBtn(JButton btn) {
        this.btn = btn;
    }

    public JLabel getLbl() {
        return lbl;
    }

    public void setLbl(JLabel lbl) {
        this.lbl = lbl;
    }

}
