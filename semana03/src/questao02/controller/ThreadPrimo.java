package questao02.controller;


import questao02.model.Primo;

import java.util.ArrayList;
import java.util.List;

public class ThreadPrimo implements Runnable{

    private Controller controller;
    private String nome;
    private List<Integer> intervalo;

    public ThreadPrimo( Controller controller, List<Integer> intervalo, String nome) {
        this.controller = controller;
        this.intervalo = new ArrayList<>(intervalo);
        this.nome = nome;
    }

    @Override
    public void run() {
        System.out.println(intervalo.get(0));
        System.out.println(intervalo.size());
        for(int i: intervalo){
            Primo primo = new Primo(i, this.nome);
            if(isPrimo(primo.getNumero())){
                controller.getPrimos().add(primo);
            }
        }
    }

    private static boolean isPrimo(int numero){
        for(int j = 2; j < numero; j++){
            if(numero % j == 0){
                return false;
            }
        }
        return true;
    }

}
