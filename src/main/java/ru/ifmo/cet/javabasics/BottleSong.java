package ru.ifmo.cet.javabasics;

public class BottleSong {
    private int count;

    private String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private String[] upToTwenty = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    public BottleSong(int count) {
        this.count = count;
    }

    private String inWord(int count) {
        if (count <= 19)
            return upToTwenty[count];
        else if (count % 10 == 0)
            return tens[count / 10];
        else
            return tens[count / 10] + " " + upToTwenty[count % 10];
    }

    public String getBottleSongLyrics() {

        if (count <= 0 || count > 99) throw new IllegalArgumentException();

        String result = "";
        int i;


        for (i = 99; i > count; i -= count) {
            result = result.concat(i + " bottles of beer on the wall, " + i + " bottles of beer.\n" +
                    "Take " + inWord(count) + " down and pass around, " + (i - count) + (i - count == 1 ? " bottle" : " bottles") + " of beer on the wall.\n");
        }

        result = result.concat(i + (i == 1 ? " bottle" : " bottles") + " of beer on the wall, " + i + (i == 1 ? " bottle" : " bottles") + " of beer.\n" +
                "Take " + inWord(i) + " down and pass around, no more bottles of beer on the wall.\n" +
                "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");

        return result;
    }

}