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

    private int bottleTakenAtOnce;

    private String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private String[] upToTwenty = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    public BottleSong(int bottleTakenAtOnce)
    {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
    }

    private String inWord(int bottleTakenAtOnce)
    {
        if (bottleTakenAtOnce <= 19)
            return upToTwenty[bottleTakenAtOnce];
        else if (bottleTakenAtOnce % 10 == 0)
            return tens[bottleTakenAtOnce / 10];
        else
            return tens[bottleTakenAtOnce / 10] + " " + upToTwenty[bottleTakenAtOnce % 10];
    }

    public String getBottleSongLyrics()
    {
        if (bottleTakenAtOnce <= 0 || bottleTakenAtOnce > 99) throw new IllegalArgumentException();

        String result = "";
        int i;


        for (i = 99; i > bottleTakenAtOnce; i -= bottleTakenAtOnce) {
            result = result.concat(i + " bottles of beer on the wall, " + i + " bottles of beer.\n" +
                    "Take " + inWord(bottleTakenAtOnce) + " down and pass around, " + (i - bottleTakenAtOnce) + (i - bottleTakenAtOnce == 1 ? " bottle" : " bottles") + " of beer on the wall.\n");
        }

        result = result.concat(i + (i == 1 ? " bottle" : " bottles") + " of beer on the wall, " + i + (i == 1 ? " bottle" : " bottles") + " of beer.\n" +
                "Take " + inWord(i) + " down and pass around, no more bottles of beer on the wall.\n" +
                "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");

        return result;
    }
}
