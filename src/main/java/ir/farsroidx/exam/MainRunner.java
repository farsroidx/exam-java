package ir.farsroidx.exam;

import ir.farsroidx.exam.core.Menu;
import ir.farsroidx.exam.core.models.MenuModel;

import static ir.farsroidx.exam.core.Utils.*;

public final class MainRunner {

    public static void main(String[] args) {

        Menu menu = Menu.of("Please select what you would like to do:",
            MenuModel.of("1", "Select option a"),
            MenuModel.of("2", "Select option b"),
            MenuModel.of("3", "Select option c"),
            MenuModel.of("4", "Select option d"),
            MenuModel.of("x", "Exit")
        );

        whileRun(menu, MainRunner::handleOptions);
    }

    private static void handleOptions(String key) {

        switch (key) {

            case "1":
                println("you are choosing a.");
                break;

            case "2":
                println("you are choosing b.");
                break;

            case "3":
                println("you are choosing c.");
                break;

            case "4":
                println("you are choosing d.");
                break;

            case "x", "X": exit();
        }
    }
}