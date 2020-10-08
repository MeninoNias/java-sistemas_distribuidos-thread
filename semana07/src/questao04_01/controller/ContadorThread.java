package src.questao04_01.controller;

public class ContadorThread extends Thread {

    private final Integer max;
    private final Controller controller;

    private static final Object lock = new Object();

    public ContadorThread(String name, Integer max, Controller controller) {
        super(name);
        this.max = max;
        this.controller = controller;
    }

    @Override
    public void run() {
        for(Integer i = 0; i <= max; i++){
            if(!controller.isInterrup()){
                for(Thread t: controller.getThreads()){
                    t.interrupt();
                }
                break;
            }
            if(i>=max){
                controller.setInterrup(false);
            }
            imprime(i);
        }
    }

    void imprime(Integer i){
        synchronized (lock){
            System.out.println( i + " -> "+currentThread().getName());
        }
    }

}

