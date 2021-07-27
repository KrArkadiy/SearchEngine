package ru.krylosov.arkadiy.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Utility {

    private final static String fileName = "C:\\Users\\Аркадий\\Desktop\\Search engine data.txt";

    public static String getFileName() {
        return fileName;
    }

    public static List<String> fillingInList(String fileName){
        List<String> peopleInfo = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
           while(sc.hasNextLine()){
               String data = sc.nextLine();
               peopleInfo.add(data);
           }
        } catch(IOException exc){
            System.out.println("Input error occurred");
        }
        return peopleInfo;
    }

    public static void printingFullList(){
        Utility.fillingInList(Utility.getFileName()).forEach(System.out::println);
    }

    public static Map<String, List<Integer>> fillingInSearchingMap(String fileName){
        Map<String, List<Integer>> searchingMap = new HashMap<>();
        try(Scanner sc = new Scanner(new FileReader(fileName))){
            int count = 0;
            while (sc.hasNextLine()){
                String data = sc.nextLine();
                for(String s : data.split("\\s+")) {
                    String chapter = s.toLowerCase();
                    if(searchingMap.containsKey(chapter)) {
                        searchingMap.get(chapter).add(count);
                    } else {
                        searchingMap.put(chapter, new ArrayList<>(List.of(count)));
                    }
                }
                count++;
            }
        } catch (IOException exc){
            System.out.println("Input error occurred");
        }
        return searchingMap;
    }
}

