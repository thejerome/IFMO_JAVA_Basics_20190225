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
public class BottleSong {
    public static final String[] oneToNine =
            {"", "one", "two", "three", "four",
                    "five", "six", "seven", "eight", "nine"};
    public static final String[] tenToNineteen =
            {"ten", "eleven", "twelve", "thirteen", "fourteen",
                    "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static final String[] twentyToNinety =
            {"", "", "twenty", "thirty", "forty",
                    "fifty", "sixty", "seventy", "eighty", "ninety"};

    private int bottleTakenAtOnce;
    private int bottlesLeft;

    public BottleSong(int bottleTakenAtOnce) {
        //TODO
        this.bottleTakenAtOnce = bottleTakenAtOnce;
        this.bottlesLeft = 99;
    }

    public String getBottleSongLyrics() {
        //TODO
        if (bottleTakenAtOnce < 1 || bottleTakenAtOnce > 99) throw new IllegalArgumentException();

        StringBuilder res = new StringBuilder();
        String bottles = "bottles";
        String bottlesLeftAsString;
        String bottleTakenAtOnceString;

        while (bottlesLeft > 0) {
            res.append(String.format("%d %s of beer on the wall, %1$d %2$s of beer.\n",
                    bottlesLeft, bottles));

            if (bottleTakenAtOnce > bottlesLeft) {
                bottleTakenAtOnceString = intToString(bottlesLeft);
                bottlesLeft = 0;
            } else {
                bottleTakenAtOnceString = intToString(bottleTakenAtOnce);
                bottlesLeft = bottlesLeft - bottleTakenAtOnce;
            }

            if (bottlesLeft == 1) {
                bottles = "bottle";
                bottlesLeftAsString = "1";
            } else if (bottlesLeft == 0) {
                bottles = "bottles";
                bottlesLeftAsString = "no more";
            } else {
                bottlesLeftAsString = String.valueOf(bottlesLeft);
            }

            res.append(String.format("Take %s down and pass around, %s %s of beer on the wall.\n",
                    bottleTakenAtOnceString, bottlesLeftAsString, bottles));
        }

        res.append("No more bottles of beer on the wall, no more bottles of beer.\n");
        res.append("Go to the store and buy some more, " + 99 + " bottles of beer on the wall.\n");
        return res.toString();
    }

    private String intToString(int x) {
        if (x >= 10 && x <= 19)
            return tenToNineteen[ones];

        if (x % 10 == 0)
            return twentyToNinety[x / 10];
        else if (x / 10 == 0)
            return oneToNine[x % 10];
        else
            return twentyToNinety[x / 10] + " " + oneToNine[x % 10];
    }
}
