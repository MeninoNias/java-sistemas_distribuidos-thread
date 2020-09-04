package questao02.controller;


import questao02.model.Primo;

public class ThreadPrimo implements Runnable{

    private Primo primo;
    private Controller controller;

    public ThreadPrimo(Primo primo, Controller controller) {
        this.primo = primo;
        this.controller = controller;
    }

    @Override
    public void run() {
        if(isPrimo(primo.getNumero())){
            controller.getPrimos().add(primo);
        }
    }

    private static boolean isPrimo(int numero){
        for(int j = 2; j < numero; j++){
            if(numero % j == 0){
                return false;
            }
        }
        return true;
    }

}
