package src.questao04_02.tentativa2;

import java.util.StringJoiner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Fila {

    private BlockingQueue<Integer> blockingQueue;

    public Fila(Integer capacidade) {
        this.blockingQueue = new ArrayBlockingQueue<>(capacidade);
    }

    public void adicionar(Integer a, String name){

        Adicionar adicionar = new Adicionar(blockingQueue, name, a);
        adicionar.start();

    }

    public  void remover(String name){

        Remover remover = new Remover(blockingQueue, name);
        remover.start();

    }

}
