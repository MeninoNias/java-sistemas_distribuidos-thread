package src.questao04_01.controller;

public class ContadorThread extends Thread {

    private final Integer max;
    private final Controller controller;

    private static final Object lock = new Object();
    private boolean imprimindo = true;

    public ContadorThread(String name, Integer max, Controller controller) {
        super(name);
        this.max = max;
        this.controller = controller;
    }

    @Override
    public void run() {
       int i = 0;
       while (i <= max){

           if(!controller.isInterrup()){
               currentThread().interrupt();
               break;
           }

           try {
               imprimindo = true;
               i = estaImprimindo(i);
               sleep(1);
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
           }







       }
    }



    private synchronized Integer estaImprimindo(Integer i) {

        if(i==max){
            controller.setInterrup(false);
        }

        if (imprimindo) {
            imprimindo = false;
            notifyAll();
            System.out.println(i + " " + currentThread().getName());
            i++;
            return i;
        }

        while (!imprimindo) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return i;

    }


}

