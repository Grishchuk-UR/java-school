package com.sbt.javaschool.rnd;

import org.junit.Assert;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.SortedMap;

class CollectionsTest {

    Collections collections = new Collections();


    @BeforeEach
    void readDataFile() {
        //String ss = collections.getClass().getResourceAsStream("test.txt").toString();
        Assert.assertTrue(collections.readDataFile("src/test.txt"));
    }


    @Test
    void testIteratorReversWord() {
        MyIterator<String> iterator = new MyIterator<String>(collections.listWord);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void printInfoWord() {
        Assert.assertTrue(collections.printInfoWord(collections.mapWord));
    }

    @Test
    void printCountSymbol() {
        Assert.assertTrue(collections.printCountSymbol(collections.hashSet));
    }

    @Test
    void printAnySymbolInFile() {
        Assert.assertTrue(collections.printAnySymbolInFile(collections.hashSet));
    }

    @Test
    void printReversLine() {
        for (String s : collections.list)
            Assert.assertTrue(collections.printReversLine(s));
    }

    @Test
    void printLineForUsers() {
        Integer[] count = {1, 3};
        Assert.assertTrue(collections.printLineForUsers(count));
    }
}