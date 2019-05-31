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
    private final int drunk;

    private final String[] under19 = {
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

    private final String[] tenty = {
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
    private final String[] tenty = {
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

    private String change(int number) {
        if (number < 20) {
            return under19[number];
        }
        else if (number % 10 == 0) {
            return tenty[number / 10];
        }
        else {
            return tenty[number / 10] + " " + under19[number % 10];
        }
    }

    private String IfOne(int number){
        return number == 1 ? " bottle": " bottles";
    }
    public BottleSong(int bottleTakenAtOnce) {
        //TODO
        drunk = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        //TODO
        throw new UnsupportedOperationException();
        if (drunk > 99 || drunk <= 0) {
            throw new IllegalArgumentException();
        }

        int counter;
        StringBuilder Songg = new StringBuilder();
        for (counter = 99; counter > drunk; counter -= drunk) {
            Songg.append(counter + " bottles of beer on the wall, " + counter + " bottles of beer.\n");
            Songg.append("Take " + change(drunk) + " down and pass around, " + (counter - drunk) + IfOne(counter - drunk) + " of beer on the wall.\n");
        }

        Songg.append(counter + IfOne(counter) + " of beer on the wall, " + counter + IfOne(counter) + " of beer.\n");
        Songg.append("Take " + change(counter) + " down and pass around, no more bottles of beer on the wall.\n");
        Songg.append("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");

        return Songg.toString();
    }
    }
