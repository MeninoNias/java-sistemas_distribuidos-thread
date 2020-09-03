package questao01.controller;

import javax.swing.*;

public class homeThread implements Runnable{

    private final ControllerHome controller;
    private int i;

    public homeThread(ControllerHome controller, int i) {
        this.controller = controller;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            controller.disableItens();
            while (i>=0){
                controller.changeLabel(i);
                Thread.sleep(1000);
                i--;
            }
            controller.clearField();
            controller.enableItens();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
