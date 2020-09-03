package questao01.controller;

import questao01.util.util;
import questao01.view.Home;
import questao01.view.menssagem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerHome implements ActionListener {

    private Home home;
    private homeThread thread;

    public ControllerHome(Home home) {
        this.home = home;
        control();
    }

    private void control() {
        home.getBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == home.getBtn()){
            if(!util.intValidation(home.getTextField().getText())){
                clearField();
                menssagem.messageError("Int Error", "Informe somente numeros inteiros");
            }
            else{
                if(!home.getTextField().getText().isEmpty()){
                    int i = Integer.parseInt(home.getTextField().getText());
                    if(i>0) {
                        thread = new homeThread(this, i);
                        Thread thread1 = new Thread(thread);
                        thread1.start();
                    }
                }
            }
        }
    }

    public void changeLabel(int i){
        home.getLbl().setText(i+"");
    }

    public void clearField(){
        home.getTextField().setText("");
    }

    public void enableItens(){
        home.getBtn().setEnabled(true);
        home.getTextField().setEnabled(true);
    }
    public void disableItens(){
        home.getBtn().setEnabled(false);
        home.getTextField().setEnabled(false);
    }
}
