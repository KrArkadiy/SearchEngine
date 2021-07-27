package ru.krylosov.arkadiy.template;

import ru.krylosov.arkadiy.utility.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllMatches extends StrategyTemplate {
    @Override
    public void chosenStrategy() {
        Map<String, List<Integer>> searchingMap = Utility.fillingInSearchingMap(Utility.getFileName());
        List<String> peopleInfo = Utility.fillingInList(Utility.getFileName());
        List<Integer> temp = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String data = bufferedReader.readLine().toLowerCase();
            for (String s : data.split("\\s+")) {
                if (searchingMap.containsKey(s)) {
                    temp.addAll(searchingMap.get(s));
                    String tmp = temp.toString();
                    int result = Integer.parseInt(tmp.substring(1, 2));
                    System.out.println(peopleInfo.get(result));
                }
            }
        } catch (IOException exc) {
            System.out.println("Input error occurred");
        }
    }
}
