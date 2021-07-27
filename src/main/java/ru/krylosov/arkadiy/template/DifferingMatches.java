package ru.krylosov.arkadiy.template;

import ru.krylosov.arkadiy.utility.Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DifferingMatches extends StrategyTemplate {
    @Override
    public void chosenStrategy() {
        Map<String, List<Integer>> searchingMap = Utility.fillingInSearchingMap(Utility.getFileName());
        List<String> peopleInfo = Utility.fillingInList(Utility.getFileName());
        List<Integer> temp = new ArrayList<>();
        List<String> foundString = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String data = bufferedReader.readLine().toLowerCase();
            for (String s : data.split("\\s+")) {
                if (searchingMap.containsKey(s)) {
                    temp.addAll(searchingMap.get(s));
                }
                System.out.println(temp.size() + " peoples found:");
                for (Integer p : temp) {
                    foundString.add(peopleInfo.get(p));
                }
                List<String> supporting = new ArrayList<>();
                supporting.addAll(peopleInfo);
                for (Object O : foundString) {
                    supporting.remove(O);
                }
                for (String k : supporting) {
                    System.out.println(k);
                }
                break;
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Error" + e);
        }
    }
}
