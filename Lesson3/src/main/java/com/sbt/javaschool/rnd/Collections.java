package com.sbt.javaschool.rnd;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Collections {

    public List<String> list = new ArrayList<String>();
    public List<String> listWord = new ArrayList<String>();
    public Set<String> hashSet = new TreeSet<String>();
    public Map<Integer, String> map = new HashMap<Integer, String>();
    public Map<String, Integer> mapWord = new HashMap<String, Integer>();



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
                addMapWord(arrStr);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean printInfoWord(Map<String, Integer> mapWord) {
        if (mapWord != null) {
            System.out.println("В фаиле слов (слово - количество): \n");
            for (String s : mapWord.keySet()) {
                System.out.println(s + " - " + mapWord.get(s).toString() + "\n");
            }
            return true;
        }
        return false;
    }

    public boolean addMapWord(String[] arrStr) {
        if (arrStr != null) {
            for (String s : arrStr) {
                Integer count = mapWord.get(s);
                if (count == null)
                    count = 0;
                mapWord.put(s, ++count);
            }
            return true;
        }
        return false;
    }

    public boolean printCountSymbol(Set<String> set) {
        if (set != null) {
            Integer size = set.size();
            System.out.println("Количество различных слов в файле: " + size.toString());
            return true;
        }
        return false;
    }

    public boolean printAnySymbolInFile(Set<String> set) {
        if (set != null) {
            List<String> tempList = new ArrayList<>();
            tempList.addAll(set);
            tempList.sort(Comparator.comparingInt(String::length));
            for (String s : set) {

                System.out.println(s + "\n");
            }
            return true;
        }
        return false;
    }


    public boolean printReversLine(String line) {
        if (line != null) {
            StringBuffer stringBuffer = new StringBuffer(line);
            System.out.println(stringBuffer.reverse());
            return true;
        }
        return false;
    }

    public boolean printLineForUsers(Integer[] number) {
        if (number != null){
            for (int i : number) {
                System.out.println(map.get(i));
            }
            return true;
        }
        return false;
    }

    private void addDataMap(int i, String line) {
        if (line != null)
            map.put(i, line);
    }

    private String[] parseLine(String line) {
        if (line != null) {
            return line.split(" ");
        }
        return null;
    }

    private void addSetCollection(String[] arr) {
        if (arr != null)
            hashSet.addAll(Arrays.asList(arr));
    }

    private void addListCollectionWord(String[] arr) {
        if (arr != null)
            listWord.addAll(Arrays.asList(arr));
    }

    private void addListCollection(String arr) {
        if (arr != null)
            list.add(arr);
    }


}
