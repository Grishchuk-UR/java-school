package com.sbt.javaschool.rnd;

import java.util.Iterator;
import java.util.List;

public class MyIterator<E> implements Iterator {

    private List<E> arrStr;
    private int lengthStr;
    private int index;

    public MyIterator(List<E> str) {
        this.arrStr = str;
        this.lengthStr = str.size();
        index = lengthStr - 1;
    }


    @Override
    public boolean hasNext() {
        return index > 0;
    }

    @Override
    public E next() {
        return arrStr.get(index--);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove");
    }

}
