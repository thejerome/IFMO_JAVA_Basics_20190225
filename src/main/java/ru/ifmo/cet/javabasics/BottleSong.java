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
    private int bottleTaken = 0;

    public BottleSong(int bottleTakenAtOnce) {
        //TODO
        if (bottleTakenAtOnce <= 99){
            bottleTaken = bottleTakenAtOnce;
        }
    }

    public String getBottleSongLyrics() {
        //TODO
        if (bottleTaken > 99 || bottleTaken < 1){
            throw new IllegalArgumentException();
        }
        int bottles = 99;
        StringBuilder ans = new StringBuilder();
        while (bottles > 0){
            ans.append(bottles);
            if (bottles != 1) ans.append(" bottles of beer on the wall, ");
            else ans.append(" bottle of beer on the wall, ");
            ans.append(bottles);
            if (bottles != 1) ans.append(" bottles of beer.\n");
            else ans.append(" bottle of beer.\n");
            ans.append("Take ");
            //==============================
            int nowWeTake = 0;
            if (bottles > bottleTaken){
                nowWeTake = bottleTaken;
            }else{
                nowWeTake = bottles;
            }
            if (nowWeTake > 10 && nowWeTake < 20){
                if (nowWeTake == 11) ans.append("eleven");
                else if (nowWeTake == 12) ans.append("twelve");
                else if (nowWeTake == 13) ans.append("thirteen");
                else if (nowWeTake == 14) ans.append("fourteen");
                else if (nowWeTake == 15) ans.append("fifteen");
                else if (nowWeTake == 16) ans.append("sixteen");
                else if (nowWeTake == 17) ans.append("seventeen");
                else if (nowWeTake == 18) ans.append("eighteen");
                else ans.append("nineteen");
            }else {
                if (nowWeTake / 10 == 1) ans.append("ten");
                else if (nowWeTake / 10 == 2) ans.append("twenty");
                else if (nowWeTake / 10 == 3) ans.append("thirty");
                else if (nowWeTake / 10 == 4) ans.append("forty");
                else if (nowWeTake / 10 == 5) ans.append("fifty");
                else if (nowWeTake / 10 == 6) ans.append("sixty");
                else if (nowWeTake / 10 == 7) ans.append("seventy");
                else if (nowWeTake / 10 == 8) ans.append("eighty");
                else if (nowWeTake / 10 == 9) ans.append("ninety");
                if (nowWeTake / 10 != 0 && nowWeTake % 10 != 0) ans.append(" ");
                if (nowWeTake % 10 == 1) ans.append("one");
                else if (nowWeTake % 10 == 2) ans.append("two");
                else if (nowWeTake % 10 == 3) ans.append("three");
                else if (nowWeTake % 10 == 4) ans.append("four");
                else if (nowWeTake % 10 == 5) ans.append("five");
                else if (nowWeTake % 10 == 6) ans.append("six");
                else if (nowWeTake % 10 == 7) ans.append("seven");
                else if (nowWeTake % 10 == 8) ans.append("eight");
                else if (nowWeTake % 10 == 9) ans.append("nine");
            }
            //==============================
            ans.append(" down and pass around, ");
            bottles -= nowWeTake;
            if (bottles != 0) {
                ans.append(bottles);
                if (bottles != 1) ans.append(" bottles of beer on the wall.\n");
                else ans.append(" bottle of beer on the wall.\n");
            }else{
                ans.append("no more bottles of beer on the wall.\n");
            }
        }
        ans.append("No more bottles of beer on the wall, no more bottles of beer.\n");
        ans.append("Go to the store and buy some more, 99 bottles of beer on the wall.\n");
        return ans.toString();
    }
}
