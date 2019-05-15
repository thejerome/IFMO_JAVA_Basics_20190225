package ru.ifmo.cet.javabasics;

/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
 * 99 bottles of beer on the wall, 99 bottles of beer
 * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */

import java.util.HashMap;
import java.util.Map;

public class BottleSong {
    int bottleTakenAtOnce;
    public BottleSong(int bottleTakenAtOnce) {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        Map<Integer, String> m = new HashMap<Integer, String>();
        m.put(0, "no more");
        m.put(1, "one");
        m.put(2, "two");
        m.put(3, "three");
        m.put(4, "four");
        m.put(5, "five");
        m.put(6, "six");
        m.put(7, "seven");
        m.put(8, "eight");
        m.put(9, "nine");
        m.put(10, "ten");
        m.put(11, "eleven");
        m.put(12, "twelve");
        m.put(13, "thirteen");
        m.put(14, "fourteen");
        m.put(15, "fifteen");
        m.put(16, "sixteen");
        m.put(17, "seventeen");
        m.put(18, "eighteen");
        m.put(19, "nineteen");
        m.put(20, "twenty");
        m.put(30, "thirty");
        m.put(40, "forty");
        m.put(50, "fifty");
        m.put(60, "sixty");
        m.put(70, "seventy");
        m.put(80, "eighty");
        m.put(90, "ninety");

        String s = "";
        int bottles = 99;
        if (bottleTakenAtOnce > 0 && bottleTakenAtOnce < 100) {
            while (bottles > bottleTakenAtOnce) {
                s += bottles + " bottles of beer on the wall, " + bottles + " bottles of beer.\n";
                s += "Take ";
                if (m.get(bottleTakenAtOnce) != null) s += m.get(bottleTakenAtOnce);
                else s += m.get(bottleTakenAtOnce/10*10) + ' ' + m.get(bottleTakenAtOnce%10);
                s += " down and pass around, " + (bottles - bottleTakenAtOnce);
                if (bottles - bottleTakenAtOnce == 1) s += " bottle of beer on the wall.\n";
                else s += " bottles of beer on the wall.\n";
                bottles -= bottleTakenAtOnce;
            }
            if (bottles != 1) s += bottles + " bottles of beer on the wall, " + bottles + " bottles of beer.\n";
            else s += bottles + " bottle of beer on the wall, " + bottles + " bottle of beer.\n";
            s += "Take ";
            if (m.get(bottles) != null) s += m.get(bottles);
            else s += m.get(bottles/10*10) + ' ' + m.get(bottles%10);
            s += " down and pass around, no more bottles of beer on the wall.\n" +
                 "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n";
            return s;
        }
        else throw new IllegalArgumentException();
    }
}
