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
class BottleSong
{
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
    private final int bottleTakenAtOnce;

    public BottleSong(int bottleTakenAtOnce)
    {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics()
    {
        String a = ff.values()[0].name();
        if(bottleTakenAtOnce < 1 || bottleTakenAtOnce > 99 )
        {
            throw new IllegalArgumentException();
        }

        StringBuilder builder = new StringBuilder();
        int counter;

        for (counter = 99; counter > bottleTakenAtOnce; counter -= bottleTakenAtOnce)
        {
            builder.append(counter)
                    .append(" bottles of beer on the wall, ")
                    .append(counter)
                    .append(" bottles of beer.\nTake")
                    .append(getWordNumber(bottleTakenAtOnce))
                    .append(" down and pass around, ")
                    .append(counter - bottleTakenAtOnce)
                    .append(counter - bottleTakenAtOnce == 1 ? " bottle" : " bottles")
                    .append(" of beer on the wall.\n");
        }
        builder.append(counter)
                .append(counter == 1 ? " bottle" : " bottles")
                .append(" of beer on the wall, ")
                .append(counter)
                .append(counter == 1 ? " bottle" : " bottles")
                .append(" of beer.\nTake")
                .append(getWordNumber(counter))
                .append(" down and pass around, no more bottles of beer on the wall.\nNo more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");

        return builder.toString();
    }

    private static String getWordNumber(int toStringNumber)
    {
        String soFar;

        if (toStringNumber % 100 < 20){
            soFar = numNames[toStringNumber % 100];
            toStringNumber /= 100;
        }
        else {
            soFar = numNames[toStringNumber % 10];
            toStringNumber /= 10;

            soFar = tensNames[toStringNumber % 10] + soFar;
            toStringNumber /= 10;
        }
        if (toStringNumber == 0) return soFar;
        return numNames[toStringNumber] + " hundred" + soFar;
    }

}
enum ff
{
    one,
    two
}
