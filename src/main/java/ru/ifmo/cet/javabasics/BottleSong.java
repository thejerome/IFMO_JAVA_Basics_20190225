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

    private static String[] Tens = { "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static String[] Units = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private int Remove;

    private String fromIntToWord(int value) {
        if (value <= 19)
            return Units[value - 1];
        else if (value % 10 == 0)
            return Tens[value / 10 - 1];
        else
            return Tens[value / 10 - 1] + " " + Units[value % 10 - 1];
    }

    public BottleSong(int bottleTakenAtOnce) {
        Remove = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {


        if (Remove <= 0 || Remove > 99) {
            throw new IllegalArgumentException();
        }

        StringBuilder result = new StringBuilder();

        int Count;
        String temp = " bottles";

        for (Count = 99; Count > Remove; Count -= Remove) {
            if (Count - Remove == 1) {
                temp = " bottle";
            }
            result.append(Count + " bottles of beer on the wall, " + Count + " bottles of beer.\n");
            result.append("Take " + fromIntToWord(Remove) + " down and pass around, " + (Count - Remove) + temp + " of beer on the wall.\n");
        }

        result.append(Count + temp + " of beer on the wall, " + Count + temp + " of beer.\n");
        result.append("Take " + fromIntToWord(Count) + " down and pass around, no more bottles of beer on the wall.\n");

        result.append("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");

        return result.toString();
    }
}
