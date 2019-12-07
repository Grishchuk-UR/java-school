package com.sbt.javaschool.rnd.ClassRoom;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ClassRoom {



    public void doSomething(){
        //анонимные классы
        //@FunctionalInterface
        //
    }

    Supplier<Integer> supplier  = () -> {
        return 10;
    };

//    Consumer<Integer> consumer = integer -> System.out.println("return ")
//    public void tests(){
//

    Function<Integer, String> function = integer -> String.valueOf(integer);

    public static void main(String[] args) {
        Consumer<Integer> consumer = p-> System.out.println(" my data {}"+ p);
        consumer.accept(111);

     Stream<String> stringStream = Stream.of(1, 2, 3, 4)
                .map(integer -> integer * 10)
                .map(integer -> String.valueOf(integer));

        //.filter(integer -> integer>2)
              //  .forEach(p->
               //     System.out.println(p.getClass()));

//        Stream.iterate(1, integer -> ++integer)
//                .parallel()
//                .limit(10)
//                //.filter(i->i>6)
//                // .parallel()
//                .forEach(i-> System.out.println(i));
//
//        Integer integer = null;
//
//       Optional.ofNullable(integer).ifPresent(p -> System.out.println(p));
    }



}

