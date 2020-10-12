package src.questao04_02.tentativa1;

public class ThreadMain implements Runnable{

    private ThreadFila threadFila;
    private String aor;
    private Integer value;

    public ThreadMain(ThreadFila threadFila, String aor, Integer i) {
        this.threadFila = threadFila;
        this.aor = aor;
        this.value = i;
    }

    @Override
    public void run() {

        if(aor.toUpperCase().equals("ADICIONAR")){
            threadFila.adicionar(value);
        }

        else if(aor.toUpperCase().equals("REMOVER")){
            threadFila.remover();
        }

        else{
            System.out.println("OPÇÃO INVALIDA");
        }

    }
}
