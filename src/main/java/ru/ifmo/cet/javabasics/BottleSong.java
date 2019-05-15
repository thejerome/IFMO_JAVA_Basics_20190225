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

    private int bt;
    public BottleSong(int bottleTakenAtOnce) {
        //TODO
        this.bt = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        //TODO
        if ((this.bt < 100) & (this.bt > 0))
        {
            StringBuilder final1 = new StringBuilder();
            Integer bottles = 99;
            Integer tmpBottles;
            String strbtao = getBottle(this.bt);
            while (bottles > this.bt) {
                tmpBottles = bottles - this.bt;
                if (tmpBottles>1) {
                    final1.append(bottles.toString()).append(" bottles of beer on the wall, ").append(bottles.toString()).append(" bottles of beer.\n").append("Take ").append(strbtao).append("down and pass around, ").append(tmpBottles.toString()).append(" bottles of beer on the wall.\n");
                }
                else{
                    final1.append(bottles.toString()).append(" bottles of beer on the wall, ").append(bottles.toString()).append(" bottles of beer.\n").append("Take ").append(strbtao).append("down and pass around, ").append(tmpBottles.toString()).append(" bottle of beer on the wall.\n");
                }
                bottles = tmpBottles;
            }
            if ( bottles > 1) {
                final1.append(bottles.toString()).append(" bottles of beer on the wall, ").append(bottles.toString()).append(" bottles of beer.\n").append("Take ").append(getBottle(bottles)).append("down and pass around, no more bottles of beer on the wall.\n").append("No more bottles of beer on the wall, no more bottles of beer.\n").append("Go to the store and buy some more, 99 bottles of beer on the wall.\n");
            }
            else{
                final1.append(bottles.toString()).append(" bottle of beer on the wall, ").append(bottles.toString()).append(" bottle of beer.\n").append("Take ").append(getBottle(bottles)).append("down and pass around, no more bottles of beer on the wall.\n").append("No more bottles of beer on the wall, no more bottles of beer.\n").append("Go to the store and buy some more, 99 bottles of beer on the wall.\n");
            }
            return final1.toString();
        }
        else {
            throw new IllegalArgumentException();
        }
    }
    private String getBottle(int number){
        String str;
        if(number < 20) {
            switch (number) {
                default: str = "Error ";
                    break;
                case 1: str = "one ";
                    break;
                case 2: str = "two ";
                    break;
                case 3: str = "three ";
                    break;
                case 4: str = "four ";
                    break;
                case 5: str = "five ";
                    break;
                case 6: str = "six ";
                    break;
                case 7: str = "seven ";
                    break;
                case 8: str = "eight ";
                    break;
                case 9: str = "nine ";
                    break;
                case 10: str = "ten ";
                    break;
                case 11: str = "eleven ";
                    break;
                case 12: str = "twelve ";
                    break;
                case 13: str = "thirteen ";
                    break;
                case 14: str = "fourteen ";
                    break;
                case 15: str = "fifteen ";
                    break;
                case 16: str = "sixteen ";
                    break;
                case 17: str = "seventeen ";
                    break;
                case 18: str = "eighteen ";
                    break;
                case 19: str = "nineteen ";
                    break;
            }
        }
        else{
            switch (number / 10) {
                default: str = "Error ";
                    break;
                case 2: str = "twenty ";
                    break;
                case 3: str = "thirty ";
                    break;
                case 4: str = "forty ";
                    break;
                case 5: str = "fifty ";
                    break;
                case 6: str = "sixty ";
                    break;
                case 7: str = "seventy ";
                    break;
                case 8: str = "eighty ";
                    break;
                case 9: str = "ninety ";
                    break;
            }
            switch (number % 10) {
                default: str = "Error ";
                    break;
                case 0: str += "";
                    break;
                case 1: str += "one ";
                    break;
                case 2: str += "two ";
                    break;
                case 3: str += "three ";
                    break;
                case 4: str += "four ";
                    break;
                case 5: str += "five ";
                    break;
                case 6: str += "six ";
                    break;
                case 7: str += "seven ";
                    break;
                case 8: str += "eight ";
                    break;
                case 9: str += "nine ";
                    break;
            }
        }
        return str;
    }
}
