package com.sbt.javaschool.rnd;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Streams<T> {

    private List<T> list = new ArrayList<T>();

    public Streams(Collection<T> collect){
        this.list.addAll(collect);
    }


    public static<T> Streams<T> of(Collection<T> collect){
        return new Streams<T>(collect);
    }

    public Streams<T> filter(Predicate<? super T> p)
    {
        List<T> temp = new ArrayList<>();
        for(T q : list)
           if(p.test(q))
               temp.add(q);
        return new Streams<T>(temp);
    }

    public Streams<T> transform(Function<? super T, ? extends T> f){
        List<T> temp = new ArrayList<>();
        for(T q : list)
            temp.add(f.apply(q));
     return new Streams<T>(temp);
    }

    public Map<Object, Object> toMap(Function<? super T, Object> k, Function<? super T, Object> v){
        Map<Object, Object> map = new HashMap<>();
        for(T q : list)
            map.put(k.apply(q), v.apply(q));
        return map;
    }


    public static void main(String[] args) {
        List<Person> l = new ArrayList<>();
        l.add(new Person(true, "1", 12));
        l.add(new Person(true, "3", 2));
        l.add(new Person(true, "1", 82));
        l.add(new Person(true, "2", 62));
        l.add(new Person(true, "5", 122));
        Streams<Person> streams = Streams.of(l);
        Map map = streams.filter(p -> p.getAge() > 30)
                .transform(t -> new Person(t.isMan(), t.getName() + "hhh", t.getAge()))
                .toMap(k -> k.getName(), v -> v.getAge());

        System.out.println(map);
    }
};
