package questao04_01.controller;

import questao04_01.util.util;
import questao04_01.view.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener {

    private Home home;

    private int numeroThreads;
    private int numeroMax;

    private boolean interrup;

    public Controller(Home home) {
        this.home = home;

        control();
    }


    private void control() {

        home.getButtonConfirmar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == home.getButtonConfirmar()){
            if(!home.getFieldThreads().getText().isEmpty() && !home.getFieldNumero().getText().isEmpty()){
                if(util.intValidation(home.getFieldThreads().getText()) &&
                        util.intValidation(home.getFieldNumero().getText())){

                    disableItens();

                    interrup = true;

                    numeroThreads = Integer.parseInt(home.getFieldThreads().getText());
                    numeroMax = Integer.parseInt(home.getFieldNumero().getText());

                    List<ContadorThread> threads = new ArrayList<>();

                    System.out.println("=====================================================");
                    System.out.println("04.1");
                    System.out.println("=====================================================");

                    //Onde se inicicia os contadores com os valores não globais
                    for(int i = 1; i <= numeroThreads; i++){

                        ContadorThread thread = new ContadorThread("Thread"+i, numeroMax, this);
                        thread.start();
                        threads.add(thread);

                    }

                    for (ContadorThread t: threads){
                        try {
                            t.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    clearField();
                    enableItens();
                }
            }
        }
    }

    public int getNumeroMax() {
        return numeroMax;
    }

    public boolean isInterrup() {
        return interrup;
    }

    public void setInterrup(boolean interrup) {
        this.interrup = interrup;
    }

    public void clearField(){
        home.getFieldThreads().setText("");
        home.getFieldNumero().setText("");
    }

    public void enableItens(){
        home.getButtonConfirmar().setEnabled(true);
        home.getFieldNumero().setEnabled(true);
        home.getFieldThreads().setEnabled(true);
    }
    public void disableItens(){
        home.getButtonConfirmar().setEnabled(false);
        home.getFieldNumero().setEnabled(false);
        home.getFieldThreads().setEnabled(false);
    }
}
