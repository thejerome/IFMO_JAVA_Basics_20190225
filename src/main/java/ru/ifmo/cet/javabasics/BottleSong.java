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
        Map<Integer, String> map = new HashMap<Integer, String>();
	
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
	
	        String a = "";
	        int bottles = 99;
	        if (bottleTakenAtOnce <= 99 && bottleTakenAtOnce >= 1) {
	            while (bottles - bottleTakenAtOnce > 0) {
	                a += bottles + " bottles of beer on the wall, " + bottles + " bottles of beer.\nTake ";
	                String number = "";
	                if (map.get(bottleTakenAtOnce) != null){
	                    number = map.get(bottleTakenAtOnce);
	                } else {
	                    number = map.get(bottleTakenAtOnce - bottleTakenAtOnce%10) + " " + map.get(bottleTakenAtOnce%10);
	                }
	                if (bottles - bottleTakenAtOnce != 1)
	                    a += number + " down and pass around, " + (bottles - bottleTakenAtOnce) + " bottles of beer on the wall.\n";
	                else
	                    a += number + " down and pass around, " + (bottles - bottleTakenAtOnce) + " bottle of beer on the wall.\n";
	                bottles -= bottleTakenAtOnce;
	            }
	
	
	            if (bottles != 1)
	                a += bottles + " bottles of beer on the wall, " + bottles + " bottles of beer.\n";
	            else
	                a += bottles + " bottle of beer on the wall, " + bottles + " bottle of beer.\n";
	
	            a += "Take ";
	
	            String number = "";

	            if (map.get(bottles) != null){number = map.get(bottles);}
	             else {num = map.get(bottles - bottles%10) + " " + map.get(bottles%10);}


	            a += number + " down and pass around, no more bottles of beer on the wall.\n";
	            a += "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n";
	            return a;
	        } else throw new IllegalArgumentException();
       
    }
}
