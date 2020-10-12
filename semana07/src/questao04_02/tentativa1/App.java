package src.questao04_02.tentativa1;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Fila fila = new Fila(500);
        ThreadFila threadFila = new ThreadFila(fila);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i <= 200; i++){
            ThreadMain threadMain = new ThreadMain(threadFila, "adicionar", i);
            Thread thread = new Thread(threadMain);
            thread.start();

            threads.add(thread);
        }

        try {
            for (Thread t: threads){
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(fila.mostrarUltimo());
        System.out.println("========");

    }


}
