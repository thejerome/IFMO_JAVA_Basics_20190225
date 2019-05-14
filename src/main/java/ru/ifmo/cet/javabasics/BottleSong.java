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
    private static final String[] decimalWords = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] fromOneToNineteenWords = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private final int took;

    private String toWords(int num) {
        if (num <= 19)
            return fromOneToNineteenWords[num];
        else if (num % 10 == 0)
            return decimalWords[num / 10];
        else
            return decimalWords[num / 10] + " " + fromOneToNineteenWords[num % 10];
    }

    public BottleSong(int bottleTakenAtOnce) {
        took = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        if (took <= 0 || took > 99) {
            throw new IllegalArgumentException();
        }

        StringBuilder result = new StringBuilder();
        int currentBottle;

        for (currentBottle = 99; currentBottle > took; currentBottle -= took) {
            result.append(currentBottle + " bottles of beer on the wall, " + currentBottle + " bottles of beer.\n");
            result.append("Take " + toWords(took) + " down and pass around, " + (currentBottle - took) + (currentBottle - took == 1 ? " bottle" : " bottles") + " of beer on the wall.\n");
        }

        result.append(currentBottle + (currentBottle == 1 ? " bottle" : " bottles") + " of beer on the wall, " + currentBottle + (currentBottle == 1 ? " bottle" : " bottles") + " of beer.\n");
        result.append("Take " + toWords(currentBottle) + " down and pass around, no more bottles of beer on the wall.\n");

        result.append("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");

        return result.toString();
    }
}