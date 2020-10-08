package src.questao03.controller;

public class ContadorThread extends Thread {

    private static Integer max;
    private static final Object lock = new Object();


    public ContadorThread(String name, Integer max) {
        super(name);
        ContadorThread.max = max;
    }

    @Override
    public void run() {
        super.run();

        for(int i = 0; i <= max; i++){
            imprimeTeste(i);
        }

    }

     void imprimeTeste(Integer i){

        synchronized (lock){
            System.out.println(i + " " + this.getName());
        }

    }

}
