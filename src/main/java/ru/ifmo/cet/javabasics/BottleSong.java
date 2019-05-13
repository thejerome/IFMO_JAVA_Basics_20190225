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
    public BottleSong(int bottleTakenAtOnce) {
        //TODO
        step = bottleTakenAtOnce;
    }
    final private int step;

    public String getBottleSongLyrics() {
        //TODO
        //throw new UnsupportedOperationException();
        if ((step <= 0) || (step > 99)){
            throw new  IllegalArgumentException();
        }
        int count = 99;
        StringBuilder result = new StringBuilder("");
        String decrement = GetWordsNumber(step);
        while (count - this.step > 0 ){
            result.append(String.valueOf(count) + " " + GetCorrectForm(count)+ " of beer on the wall, " + String.valueOf(count) + " " + GetCorrectForm(count) + " of beer." + '\n');
            count -= step;
            result.append("Take " + decrement + " down and pass around, " + String.valueOf(count) + " " + GetCorrectForm(count) +" of beer on the wall." + '\n');
        }

        result.append(String.valueOf(count) + " " + GetCorrectForm(count) + " of beer on the wall, " + String.valueOf(count) + " " + GetCorrectForm(count) + " of beer." + '\n');
        result.append("Take " + GetWordsNumber(count) + " down and pass around, no more bottles of beer on the wall."+ '\n');
        result.append("No more bottles of beer on the wall, no more bottles of beer."+ '\n');
        result.append("Go to the store and buy some more, 99 bottles of beer on the wall." + '\n');
        return result.toString();

    }
    public String GetWordsNumber(int number){
        String [] tens = {"","ten", "twenty","thirty", "forty",
                "fifty", "sixty", "seventy", "eighty", "ninety"};
        String [] units = {"","one", "two","three", "four",
                "five", "six", "seven", "eight", "nine"};
        String []Between10and20 = {"", "eleven","twelve", "thirteen","fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen"};
        if (number % 10 == 0) {
            return tens[number/10];
        }
        if ((number > 10) && (number < 20)){
            return Between10and20[number % 10];
        }
        if (number < 10){
            return units[number];
        }
        return tens[number / 10] + ' ' + units[number % 10];
    }

    private String GetCorrectForm(int amount){
        return amount == 1 ? "bottle":"bottles";
    }

}
