package com.sbt.javaschool.rnd.readURL;

import java.util.Scanner;

public class ShowData {

    public static void main(String[] args) {

        System.out.printf("Введите URL сайта: \n");
        while (tryReadURL()) ;
    }

    public static boolean tryReadURL() {
        URLReader urlReader = new URLReader();
        Scanner inputData = new Scanner(System.in);
        try {
            urlReader.readContent(inputData.nextLine());
        } catch (IncorrectURL ex) {
            return true;
        }
        return false;
    }

}
