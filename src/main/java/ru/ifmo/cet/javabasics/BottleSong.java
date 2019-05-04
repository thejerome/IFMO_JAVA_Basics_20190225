package ru.ifmo.cet.javabasics;
import java.util.HashMap;
import java.util.Map;
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
public class BottleSong {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "no more");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");
    }

    public BottleSong(int bottleTakenAtOnce) {
        x = bottleTakenAtOnce;
    }

    public String BottleOrBottles(int a){
        String s = new String();
        if (a == 1)
            s = " bottle";
        else s = " bottles";
        return s;
    }

    public String Number(int a) {
        if (map.get(a) != null){
            return map.get(a);
        }
        else return (map.get(a-(a%10)) + " " + map.get(a%10));
    }

    public String getBottleSongLyrics() {
        String s = new String();
        if (x < 1 || x > 99) throw new IllegalArgumentException();
        int y = 99 % x;
        while (ost > y) {
            s += ost + BottleOrBottles(ost) + " of beer on the wall, " + ost + BottleOrBottles(ost) + " of beer.\n";
            ost -= x;
            s +="Take " + Number(x) + " down and pass around, ";
            if (ost == 0)
                s += Number(0);
            else s += ost;
            s += BottleOrBottles(ost) + " of beer on the wall.\n";
        }
        if (y > 0) {
            s += ost + BottleOrBottles(ost) + " of beer on the wall, " + ost + BottleOrBottles(ost) + " of beer.\n";
            ost = 0;
            s +="Take " + Number(y) + " down and pass around, ";
            if (ost == 0)
                s += Number(0);
            else s += ost;
            s += BottleOrBottles(ost) + " of beer on the wall.\n";
        }

        s += "No more bottles of beer on the wall, no more bottles of beer.\n";
        s += "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
        return s;
    }

    int x = 1;
    int ost = 99;
}
