package src.questao04_02;

public class ThreadAdicionar extends Thread{

    private boolean adicionando = true;

    private Fila fila;
    private int a;

    public ThreadAdicionar(Fila fila, int a) {
        this.fila = fila;
        this.a = a;
    }

    @Override
    public void run() {
        super.run();
        while (adicionando){
            if (fila.isInserindo()){
                fila.adicionar(a);
                adicionando = false;
            }
        }

    }
}
