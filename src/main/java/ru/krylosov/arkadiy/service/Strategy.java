package ru.krylosov.arkadiy.service;

import ru.krylosov.arkadiy.template.AllMatches;
import ru.krylosov.arkadiy.template.DifferingMatches;
import ru.krylosov.arkadiy.template.PartialMatсhes;
import ru.krylosov.arkadiy.template.StrategyTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Strategy {

    public void choosingStrategy() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String option = bufferedReader.readLine();
            if (option.equalsIgnoreCase("all")) {
                StrategyTemplate allMatches = new AllMatches();
                allMatches.choosingStrategy();
            } else if (option.equalsIgnoreCase("any")) {
                StrategyTemplate partialMatches = new PartialMatсhes();
                partialMatches.choosingStrategy();
            } else {
                StrategyTemplate differingMatches = new DifferingMatches();
                differingMatches.choosingStrategy();
            }
        } catch (IOException exc) {
            System.out.println("Input error occurred");
        }
    }
}
