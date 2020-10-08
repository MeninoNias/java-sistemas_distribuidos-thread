package src.questao04_01.controller;

public class ContadorThread extends Thread {

    private int max;
    private Controller controller;

    public ContadorThread(String name, int max, Controller controller) {
        super(name);
        this.max = max;
        this.controller = controller;
    }

    @Override
    public void run() {
        super.run();

        for(int i = 0; i <= max; i++){
            if(!controller.isInterrup()){
                break;
            }
            if(i>=max){
                controller.setInterrup(false);
            }
            System.out.println( i + " -> "+this.getName());
        }


    }
}
