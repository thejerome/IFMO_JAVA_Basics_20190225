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
    private static final int originalBottles = 99;

    private static final String[] beforeTen = {
            "no more",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    };
    private static final String[] beforeTwelve = {
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
    private static final String[] beforeNinety = {
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

    private int bottleTakenAtOnce;
    private int chislo = originalBottles;
    private String bottleTakenAtOnceString;
    private StringBuilder resultSong = new StringBuilder();

    public BottleSong(int bottleTakenAtOnce) {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {if(bottleTakenAtOnce<=0 || bottleTakenAtOnce>99) throw new IllegalArgumentException();
    else{
        while(chislo > 0){
            resultSong.append(chislo).append(getBottleString(chislo)).append("of beer on the wall, ").append(chislo).append(getBottleString(chislo)).append("of beer.\n");
            if(bottleTakenAtOnce> chislo){
                bottleTakenAtOnceString = getBottleTakenAtOnceString(chislo);
                chislo = 0;
            }
            else{
                bottleTakenAtOnceString = getBottleTakenAtOnceString(bottleTakenAtOnce);
                chislo = chislo - bottleTakenAtOnce;
            }
            resultSong.append("Take ").append(bottleTakenAtOnceString).append(" down and pass around, ").append(getDbString(chislo)).append(getBottleString(chislo)).append("of beer on the wall.\n");
        }
        resultSong.append("No more bottles of beer on the wall, no more bottles of beer.\n").append("Go to the store and buy some more, 99 bottles of beer on the wall.\n");
        return resultSong.toString();
    }
    }

    private String getBottleTakenAtOnceString(int bottleTakenAtOnce){
        if(bottleTakenAtOnce>=0 && bottleTakenAtOnce<=9){
            return beforeTen[bottleTakenAtOnce];
        }
        else if(bottleTakenAtOnce>=11 && bottleTakenAtOnce<=19){
            return beforeTwelve[bottleTakenAtOnce%11];
        }
        else if(bottleTakenAtOnce % 10 == 0){
            return beforeNinety[bottleTakenAtOnce/10-1];
        }
        else return beforeNinety[bottleTakenAtOnce/10-1] + " " + beforeTen[bottleTakenAtOnce % 10];
    }

    private String getBottleString(int chislo){
        if(chislo == 1) return " bottle ";
        else return " bottles ";
    }

    private String getChisloString(int chislo){
        if(chislo == 0) return "no more";
        else return String.valueOf(chislo);
    }
}