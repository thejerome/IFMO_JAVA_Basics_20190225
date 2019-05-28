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

        while (bottlesLeft >= bottleTakenAtOnce) {
            TheSong += sBottlesLeft(bottlesLeft) + " of beer on the wall, " + sBottlesLeft(bottlesLeft) + " of beer.\nTake "
                    + sBottlesTake(bottleTakenAtOnce) + " down and pass around, ";
            bottlesLeft -= bottleTakenAtOnce;
            TheSong += sBottlesLeft(bottlesLeft) + " of beer on the wall.\n";
        }

        if (bottlesLeft > 0)
            TheSong += sBottlesLeft(bottlesLeft) + " of beer on the wall, " + sBottlesLeft(bottlesLeft) + " of beer.\nTake "
                    + sBottlesTake(bottlesLeft) + " down and pass around, " + sBottlesLeft(0) + " of beer on the wall.\n";

        TheSong += "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n";

        return TheSong;
    }

    private String sBottlesLeft( int amount ) {
        String res = "";
        if (amount > 0)
            res += (new Integer(amount)).toString();
        else
            res += "no more";

        res += " bottle";

        if (amount != 1)
            res += "s";

        return res;
    }

    private String sBottlesTake( int amount )
    {
        if (amount < 20)
            return sSafeNumsObtain(amount);

        String res = sSafeNumsObtain(amount / 10 + 18);
        if (amount % 10 != 0)
            res += " " + sSafeNumsObtain(amount % 10);

         return res;
    }

    private String sSafeNumsObtain( int index ) {
        if (index >= 0 && index < Nums.length)
            return Nums[index];
        return "";
    }
}
