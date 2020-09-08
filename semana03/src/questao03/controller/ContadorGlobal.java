package questao03.controller;

public class ContadorGlobal extends Thread{

    private Controller controller;

    public ContadorGlobal(String name, Controller controller) {
        super(name);
        this.controller = controller;
    }

    @Override
    public void run() {
        super.run();
        while (controller.getGlobalContador()<controller.getNumeroMax()){
            if(controller.getGlobalContador()<= controller.getNumeroMax()){
                int temp = controller.getGlobalContador()+1;
                controller.setGlobalContador(temp);
                System.out.println(temp+" ->"+getName());
            }
        }
    }
}
