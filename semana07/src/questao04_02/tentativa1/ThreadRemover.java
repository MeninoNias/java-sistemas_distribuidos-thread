package src.questao04_02.tentativa1;

public class ThreadRemover extends Thread{

    private final Fila fila;

    public ThreadRemover(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        super.run();
//        System.out.println(getPrimeiro());
        System.out.println("OI");
        remover();
    }

    synchronized void remover() {
        while (!fila.isInserindo()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean r = fila.remover();
        if(r){
            System.out.println("OI");
            fila.setInserindo(false);
            notifyAll();
            return;
        }

        fila.setInserindo(false);
        notifyAll();
    }

    synchronized int getPrimeiro() {
        while (fila.isInserindo()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fila.setInserindo(true);
        notifyAll();
        return fila.mostrarPrimeiro();
    }

}