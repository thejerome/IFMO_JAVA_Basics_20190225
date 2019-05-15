package ru.ifmo.cet.javabasics;

import java.util.HashMap;
import java.util.Map;

public class BottleSong {
    private int bottlesTakenAtOnce;
    public BottleSong(int bottleTakenAtOnce) {
        this.bottlesTakenAtOnce = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        int bottles = 99;
        String SUNum = "";
        String BottleSongLyrics = "";
        String BottlesBottle = "bottles";

        Map<Integer, String> bottleTaken = new HashMap<Integer, String>();

        bottleTaken.put(0, "");
        bottleTaken.put(1, "one");
        bottleTaken.put(2, "two");
        bottleTaken.put(3, "three");
        bottleTaken.put(4, "four");
        bottleTaken.put(5, "five");
        bottleTaken.put(6, "six");
        bottleTaken.put(7, "seven");
        bottleTaken.put(8, "eight");
        bottleTaken.put(9, "nine");
        bottleTaken.put(10, "ten");
        bottleTaken.put(11, "eleven");
        bottleTaken.put(12, "twelve");
        bottleTaken.put(13, "thirteen");
        bottleTaken.put(14, "fourteen");
        bottleTaken.put(15, "fifteen");
        bottleTaken.put(16, "sixteen");
        bottleTaken.put(17, "seventeen");
        bottleTaken.put(18, "eighteen");
        bottleTaken.put(19, "nineteen");
        bottleTaken.put(20, "twenty");
        bottleTaken.put(30, "thirty");
        bottleTaken.put(40, "forty");
        bottleTaken.put(50, "fifty");
        bottleTaken.put(60, "sixty");
        bottleTaken.put(70, "seventy");
        bottleTaken.put(80, "eighty");
        bottleTaken.put(90, "ninety");

        if (bottlesTakenAtOnce < 20 || bottlesTakenAtOnce % 10 == 0) {
            SUNum = bottleTaken.get(bottlesTakenAtOnce);
        } else SUNum = bottleTaken.get(bottlesTakenAtOnce / 10 * 10) + " " + bottleTaken.get(bottlesTakenAtOnce % 10);

        if (bottlesTakenAtOnce < 100 && bottlesTakenAtOnce > 0) {
            while (bottles > bottlesTakenAtOnce) {
                BottleSongLyrics += bottles + " bottles of beer on the wall, " + bottles + " bottles of beer.\n";
                BottleSongLyrics += "Take ";
                if ((bottles - bottlesTakenAtOnce > 0)) {
                    bottles -= bottlesTakenAtOnce;
                    if (bottles == 1) BottlesBottle = "bottle";
                    BottleSongLyrics += SUNum + " down and pass around, " + bottles + " " + BottlesBottle + " of beer on the wall.\n";
                }
            }
            if (bottles < 20) {
                SUNum = bottleTaken.get(bottles);
            } else SUNum = bottleTaken.get(bottles / 10 * 10) + " " + bottleTaken.get(bottles % 10);
            BottleSongLyrics += bottles + " " + BottlesBottle + " of beer on the wall, " + bottles + " " + BottlesBottle + " of beer.\n";
            BottleSongLyrics += "Take " + SUNum + " down and pass around, no more bottles of beer on the wall.\n";
            BottleSongLyrics += "No more bottles of beer on the wall, no more bottles of beer.\n";
            BottleSongLyrics += "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
            return BottleSongLyrics;
        }
        else throw new IllegalArgumentException();
    }
}