package src.questao04_02;

public class App {
    public static void main(String[] args) {

        int tamanho = 200;

        Fila fila = new Fila(tamanho);

        //Usando o adicionar
        for(int i = 1; i<=tamanho; i++){
            ThreadAdicionar adicionar = new ThreadAdicionar(fila, i);
            adicionar.start();
        }

        System.out.println("ADICIONA DO 1 AO 200");
        System.out.println("========");
        fila.mostrar();
        System.out.println("========");

        //Usando o remover
        for(int i = 1; i<=50; i++){
            ThreadRemover remover = new ThreadRemover(fila);
            remover.start();
        }

        System.out.println("REMOVE DO 1 AO 50");
        System.out.println("========");
        fila.mostrar();
        System.out.println("========");

    }


}
