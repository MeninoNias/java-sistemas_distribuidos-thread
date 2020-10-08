package src.questao03.controller;

public class ContadorThread extends Thread {

    private static Integer max;

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

    synchronized void imprimeTeste(Integer i){

        System.out.println(i + " " + this.getName());

    }

}
