package com.sbt.javaschool.rnd;

import java.util.Map;

public interface CountMap<T1> {
    // добавляет элемент в этот контейнер.
    void add(T1 o);

    //Возвращает количество добавлений данного элемента
    int getCount(T1 o);

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    int remove(T1 o);

    //количество разных элементов
    int size();

    //Добавить все элементы из source в текущий контейнер, при совпадении ключей,     суммировать значения
    void addAll(CountMap<T1> source);

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    Map toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map destination);

}
