package src.questao03.controller;

public class ContadorGlobal extends Thread{

    private static Controller controller;
    private static final Object lock = new Object();

    public ContadorGlobal(String name, Controller controller) {
        super(name);
        ContadorGlobal.controller = controller;
    }

    @Override
    public void run() {

        while (controller.getGlobalContador()<controller.getNumeroMax()){
            increment();
        }

    }

     void increment(){
        synchronized (lock){
            if(controller.getGlobalContador()< controller.getNumeroMax()){
                Integer temp = controller.getGlobalContador()+1;
                controller.setGlobalContador(temp);
                System.out.println(temp+" ->"+currentThread().getName());
            }
        }
    }

}
