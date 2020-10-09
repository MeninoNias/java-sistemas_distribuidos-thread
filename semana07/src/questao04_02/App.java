package src.questao04_02;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        Integer tamanho = 10;

        Fila fila = new Fila(tamanho);

        System.out.println("ADICIONA DO 1 AO 50");
        System.out.println("========");


        List<Thread> threads = new ArrayList<>();

        //Usando o adicionar
        for(Integer i = 1; i<=tamanho; i++){
            ThreadAdicionar adicionar = new ThreadAdicionar(fila, i);
            adicionar.start();
            threads.add(adicionar);
        }
//
//        for(Thread t: threads){
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
////            }
////        }
//
//        threads.removeAll(threads);
//
//        System.out.println("========");
//        System.out.println("REMOVE DO 1 AO 10");
//        System.out.println("========");
//
//        //Usando o remover
//        for(int i = 1; i<=50; i++){
//            ThreadRemover remover = new ThreadRemover(fila);
//            remover.start();
//            threads.add(remover);
//        }

//        for(Thread t: threads){
//            try {
//                System.out.println("AQUI");
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        System.out.println("========");

    }


}
