package ru.ifmo.cet.javabasics;

public class BottleSong
{
    private static final String[]
            Nums = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen","sixteen", "seventeen", "eighteen", "nineteen",
            "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private int bottleTakenAtOnce = 0;
	
    public BottleSong( int bottleTakenAtOnce )
    {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics()
    {
        if (bottleTakenAtOnce < 1 || bottleTakenAtOnce > 99)
            throw new IllegalArgumentException();

        int bottlesLeft = 99;
        String TheSong = "";

        while (bottlesLeft >= bottleTakenAtOnce)
            TheSong += sBottlesLeft(bottlesLeft) + " of beer on the wall, " + sBottlesLeft(bottlesLeft) + " of beer.\nTake "
                    + sBottlesTake(bottleTakenAtOnce) + " down and pass around, " + sBottlesLeft(bottlesLeft -= bottleTakenAtOnce)
                    + " of beer on the wall.\n";

        if (bottlesLeft > 0)
            TheSong += sBottlesLeft(bottlesLeft) + " of beer on the wall, " + sBottlesLeft(bottlesLeft) + " of beer.\nTake "
                    + sBottlesTake(bottlesLeft) + " down and pass around, " + sBottlesLeft(0) + " of beer on the wall.\n";

        TheSong += "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n";

        return TheSong;
    }

    private String sBottlesLeft( int amount ) { return ((amount > 0) ? (new Integer(amount)).toString() : "no more") + (amount == 1 ? " bottle" : " bottles"); }

    private String sBottlesTake( int amount ) { return (amount < 20) ? (sSafeNumsObtain(amount)) : (sSafeNumsObtain(amount / 10 + 18) + ((amount % 10 != 0) ? (" " + sSafeNumsObtain(amount % 10)) : "")); }

    private String sSafeNumsObtain( int index ) { return (index > 0 && index < Nums.length) ? Nums[index] : ""; }
}
