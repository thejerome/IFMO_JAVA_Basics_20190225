package ru.ifmo.cet.javabasics;

import java.util.HashMap;
import java.util.Map;


public class BottleSong {

    private int bottleTakenAtOnce;
    private int bottles = 99;
    private String text = "";
    private String bottle_s;
    private Map<Integer, String> count = new HashMap<>();

    public BottleSong(int bottleTakenAtOnce) {
        //TODO
        this.bottleTakenAtOnce = bottleTakenAtOnce;

    }



    public void setCount() {
        count.put(1, "one");
        count.put(2, "two");
        count.put(3, "three");
        count.put(4, "four");
        count.put(5, "five");
        count.put(6, "six");
        count.put(7, "seven");
        count.put(8, "eight");
        count.put(9, "nine");
        count.put(10, "ten");
        count.put(11, "eleven");
        count.put(12, "twelve");
        count.put(13, "thirteen");
        count.put(14, "fourteen");
        count.put(15, "fifteen");
        count.put(16, "sixteen");
        count.put(17, "seventeen");
        count.put(18, "eighteen");
        count.put(19, "nineteen");
        count.put(20, "twenty");
        count.put(30, "thirty");
        count.put(40, "forty");
        count.put(50, "fifty");
        count.put(60, "sixty");
        count.put(70, "seventy");
        count.put(80, "eighty");
        count.put(90, "ninety");
    }

    public String getBottleSongLyrics() {
        setCount();

        if (bottleTakenAtOnce > 0 && bottleTakenAtOnce <= 99) {
            while (bottles > 0) {

                if (bottles == 1)
                    bottle_s = "bottle";
                else
                    bottle_s = "bottles";


                if (bottles % bottleTakenAtOnce == 0) {
                    text += bottles + " " + bottle_s + " of beer on the wall, " + bottles + " " + bottle_s + " of beer.\n";
                    bottles -= bottleTakenAtOnce;
                    if (bottles > 0) {
                        text += "Take " + count.get(bottleTakenAtOnce) + " down and pass around, " + bottles + " ";
                        if (bottles == 1) {
                            bottle_s = "bottle";
                        }
                        text += bottle_s + " of beer on the wall.\n";
                    } else {
                        if (bottleTakenAtOnce == 99) {
                            text += "Take " + count.get(90) + " " + count.get(9) + " down and pass around, no more bottles of beer on the wall.\n" +
                                    "No more bottles of beer on the wall, no more bottles of beer.\n" +
                                    "Go to the store and buy some more, 99 bottles of beer on the wall.\n";

                        } else {
                            text += "Take " + count.get(bottleTakenAtOnce) + " down and pass around, no more bottles of beer on the wall.\n" +
                                    "No more bottles of beer on the wall, no more bottles of beer.\n" +
                                    "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
                        }
                    }
                } else if (bottleTakenAtOnce > 20 && bottleTakenAtOnce != 30 && bottleTakenAtOnce != 40 && bottleTakenAtOnce != 50 && bottleTakenAtOnce != 60 && bottleTakenAtOnce != 70 && bottleTakenAtOnce != 80 && bottleTakenAtOnce != 90) {
                    text += bottles + " " + bottle_s + " of beer on the wall, " + bottles + " " + bottle_s + " of beer.\n";
                    bottles -= bottleTakenAtOnce;
                    if (bottles > bottleTakenAtOnce) {
                        text += "Take " + count.get(bottleTakenAtOnce - (bottleTakenAtOnce % 10)) + " " + count.get(bottleTakenAtOnce % 10) + " down and pass around, " + bottles + " " + bottle_s + " of beer on the wall.\n";
                    } else {
                        bottles += bottleTakenAtOnce;
                        bottles -= bottleTakenAtOnce;
                        text += "Take " + count.get(bottleTakenAtOnce - (bottleTakenAtOnce % 10)) + " " + count.get(bottleTakenAtOnce % 10) + " down and pass around, " + bottles + " " + bottle_s + " of beer on the wall.\n";
                        text += bottles + " " + bottle_s + " of beer on the wall, " + bottles + " " + bottle_s + " of beer.\n";
                        if (bottles > 20) {
                            text += "Take " + count.get(bottles - (bottles % 10)) + " " + count.get(bottles % 10) + " down and pass around, no more bottles of beer on the wall.\n" +
                                    "No more bottles of beer on the wall, no more bottles of beer.\n" +
                                    "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
                        } else {
                            text += "Take " + count.get(bottles) + " down and pass around, no more bottles of beer on the wall.\n" +
                                    "No more bottles of beer on the wall, no more bottles of beer.\n" +
                                    "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
                        }
                        bottles = 0;
                    }
                } else {
                    text += bottles + " " + bottle_s + " of beer on the wall, " + bottles + " " + bottle_s + " of beer.\n";
                    bottles -= bottleTakenAtOnce;
                    if (bottles > bottleTakenAtOnce) {
                        text += "Take " + count.get(bottleTakenAtOnce) + " down and pass around, " + bottles + " " + bottle_s + " of beer on the wall.\n";
                    } else {
                        bottles += bottleTakenAtOnce;
                        bottles -= bottleTakenAtOnce;
                        text += "Take " + count.get(bottleTakenAtOnce) + " down and pass around, " + bottles + " ";
                        if (bottles == 1) {
                            bottle_s = "bottle";
                        }
                        text += bottle_s + " of beer on the wall.\n";
                        text += bottles + " " + bottle_s + " of beer on the wall, " + bottles + " " + bottle_s + " of beer.\n";
                        if (bottles > 20) {
                            text += "Take " + count.get(bottles - (bottles % 10)) + " " + count.get(bottles % 10) + " down and pass around, no more bottles of beer on the wall.\n" +
                                    "No more bottles of beer on the wall, no more bottles of beer.\n" +
                                    "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
                        } else {
                            text += "Take " + count.get(bottles) + " down and pass around, no more bottles of beer on the wall.\n" +
                                    "No more bottles of beer on the wall, no more bottles of beer.\n" +
                                    "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
                        }
                        bottles = 0;
                    }
                }


            }
        } else throw new IllegalArgumentException();

        return text;
    }
}
