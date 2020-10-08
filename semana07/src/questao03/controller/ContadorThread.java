package src.questao03.controller;

public class ContadorThread extends Thread {

    private int max;

    public ContadorThread(String name, int max) {
        super(name);
        this.max = max;
    }

    @Override
    public void run() {
        super.run();
        for(int i = 0; i <= max; i++){
            System.out.println( i + " -> "+this.getName());
        }


    }
}
