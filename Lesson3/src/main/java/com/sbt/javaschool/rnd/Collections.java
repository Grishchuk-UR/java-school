package com.sbt.javaschool.rnd;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Collections {

    private List<String> list = new ArrayList<String>();
    private List<String> listWord = new ArrayList<String>();
    private Set<String> hashSet = new TreeSet<String>();
    private Map<Integer, String> map = new HashMap<Integer, String>();
    private Map<String, Integer> mapWord = new HashMap<String, Integer>();

    public boolean readDataFile(String path) {

        try {
            Scanner scanner = new Scanner(new File(path));
            String str;
            int i = 0;
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                addListCollection(str);
                addDataMap(i, str);

                String[] arrStr = parseLine(str);
                addListCollectionWord(arrStr);
                addSetCollection(arrStr);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public void printInfoWord(Map<String, Integer> mapWord) {
        if (mapWord != null) {
            System.out.println("В фаиле слов: \n");
            for (String s : mapWord.keySet()) {
                System.out.println(s + " - " + mapWord.get(s).toString()+"\n");
            }
        }
    }

    public void addMapWord(String[] arrStr) {
        if (arrStr != null) {
            for (String s : arrStr) {
                Integer count = mapWord.get(s);
                if (count == null)
                    count = 0;
                mapWord.put(s, ++count);
            }
        }
    }

    public void printCountSymbol(Set<String> set) {
        if (set != null) {
            Integer size = set.size();
            System.out.println("Количество различных слов в файле: " + size.toString());
        }
    }

    public void printAnySymbolInFile(Set<String> set) {
        if (set != null)
            for (String s : set) {
                System.out.println(s + "\n");
            }
    }

    public void printReversLine(String line) {
        if (line != null) {
            StringBuffer stringBuffer = new StringBuffer(line);
            System.out.println(stringBuffer.reverse());
        }
    }

    public void printLineForUsers(Integer[] number) {
        if (number != null)
            for (int i : number) {
                System.out.println(map.get(number[i]));
            }
    }

    private void addDataMap(int i, String line) {
        if (line != null)
            map.put(i, line);
    }

    private String[] parseLine(String line) {
        if (line != null) {
            String[] array = line.split(" ");
            return array;
        }
        return null;
    }

    private void addSetCollection(String[] arr) {
        if (arr != null)
            for (String a : arr)
                hashSet.add(a);
    }

    private void addListCollectionWord(String[] arr) {
        if (arr != null)
            for (String a : arr)
                listWord.add(a);
    }

    private void addListCollection(String arr) {
        if (arr != null)
            list.add(arr);
    }


}
