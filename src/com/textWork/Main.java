package com.textWork;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static ArrayList<String> keys = new ArrayList<>();
    private static ArrayList<String> value = new ArrayList<>();


    public static void main(String[] args) {
        try {
            FileWork file = new FileWork();
            Scanner readConsole = new Scanner(System.in);
            changeWord("data/list reg.txt");
            String target = readConsole.nextLine();
            //List<String> stringList = file.readList(target);
            List<String> stringList = file.readUtf(target);
            for (int j = 0; j < stringList.size(); j++) {
                for (int i = 0; i < keys.size(); i++) {
                    stringList.set(j, stringList.get(j).replaceAll(keys.get(i), value.get(i)));
                }
            }
            if (args.length > 0 && args[0].equals("-o")) {
                for (int j = 0; j < stringList.size(); j++) {
                    System.out.println(stringList.get(j));
                }
            } else {
                file.writelineUtf(target + "0", stringList);
                //file.writeLine(target + "0", stringList);
            }
            //readConsole.nextLine();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    private static void changeWord(String file) throws FileNotFoundException {
        FileWork fileWork = new FileWork();
        List<String> stringList = fileWork.readUtf(file);
        for (String s : stringList) {
            String[] result;
            result = s.split("/");
            if (result.length < 2) continue;
            keys.add(result[0]);
            value.add(result[1]);
        }


    }


}
