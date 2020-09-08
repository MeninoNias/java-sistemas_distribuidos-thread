package questao03.app;

import questao03.controller.Controller;
import questao03.view.Home;

public class App {

    public static void main(String[] args) {
        new Controller(new Home("QUESTÃO 03"));
    }
}
