package src.questao04_02.tentativa2;

public class App {

    public static void main(String[] args) {

        Integer NUM = 20;

        Fila fila = new Fila(1);

        for (int i = 0; i<=NUM; i++){

            fila.adicionar(i, "Thread"+i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fila.remover("Thread"+i);

        }
    }

}
