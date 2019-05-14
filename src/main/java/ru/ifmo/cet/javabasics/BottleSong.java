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
    private  int bottleTakenAtOnce;
    private int bottles=99;
    private String txt="";
    private static  String[][] Numbers={
            {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"},
            {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}};

    private String words(int n){
        if(n <=19)
            return Numbers[1][n];
        else if (n % 10 == 0)
            return Numbers[0][n/10];
        else
            return Numbers[0][n/10]+" "+Numbers[1][n%10];
    }

    public BottleSong(int bottleTakenAtOnce) {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        if (bottleTakenAtOnce >=1 && bottleTakenAtOnce <=99) {
            while (bottles - bottleTakenAtOnce > 0) {
                txt += bottles + " bottles of beer on the wall, " + bottles + " bottles of beer.\n";
                if (bottles - bottleTakenAtOnce != 1)
                    txt += "Take "+ words(bottleTakenAtOnce) + " down and pass around, " + (bottles - bottleTakenAtOnce) + " bottles of beer on the wall.\n";
                else
                    txt += "Take "+ words(bottleTakenAtOnce) + " down and pass around, " + (bottles - bottleTakenAtOnce) + " bottle of beer on the wall.\n";
                bottles -= bottleTakenAtOnce;}

            if (bottles != 1)
                txt += bottles + " bottles of beer on the wall, " + bottles + " bottles of beer.\n";
            else{
                txt += bottles + " bottle of beer on the wall, " + bottles + " bottle of beer.\n";}

            if(bottleTakenAtOnce> bottles){
                bottleTakenAtOnce=bottles;}

            txt += "Take " + words(bottleTakenAtOnce) + " down and pass around, no more bottles of beer on the wall.\n";

            txt += "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n";
            return txt;}
        else throw new IllegalArgumentException();}
}
