package src.questao04_02.tentativa2;

import java.util.concurrent.BlockingQueue;

public class Remover extends Thread{

    private final BlockingQueue<Integer> cubbyhole;

    public Remover(BlockingQueue<Integer> c, String name) {
        super(name);
        cubbyhole = c;
    }

    public void run() {
        int value = 0;
        try {
            value = cubbyhole.take();
            System.out.println(currentThread().getName() + " remove: " + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
