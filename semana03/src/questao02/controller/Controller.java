package questao02.controller;

import questao02.model.Primo;
import questao02.util.util;
import questao02.view.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener, Runnable {

    private Home home;
    private List primos = new ArrayList();;

    public Controller(Home home) {
        this.home = home;
        control();
    }

    private static int applyAsInt(Primo p) {
        return p.getNumero();
    }

    private void control() {

        home.getjButton().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == home.getjButton()){
            if(!home.getTextField().getText().isEmpty()){
                if(util.intValidation(home.getTextField().getText())){
                    disableItens();

                    Thread thread1 = new Thread(this);
                    thread1.start();

                }
            }
        }
    }

    public void clearField(){
        home.getTextField().setText("");
    }

    public void enableItens(){
        home.getjButton().setEnabled(true);
        home.getTextField().setEnabled(true);
    }
    public void disableItens(){
        home.getjButton().setEnabled(false);
        home.getTextField().setEnabled(false);
    }

    public List getPrimos() { return primos; }

    @Override
    public void run() {
        int i = Integer.parseInt(home.getTextField().getText());
        for(int j = 1; j < i ; j++){
            ThreadPrimo primo = new ThreadPrimo(new Primo(j, "Thread - "+j), this);
            Thread thread = new Thread(primo); thread.start();
        }

        primos.forEach(System.out::println);

        System.out.println("TERMINOU");

        primos.removeAll(primos);
        primos.clear();

        clearField();
        enableItens();

    }
}
