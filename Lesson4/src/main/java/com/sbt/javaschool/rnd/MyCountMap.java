package com.sbt.javaschool.rnd;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MyCountMap<T1> implements CountMap<T1> {

    private Map<T1, Integer> map;
    private Integer index;


    public MyCountMap() {
        map = new TreeMap<T1, Integer>();
        index = 0;
    }

    public void add(T1 o) {
        index = map.get(o);
        if (index == null) {
            index = 0;
        }
        map.put(o, ++index);
    }

    public int getCount(T1 o) {
        return map.get(o);
    }

    public int remove(T1 o) {
        index = map.get(o);
        if (index == null) {
            return 0;
        }
        map.remove(o);
        return index;
    }

    public int size() {
        return map.size();
    }

    public void addAll(CountMap<T1> source) {
       Integer tempIndex;
        for(Object key : source.toMap().keySet()){
            tempIndex = map.get(key);
            if(tempIndex == null){
                map.put((T1)key, 1);
            } else {
                map.replace((T1)key, ++tempIndex);
            }
        }

    }

    public Map toMap() {
        return map;
    }

    public void toMap(Map destination) {
        destination.putAll(map);
    }

    public Set<T1> getAllKey() {
        return map.keySet();
    }
}
