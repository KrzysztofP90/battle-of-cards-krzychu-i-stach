package main;

import main.controller.*;

public class Application {

    public static void main(String[] args) {
        TableController controller = new TableController(new View());
        controller.game();
    }
}