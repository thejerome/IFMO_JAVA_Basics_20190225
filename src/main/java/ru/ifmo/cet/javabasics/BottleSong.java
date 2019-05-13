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
    private static final String[] tensWords = {
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    private static final String[] numWords = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };
    private final int taken;

    private String toWords(int num) {
        if (num <= 19)
            return numWords[num];
        else if (num % 10 == 0)
            return tensWords[num / 10];
        else
            return tensWords[num / 10] + " " + numWords[num % 10];
    }

    public BottleSong(int bottleTakenAtOnce) {
        taken = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        if (taken <= 0 || taken > 99) {
            throw new IllegalArgumentException();
        }


        StringBuilder result = new StringBuilder();
        int bottleCounter;


        for (bottleCounter = 99; bottleCounter > taken; bottleCounter -= taken) {
            result.append(bottleCounter + " bottles of beer on the wall, " + bottleCounter + " bottles of beer.\n");
            result.append("Take " + toWords(taken) + " down and pass around, " + (bottleCounter - taken) + (bottleCounter - taken == 1 ? " bottle" : " bottles") + " of beer on the wall.\n");
        }

        result.append(bottleCounter + (bottleCounter == 1 ? " bottle" : " bottles") + " of beer on the wall, " + bottleCounter + (bottleCounter == 1 ? " bottle" : " bottles") + " of beer.\n");
        result.append("Take " + toWords(bottleCounter) + " down and pass around, no more bottles of beer on the wall.\n");

        result.append("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");

        return result.toString();
    }
}
