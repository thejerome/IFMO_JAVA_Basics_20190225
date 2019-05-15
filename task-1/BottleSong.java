package ru.ifmo.cet.javabasics;

public class BottleSong
{
    private static final String[]
            Nums = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen","sixteen", "seventeen", "eighteen", "nineteen",
            "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private String TheSong = "";
    private int
            bottleTakenAtOnce = 0,
            bottleTakenAtOncePrev = 0;
	
    public BottleSong( int bottleTakenAtOnce )
    {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
        this.bottleTakenAtOncePrev = 1 - bottleTakenAtOnce;
    }

    public String getBottleSongLyrics()
    {
        if (bottleTakenAtOnce != bottleTakenAtOncePrev)
            makeSong(bottleTakenAtOnce);
        
        return (TheSong == null) ? "" : TheSong;
    }

    private void makeSong( int bottleTakenAtOnce ) {
        if (bottleTakenAtOnce < 1 || bottleTakenAtOnce > 99)
            throw new IllegalArgumentException();

        this.bottleTakenAtOncePrev = bottleTakenAtOnce;

        int bottlesLeft = 99;
        StringBuilder TheSongBuilder = new StringBuilder();

        if (!TheSong.isEmpty())
            TheSong = "";

        while (bottlesLeft >= bottleTakenAtOnce)
            TheSongBuilder.append(String.format("%s of beer on the wall, %s of beer.\nTake %s down and pass around, %s of beer on the wall.\n",
            sBottlesLeft(bottlesLeft), sBottlesLeft(bottlesLeft), sBottlesTake(bottleTakenAtOnce), sBottlesLeft(bottlesLeft -= bottleTakenAtOnce)));

        if (bottlesLeft > 0)
            TheSongBuilder.append(String.format("%s of beer on the wall, %s of beer.\nTake %s down and pass around, %s of beer on the wall.\n",
                    sBottlesLeft(bottlesLeft), sBottlesLeft(bottlesLeft), sBottlesTake(bottlesLeft), sBottlesLeft(0)));

        TheSongBuilder.append("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");

        TheSong = TheSongBuilder.toString();
    }

    private String sBottlesLeft( int amount ) { return ((amount > 0) ? (new Integer(amount)).toString() : "no more") + (amount == 1 ? " bottle" : " bottles"); }

    private String sBottlesTake( int amount ) { return (amount < 20) ? (sSafeNumsObtain(amount)) : (sSafeNumsObtain(amount / 10 + 18) + ((amount % 10 != 0) ? (" " + sSafeNumsObtain(amount % 10)) : "")); }

    private String sSafeNumsObtain( int index ) { return (index > 0 && index < Nums.length) ? Nums[index] : ""; }
}
