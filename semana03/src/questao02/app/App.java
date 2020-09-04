package questao02.app;

import questao02.controller.Controller;
import questao02.view.Home;

public class App {

    public static void main(String[] args) {
        new Controller(new Home("Questão 2"));
    }


}
