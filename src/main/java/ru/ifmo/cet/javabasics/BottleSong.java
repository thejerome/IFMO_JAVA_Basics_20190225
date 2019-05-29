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

    private final String[] numbersUpTo19 = {
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

    private final String[] tensNumbers = {
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

    private String transform(int number) {
        if (number < 20) {
            return numbersUpTo19[number];
        }
        else if (number % 10 == 0) {
            return tensNumbers[number / 10];
        }
        else {
            return tensNumbers[number / 10] + " " + numbersUpTo19[number % 10];
        }
    }

    private String checkIfOne(int number){
        return number == 1 ? " bottle": " bottles";
    }

    public BottleSong(int bottleTakenAtOnce) {
        drunk = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        if (drunk > 99 || drunk <= 0) {
            throw new IllegalArgumentException();
        }

        int counter;
        StringBuilder res = new StringBuilder();
        for (counter = 99; counter > drunk; counter -= drunk) {
            res.append(counter + " bottles of beer on the wall, " + counter + " bottles of beer.\n");
            res.append("Take " + transform(drunk) + " down and pass around, " + (counter - drunk) + checkIfOne(counter - drunk) + " of beer on the wall.\n");
        }

        res.append(counter + checkIfOne(counter) + " of beer on the wall, " + counter + checkIfOne(counter) + " of beer.\n");
        res.append("Take " + transform(counter) + " down and pass around, no more bottles of beer on the wall.\n");
        res.append("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");

        return res.toString();
    }

}
