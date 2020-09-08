package questao02.controller;

import questao02.model.Primo;
import questao02.util.util;
import questao02.view.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Controller implements ActionListener {

    private Home home;

    private int intervaloThread;

    private ArrayList<Primo> primos;

    private int numeroThreads;
    private int numeroIntervalo;

    public Controller(Home home) {
        this.home = home;
        this.primos = new ArrayList<>();
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

                    numeroThreads = Integer.parseInt(home.getThreadField().getText());
                    numeroIntervalo = Integer.parseInt(home.getTextField().getText());

                    intervaloThread = numeroIntervalo/numeroThreads;

                    int k = 1;
                    int intervalorInicio = 0;
                    int intervaloFim = 0;
                    int resto = numeroIntervalo%numeroThreads;
                    List<Thread> threads = new ArrayList<>();

                    while (k <= numeroThreads){

                        if(k==numeroThreads){
                            intervaloFim += (intervaloThread+resto);
                            intervalorInicio = (intervaloFim - intervaloThread);
                            System.out.println(intervaloFim);
                        }
                        else{
                            intervaloFim += intervaloThread;
                            intervalorInicio = (intervaloFim - intervaloThread);
                        }

                        ThreadPrimo threadPrimo = new ThreadPrimo(this, intervalorInicio, intervaloFim, "Thread -> "+k);
                        Thread thread = new Thread(threadPrimo);
                        thread.start();
                        threads.add(thread);

                        k++;
                    }

                    for(Thread t: threads){
                        try {
                            t.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    imprimirResultados();
                    clearField();
                    enableItens();

                }
            }
        }
    }

    class SortbPrimo implements Comparator<Primo>{

        public int compare(Primo a, Primo b)
        {
            return a.getNumero() - b.getNumero();
        }
    }


    public void imprimirResultados(){
        primos.sort(new SortbPrimo());

        System.out.println("============================");
        for (Primo p: primos){
            System.out.println(p);
        }
        System.out.println("============================");

        primos.removeAll(primos);
        primos.clear();
    }

    public ArrayList<Primo> getPrimos() {
        return primos;
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
}
