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
    int portion;

    public BottleSong(int bottleTakenAtOnce) {
        portion = bottleTakenAtOnce;
        if (bottleTakenAtOnce <= 0 || bottleTakenAtOnce > 99) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                portion = 0;
                //System.out.println("no Songs");
            }
        }
    }

    public String getBottleSongLyrics() {
        int beerNum = portion;
        String song = null;
        if (beerNum != 0) {
            song = "99 bottles of beer on the wall, 99 bottles of beer.\n";
            while (beerNum > 0) {
                if (beerNum >= portion) {
                    beerNum = beerNum - portion;
                } else {
                    portion = beerNum % portion;
                    beerNum = 0;
                }
                Translator i2s = new Translator(portion);
                String number = i2s.num2str(true);
                song = song + "Take " + number + " down and pass around, ";
                if (beerNum > 0) {
                    song = song + beerNum + " bottles of beer on the wall.\n";
                } else {
                    song = song + " no more bottles of beer on the wall.\n" +
                            "No more bottles of beer on the wall, no more bottles of beer.\n" +
                            "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
                }
            }
        }
        return song;
    }
}
