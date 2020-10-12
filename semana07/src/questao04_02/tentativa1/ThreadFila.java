package src.questao04_02.tentativa1;

public class ThreadFila  {

    private final Fila fila;
    private boolean available;

    public ThreadFila(Fila fila){
        this.fila = fila;
    }

    synchronized boolean adicionar(Integer a){
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean adicionado = fila.adicionar(a);
        available = true;
        notifyAll();

        return adicionado;
    }

    synchronized boolean remover(){

        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean removido = fila.remover();
        available = false;
        notifyAll();

        return removido;

    }

//    synchronized Integer get(Integer a){
//
//
//
//    }



}
