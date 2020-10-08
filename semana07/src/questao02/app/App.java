package src.questao02.app;

import src.questao02.controller.Controller;
import src.questao02.view.Home;

public class App {

    public static void main(String[] args) {
        new Controller(new Home("Questão 2"));
    }

}
