package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception
    {
        var comparer = new Comparer("test.txt");//текст з файлу
        comparer.wordsList(); // масив окремих слів
        comparer.createMaxPairs(); // пари з найбільшою відстанню
        var pairs = comparer.getMaxPairs();
        for (int i = 0; i < pairs.size(); i++){
            System.out.print("[ ");
            for (String word : pairs.get(i)) {
                System.out.print(word);
                System.out.print(" ");
            }
            System.out.print("] ");
        }
    }
}

