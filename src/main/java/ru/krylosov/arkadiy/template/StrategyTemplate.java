package ru.krylosov.arkadiy.template;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class StrategyTemplate {
    public void choosingStrategy() {
        System.out.println("The strategy is chosen\n" +
                "Enter a name or email to search suitable people.");
        chosenStrategy();
        System.out.println("Operation ended");
    }

    public abstract void chosenStrategy();
}
