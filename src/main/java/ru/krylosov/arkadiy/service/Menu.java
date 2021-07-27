package ru.krylosov.arkadiy.service;

import ru.krylosov.arkadiy.utility.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {
    public void printingConsoleMenu() {
        System.out.println("""
                ===Menu===
                1. Find a person
                2. Print all people
                0. Exit
                """);
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String enteredOption = bf.readLine();
                if (isCorrectOption(enteredOption)) {
                    if (Integer.parseInt(enteredOption) == 0) {
                        System.out.println("\nBye!");
                        return;
                    } else if (Integer.parseInt(enteredOption) == 1) {
                        new Strategy().choosingStrategy();
                    } else if (Integer.parseInt(enteredOption) == 2) {
                        Utility.printingFullList();
                    }
                } else {
                    System.out.println("Incorrect option entered");
                    return;
                }
        } catch (IOException exc) {
            System.out.println("Input error occurred");
        }
    }

    private boolean isCorrectOption(String enteredOption) {
        return Integer.parseInt(enteredOption) <= 2 && Integer.parseInt(enteredOption) >= 0;
    }
}
