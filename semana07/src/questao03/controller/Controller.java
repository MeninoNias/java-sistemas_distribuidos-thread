package src.questao03.controller;

import src.questao02.util.util;
import src.questao03.view.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener {

    private Home home;

    private Integer numeroThreads;
    private  Integer numeroMax;

    private static Integer globalContador = 0;

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

                    numeroThreads = Integer.parseInt(home.getFieldThreads().getText());
                    numeroMax = Integer.parseInt(home.getFieldNumero().getText());

                    List<ContadorThread> threads = new ArrayList<>();

                    System.out.println("=====================================================");
                    System.out.println("03.1");
                    System.out.println("=====================================================");

                    //Onde se inicicia os contadores com os valores não globais

//                    for(int i = 1; i <= numeroThreads; i++){
//
//                        ContadorThread thread = new ContadorThread("Thread"+i, numeroMax);
//                        thread.start();
//                        threads.add(thread);
//
//                    }
//
//                    for (ContadorThread t: threads){
//                        try {
//                            t.join();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }

                    System.out.println("=====================================================");
                    System.out.println("03.2");
                    System.out.println("=====================================================");

                    List<ContadorGlobal> threadsGlobal = new ArrayList<>();

//                  Onde se inicia os contadores globais
                    for(int j = 1; j <= numeroThreads; j++){
                        ContadorGlobal thread = new ContadorGlobal("Thread"+j, this);
                        thread.start();
                        threadsGlobal.add(thread);
                    }

                    for (ContadorGlobal t: threadsGlobal){
                        try {
                            t.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    this.setGlobalContador(0);
                    clearField();
                    enableItens();
                }
            }
        }
    }

    public  int getNumeroMax() {
        return numeroMax;
    }

    public  Integer getGlobalContador() {
        return globalContador;
    }

    public  void setGlobalContador(Integer globalContador) {
        Controller.globalContador = globalContador;
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
