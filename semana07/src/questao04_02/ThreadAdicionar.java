package src.questao04_02;

public class ThreadAdicionar extends Thread{

    private final Fila fila;
    private Integer a;

    public ThreadAdicionar(Fila fila, Integer a) {
        this.fila = fila;
        this.a = a;
    }

    @Override
    public void run() {
        super.run();
        adicionar(a);
//        System.out.println(get());
    }

    synchronized void adicionar(Integer a){
        while (fila.isInserindo()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        boolean add = fila.adicionar(a);
        fila.setInserindo(true);
        notifyAll();

        if(add){
            fila.setInserindo(false);
            notifyAll();
            return;
        }


    }

    synchronized int get() {
        while (!fila.isInserindo()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fila.setInserindo(false);
        notifyAll();
        return fila.mostrarUltimo();
    }

}
//   while (adicionando){
//           if (fila.isInserindo()){
//           fila.adicionar(a);
//           adicionando = false;
//           }
//           }