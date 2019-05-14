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
public class BottleSong
{
    private final int bottleTakenAtOnce;

    public BottleSong(int bottleTakenAtOnce)
    {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics()
    {
        StringBuilder builder = new StringBuilder();
        int counter;

        for (counter = 99; counter > bottleTakenAtOnce; counter -= bottleTakenAtOnce)
        {
            builder.append(String.format("%d bottles of beer on the wall, %d bottles of beer.\n" +
                            "Take%s down and pass around, %d%s of beer on the wall.\n",
                    counter, counter, getNumberWord(bottleTakenAtOnce), counter - bottleTakenAtOnce, counter - bottleTakenAtOnce == 1 ? " bottle" : " bottles"));
        }
        builder.append(String.format("%d%s of beer on the wall, %d%s of beer.\n" +
                "Take%s down and pass around, no more bottles of beer on the wall.\n" +
                "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n", counter, counter == 1 ? " bottle" : " bottles", counter, counter == 1 ? " bottle" : " bottles", getNumberWord(counter)));

        return builder.toString();
    }

    private static String getWordNumber(int number)
    {
        String soFar;

        if(number == 0) return "zero";

        if (number % 100 < 20){
            soFar = numNames[number % 100];
            number /= 100;
        }
        else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " hundred" + soFar;
    }
    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };
}
