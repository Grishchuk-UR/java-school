package com.sbt.javaschool.rnd;

import org.junit.Assert;

import org.junit.jupiter.api.Test;

class CollectionsTest {

    Collections collections = new Collections();

   @Test// @BeforeEach
    void readDataFile() {
       //String ss = collections.getClass().getResourceAsStream("test.txt").toString();
        Assert.assertTrue(collections.readDataFile("com\\sbt\\javaschool\\rnd\\test.txt"));
    }

    @Test
    void printInfoWord() {

    }

    @Test
    void printCountSymbol() {
    }

    @Test
    void printAnySymbolInFile() {
    }

    @Test
    void printReversLine() {
    }

    @Test
    void printLineForUsers() {
    }
}