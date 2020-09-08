package questao02.controller;


import questao02.model.Primo;

import java.util.ArrayList;
import java.util.List;

public class ThreadPrimo implements Runnable{

    private Controller controller;
    private String nome;

    private int inicio, fim;

    public ThreadPrimo( Controller controller, int inicio, int fim, String nome) {
        this.controller = controller;
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
        for(int i = inicio; i <= fim; i++){
            Primo primo = new Primo(i, this.nome);
            if(isPrimo(primo.getNumero())){
                controller.getPrimos().add(primo);
            }
        }
    }

    //VERIFICA SE É NUMERO PRIMO
    private static boolean isPrimo(int numero){
        for(int j = 2; j < numero; j++){
            if(numero % j == 0){
                return false;
            }
        }
        return true;
    }

}
