package questao04_01.app;

import questao04_01.controller.Controller;
import questao04_01.view.Home;

public class App {

    public static void main(String[] args) {
        new Controller(new Home("QUESTÃO 03"));
    }
}
