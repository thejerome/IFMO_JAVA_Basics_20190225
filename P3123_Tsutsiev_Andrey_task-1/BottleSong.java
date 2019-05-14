package ru.ifmo.cet.javabasics;

public class BottleSong {
    private static final String[]
            Nums = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen","sixteen", "seventeen", "eighteen", "nineteen",
            "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private String TheSong = "";

    public BottleSong( int bottleTakenAtOnce )
    {
        if (bottleTakenAtOnce < 1 || bottleTakenAtOnce > 99)
            throw new IllegalArgumentException();

        makeSong(bottleTakenAtOnce);
    }

    public String getBottleSongLyrics() { return TheSong; }

    private void makeSong( int bottleTakenAtOnce ) {
        Integer bottlesLeft = 99;

        if (!TheSong.isEmpty())
            TheSong = "";

        while (bottlesLeft >= bottleTakenAtOnce)
            TheSong += sBottlesLeft(bottlesLeft) + " of beer on the wall, " + sBottlesLeft(bottlesLeft) + " of beer.\n" +
                    "Take " + sBottlesTake(bottleTakenAtOnce) + " down and pass around, " + sBottlesLeft(bottlesLeft -= bottleTakenAtOnce) + " of beer on the wall.\n";

        if (bottlesLeft > 0)
            TheSong += sBottlesLeft(bottlesLeft) + " of beer on the wall, " + sBottlesLeft(bottlesLeft) + " of beer.\n" +
                    "Take " + sBottlesTake(bottlesLeft) + " down and pass around, "+ sBottlesLeft(0) + " of beer on the wall.\n";

        TheSong += "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n";
    }

    private String sBottlesLeft( Integer amount ) { return ((amount > 0) ? amount.toString() : "no more") + (amount == 1 ? " bottle" : " bottles"); }

    private String sBottlesTake( Integer amount ) { return (amount < 20) ? (Nums[amount]) : (Nums[amount / 10 + 18] + ((amount % 10 != 0) ? (" " + Nums[amount % 10]) : "")); }
}
