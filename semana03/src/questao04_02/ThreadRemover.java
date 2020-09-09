package questao04_02;

public class ThreadRemover extends Thread{

    private boolean removendo = true;

    private Fila fila;

    public ThreadRemover(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        super.run();
        while (removendo){
            if (fila.isInserindo()){
                fila.remover();
                removendo = false;
            }
        }

    }
}