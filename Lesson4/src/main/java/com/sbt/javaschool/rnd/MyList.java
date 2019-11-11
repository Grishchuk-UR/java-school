package com.sbt.javaschool.rnd;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyList<E> {

    private List<E> myList;

    MyList() {
        myList = new LinkedList<E>();
    }

    public int add(E e) {
        myList.add(e);
        return myList.size();
    }

    public int add(int index, E e) {
        myList.add(index, e);
        return myList.size();
    }

    public E get(int index) {
        return myList.get(index);
    }

    public E remove(int index) {
        return myList.remove(index);
    }

    public Iterator<E> iterator() {
        return myList.iterator();
    }

    public boolean addAll(List<? extends E> c) {
        myList.addAll(c);
        return true;
    }

    public boolean copy(List<? super E> c) {
        for (int i = 0; i < myList.size(); i++) {
            myList.set(i, (E) c.get(i));
        }
        return true;
    }
}
