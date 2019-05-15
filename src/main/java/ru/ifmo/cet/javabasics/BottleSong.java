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

    private static String[] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static String[] Twenty = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};


       private int Taken;

    private String toWords(int num)
       {
        if (num <= 19)
            return Twenty[num - 1];
        else if (num % 10 == 0)
            return tens[(num / 10) - 1];
        else
            return tens[(num / 10) - 1] + " " + Twenty[(num % 10) - 1];
       }



    public BottleSong(int bottleTakenAtOnce)
       {
        Taken = bottleTakenAtOnce;
       }


    public String getBottleSongLyrics()

    {
        if (Taken <= 0 || Taken > 99)
           {
            throw new IllegalArgumentException();
           }


        StringBuilder result = new StringBuilder();


        int Count;
        String TEMP = " bottles";

        for (Count = 99; Count > Taken; Count -= Taken) {
            if (Count - Taken == 1) {
                TEMP = " bottle";
            }
            result.append(Count + " bottles of beer on the wall, " + Count + " bottles of beer.\n");
            result.append("Take " + toWords(Taken) + " down and pass around, " + (Count - Taken) + TEMP + " of beer on the wall.\n");
        }

        result.append(Count + TEMP + " of beer on the wall, " + Count + TEMP + " of beer.\n");
        result.append("Take " + toWords(Count) + " down and pass around, no more bottles of beer on the wall.\n");

        result.append("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");

        return result.toString();
    }

}
