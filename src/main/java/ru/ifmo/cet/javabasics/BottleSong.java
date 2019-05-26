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

    private static final String[] zeroToNine = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] tenToNineteen = {"ten", "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    private static final String[] twentyToNinety = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

    private int delta;
    private StringBuilder resultSong = new StringBuilder();
    private StringBuilder tempBuilder = new StringBuilder();

    public BottleSong(int bottleTakenAtOnce) {
        delta = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        if (delta > 99 || delta <= 0){
            throw new IllegalArgumentException();
        }

        generate(99);

        resultSong.append("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");

        return resultSong.toString();
    }

    private void generate(int startValue){
        int temp = startValue;

        tempBuilder.setLength(0);
        tempBuilder.append(temp).append(" ").append(pluralCheck("bottle", "bottles", temp)).append(" of beer on the wall, ").append(temp).append(" ").append(pluralCheck("bottle", "bottles", temp)).append(" of beer.\nTake ");

        temp -= delta;

        if (temp > 0){
            tempBuilder.append(numberToWord(delta)).append(" down and pass around, ").append(temp).append(" ").append(pluralCheck("bottle", "bottles", temp)).append(" of beer on the wall.\n");
            resultSong.append(tempBuilder);
            generate(temp);
            return;
        }

        if (temp == 0){
            tempBuilder.append(numberToWord(delta));
        }else{
            tempBuilder.append(numberToWord(temp+delta));
        }

        tempBuilder.append(" down and pass around, no more bottles of beer on the wall.\n");

        resultSong.append(tempBuilder);
    }

    private String pluralCheck(String baseValue, String pluralValue, int ammount){
        if (ammount > 1){
            return pluralValue;
        }

        return baseValue;
    }

    private String numberToWord(int number){
        if (number <= 0){
            return "";
        }

        if (number < 10){
            return zeroToNine[number-1];
        }

        if (number < 20){
            return tenToNineteen[number-10];
        }

        int decimalPart = (number / 10);
        int anotherPart = number % 10;

        if (anotherPart == 0){
            return twentyToNinety[decimalPart-2];
        }

        return twentyToNinety[decimalPart-2] + " " + zeroToNine[anotherPart-1];
    }
}
