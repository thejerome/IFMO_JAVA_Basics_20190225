package ru.ifmo.cet.javabasics;

public class BottleSong {

    private int bottleTakenAtOnce;
    private int currentBottles = 99;

    public BottleSong(int bottleTakenAtOnce) {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        if (bottleTakenAtOnce < 1 || bottleTakenAtOnce > 99) {
            throw new IllegalArgumentException();
        }
        else {
            StringBuilder song = new StringBuilder();
            while (currentBottles > bottleTakenAtOnce) {
                song.append(currentBottles)
                    .append(" bottles of beer on the wall, ")
                    .append(currentBottles)
                    .append(" bottles of beer.\n");
                song.append("Take ")
                    .append(NumberToWord.convert(bottleTakenAtOnce))
                    .append(" down and pass around, ")
                    .append(currentBottles -= bottleTakenAtOnce)
                    .append(" bottles of beer on the wall.\n");
            }
            if (currentBottles == 1) {
                song.deleteCharAt(song.lastIndexOf("s"));
                song.append(currentBottles)
                    .append(" bottle of beer on the wall, ")
                    .append(currentBottles)
                    .append(" bottle of beer.\n");
            }
            else {
                song.append(currentBottles)
                    .append(" bottles of beer on the wall, ")
                    .append(currentBottles)
                    .append(" bottles of beer.\n");
            }
            song.append("Take ")
                .append(NumberToWord.convert(currentBottles))
                .append(" down and pass around, no more bottles of beer on the wall.\n")
                .append("No more bottles of beer on the wall, no more bottles of beer.\n")
                .append("Go to the store and buy some more, 99 bottles of beer on the wall.\n");
            return song.toString();
        }
    }
}