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

    private int delta;
    private StringBuilder resultSong = new StringBuilder();

    public BottleSong(int bottleTakenAtOnce) {
        delta = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        return Generate(99) + "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.";
    }

    StringBuilder tempBuilder = new StringBuilder();
    private String Generate(int temp){
        tempBuilder.setLength(0);
        tempBuilder.append(temp).append(" ").append(PluralCheck("bottle", "bottles", temp)).append(" of beer on the wall, ").append(PluralCheck("bottle", "bottles", temp)).append(" of beer.\nTake ");

        temp -= delta;

        if (temp > 0){
            tempBuilder.append(NumberToWord(delta)).append(" down and pass around, ").append(temp).append(" ").append(PluralCheck("bottle", "bottles", temp)).append(" of beer on the wall.\n");
            resultSong.append(tempBuilder);
            return Generate(temp);
        }

        if (temp == 0){
            tempBuilder.append(NumberToWord(delta));
        }else{
            tempBuilder.append(NumberToWord(temp+delta));
        }

        tempBuilder.append(" down and pass around, no more bottles of beer on the wall.\n");

        resultSong.append(tempBuilder);

        return resultSong.toString();
    }

    private static final String[] zeroToNine = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] elevenToNineteen = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    private static final String[] tenToNinety = {"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

    private String PluralCheck(String baseValue, String pluralValue, int ammount){
        if (ammount > 1){
            return pluralValue;
        }

        return baseValue;
    }

    private String NumberToWord(int number){
        if (number <= 0){
            return "";
        }

        if (number < 10){
            return zeroToNine[number-1];
        }

        if (number < 20){
            return elevenToNineteen[number-1];
        }

        int decimalPart = (number / 10);
        int anotherPart = number % 10;

        if (anotherPart == 0){
            return tenToNinety[decimalPart-1];
        }

        return tenToNinety[decimalPart-1] + " " + zeroToNine[anotherPart-1];
    }
}
