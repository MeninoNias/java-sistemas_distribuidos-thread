package src.questao04_02.tentativa2;

import java.util.concurrent.BlockingQueue;

public class Adicionar extends Thread {

    private final BlockingQueue<Integer> cubbyhole;
    private int number;

    public Adicionar(BlockingQueue<Integer> c, String name, int num) {
        super(name);
        cubbyhole = c;
        number = num;
    }

    public void run() {
        try {
            cubbyhole.put(number);
            System.out.println(currentThread().getName()  + " adicionou: " + number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
