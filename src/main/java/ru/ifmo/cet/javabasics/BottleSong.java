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
 *
 * <p>1 bottle of beer on the wall, 1 bottle of beer
 *  * Take one down, pass it around, no more bottles of beer on the wall
 *  * No more bottles of beer on the wall, no more bottles of beer
 *  * Go to the store and buy some more, 99 bottles of beer on the wall
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
public class BottleSong {

    private int bottlesTakenAtOnce;
    private static final String[] UNITS = {"", "one",  "two",   "three",  "four",  "five",  "six",   "seven",   "eight",  "nine"};
    private static final String[] TENS  = {"", "ten" , "twenty","thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] TEENS = {"eleven", "twelve", "thirteen", "fourteen","fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}; // <-_->

    public BottleSong(int bottleTakenAtOnce) {
        this.bottlesTakenAtOnce = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {

        StringBuilder res = new StringBuilder();

        if(bottlesTakenAtOnce <= 0 || bottlesTakenAtOnce > 99)
            throw new IllegalArgumentException();
        else {

            String btaoStr = numToWords(bottlesTakenAtOnce);
            String part;
            String line1;
            String line2;

            for(int bottles = 99; bottles > 0;) {
                    part = bottles + ((bottles == 1) ? " bottle" : " bottles") + " of beer";

                    line1 = part + " on the wall, " + part + ".";

                    if(bottles < bottlesTakenAtOnce) {
                        bottlesTakenAtOnce = bottles;
                        btaoStr  = numToWords(bottlesTakenAtOnce);
                    }

                    bottles -= bottlesTakenAtOnce;

                    line2 = "Take " + btaoStr + " down and pass around, "
                            + (bottles != 0 ? bottles   : "no more" )
                            + (bottles == 1 ? " bottle" : " bottles")
                            + " of beer on the wall.\n";

                    res.append(line1 + "\n" + line2);
            }

            res.append("No more bottles of beer on the wall, no more bottles of beer.\n" +
                       "Go to the store and buy some more, 99 bottles of beer on the wall.\n");
        }

        return res.toString();
    }

    private String numToWords(int num) {
        if     (num == 0)      return "no more";
        if     (num < 10)      return UNITS[num % 10];
        else if(num % 10 == 0) return TENS [num / 10];
        else if(num < 20)      return TEENS[(num-1) % 10];
        else                   return TENS [num / 10] + " " + UNITS[num % 10];
    }
}
