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

import java.util.*;

public class BottleSong {

    public Map<Integer,String> dictionary;
    private int take;
    private int botle;

    public BottleSong(int bottleTakenAtOnce) {
        this.take=bottleTakenAtOnce;
        this.botle=99;
        this.dictionary=new HashMap<Integer, String>();
    }

    public String getBottleSongLyrics() {
        if(this.take>99||this.take<1) throw new IllegalArgumentException();
        if(this.take==99) return "99 bottles of beer on the wall, 99 bottles of beer.\n" +
                "Take ninety nine down and pass around, no more bottles of beer on the wall.\n" +
                "No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
        String Lyrics="";
        dictionary.put(1,"one");
        dictionary.put(2,"two");
        dictionary.put(3,"three");
        dictionary.put(4, "four");
        dictionary.put(5,"five");
        dictionary.put(6,"six");
        dictionary.put(7,"seven");
        dictionary.put(8,"eight");
        dictionary.put(9, "nine");
        dictionary.put(10,"ten");
        dictionary.put(11,"eleven");
        dictionary.put(12,"twelve");
        dictionary.put(13,"thirteen");
        dictionary.put(14,"fourteen");
        dictionary.put(15,"fifteen");
        dictionary.put(16,"sixteen");
        dictionary.put(17,"seventeen");
        dictionary.put(18,"eighteen");
        dictionary.put(19,"nineteen");
        dictionary.put(20,"twenty");
        dictionary.put(30,"thirty");
        dictionary.put(40,"forty");
        dictionary.put(50,"fifty");
        dictionary.put(60,"sixty");
        dictionary.put(70,"seventy");
        dictionary.put(80,"eighty");
        dictionary.put(90,"ninety");
        while (this.take < this.botle) {
            if(this.botle-this.take==1)  Lyrics+=this.botle + " bottles of beer on the wall, " + this.botle + " bottles of beer.\n" + "Take " + number(this.take) + " down and pass around, " + (this.botle = this.botle - this.take) + " bottle of beer on the wall.\n";
            else Lyrics+=this.botle + " bottles of beer on the wall, " + this.botle + " bottles of beer.\n" + "Take " + number(this.take) + " down and pass around, " + (this.botle = this.botle - this.take) + " bottles of beer on the wall.\n";
        }
        if(this.botle==1){Lyrics+="1 bottle of beer on the wall, 1 bottle of beer.\n"+"Take one down and pass around, no more bottles of beer on the wall.\n"; this.botle=0;}
        if(this.botle==0){return Lyrics+"No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.\n";}
        return Lyrics + this.botle + " bottles of beer on the wall, " + this.botle + " bottles of beer.\n" + "Take " + number(this.botle) + " down and pass around, no more bottles of beer on the wall.\n"+"No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
    }
    private String number(int number){
        if (number<=20||number%10==0) return this.dictionary.get(number);
        else return this.dictionary.get(number-number%10)+" "+this.dictionary.get(number%10);
    }
}
