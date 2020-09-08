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

    private int intervaloThread;

    private int numeroTheads;
    private int numeroIntervalo;

    public Controller(Home home) {
        this.home = home;
        control();
    }

    private void control() {
        home.getjButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == home.getjButton()){
            if(!home.getTextField().getText().isEmpty() && !home.getThreadField().getText().isEmpty()){
                if(util.intValidation(home.getTextField().getText())
                        && util.intValidation(home.getThreadField().getText())){

                    disableItens();

                    numeroTheads = Integer.parseInt(home.getThreadField().getText());
                    numeroIntervalo = Integer.parseInt(home.getTextField().getText());
                    System.out.println("Intervalo: "+numeroIntervalo);

                    intervaloThread = numeroIntervalo/numeroTheads;
                    System.out.println("Intervalor / NºThread: "+intervaloThread);

                    Thread thread1 = new Thread(this);
                    thread1.start();

                }
            }
        }
    }

    public void clearField(){
        home.getTextField().setText("");
        home.getThreadField().setText("");
    }

    public void enableItens(){
        home.getjButton().setEnabled(true);
        home.getTextField().setEnabled(true);
        home.getThreadField().setEnabled(true);
    }
    public void disableItens(){
        home.getjButton().setEnabled(false);
        home.getTextField().setEnabled(false);
        home.getThreadField().setEnabled(false);
    }

    public List getPrimos() { return primos; }

    @Override
    public void run() {
        int i = 1;

        List<Integer> intervalo;
        intervalo = new ArrayList<>();

        synchronized (this){
            for(int j = 1; j <= numeroIntervalo ; j++){

                if (intervalo.size() < intervaloThread){
                    intervalo.add(j);
                    System.out.println(intervalo.size()+" - "+intervaloThread+" -> "+j);
                }

                else{
                    ThreadPrimo primo = new ThreadPrimo(this, intervalo, "Thread"+i);
                    Thread thread = new Thread(primo); thread.start();
                    intervalo.removeAll(intervalo);
                    intervalo.clear();
                    intervalo.add(j);
                    System.out.println(intervalo.size()+" - "+intervaloThread+" -> "+j);
                    i++;
                }
            }

            ThreadPrimo primo = new ThreadPrimo(this, intervalo, "Thread"+i);
            Thread thread = new Thread(primo); thread.start();
            intervalo.removeAll(intervalo);
            intervalo.clear();
        }

        primos.forEach(System.out::println);

        System.out.println("TERMINOU");

        primos.removeAll(primos);
        primos.clear();

        clearField();
        enableItens();

    }
}
