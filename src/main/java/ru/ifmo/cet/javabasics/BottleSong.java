package ru.ifmo.cet.javabasics;

public class BottleSong {

    private int bottleTakenAtOnce;
    private int currentBottles = 99;

    public BottleSong(int bottleTakenAtOnce) {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
    }

    private StringBuilder intToStringBuilder(int number) {
        if (number < 20) {
            switch (number) {
                case 1:
                    return new StringBuilder(" one");
                case 2:
                    return new StringBuilder(" two");
                case 3:
                    return new StringBuilder(" three");
                case 4:
                    return new StringBuilder(" four");
                case 5:
                    return new StringBuilder(" five");
                case 6:
                    return new StringBuilder(" six");
                case 7:
                    return new StringBuilder(" seven");
                case 8:
                    return new StringBuilder(" eight");
                case 9:
                    return new StringBuilder(" nine");
                case 10:
                    return new StringBuilder(" ten");
                case 11:
                    return new StringBuilder(" eleven");
                case 12:
                    return new StringBuilder(" twelve");
                case 13:
                    return new StringBuilder(" thirteen");
                case 14:
                    return new StringBuilder(" fourteen");
                case 15:
                    return new StringBuilder(" fifteen");
                case 16:
                    return new StringBuilder(" sixteen");
                case 17:
                    return new StringBuilder(" seventeen");
                case 18:
                    return new StringBuilder(" eighteen");
                case 19:
                    return new StringBuilder(" nineteen");
                default:
                    return new StringBuilder();
            }
        }
        else {
            switch (number / 10) {
                case 2:
                    return new StringBuilder("twenty").append(intToStringBuilder(number % 10));
                case 3:
                    return new StringBuilder("thirty").append(intToStringBuilder(number % 10));
                case 4:
                    return new StringBuilder("forty").append(intToStringBuilder(number % 10));
                case 5:
                    return new StringBuilder("fifty").append(intToStringBuilder(number % 10));
                case 6:
                    return new StringBuilder("sixty").append(intToStringBuilder(number % 10));
                case 7:
                    return new StringBuilder("seventy").append(intToStringBuilder(number % 10));
                case 8:
                    return new StringBuilder("eighty").append(intToStringBuilder(number % 10));
                case 9:
                    return new StringBuilder("ninety").append(intToStringBuilder(number % 10));
                default:
                    return new StringBuilder();
            }
        }
    }

    private String intToString(int number) {
        StringBuilder numberInWords = new StringBuilder(intToStringBuilder(number));
        int spaceAtStart = numberInWords.lastIndexOf(" ");
        if (spaceAtStart == 0) {
            numberInWords = numberInWords.deleteCharAt(spaceAtStart);
        }
        return numberInWords.toString();
    }

    public String getBottleSongLyrics() {
        if (bottleTakenAtOnce < 1 || bottleTakenAtOnce > 99) {
            throw new IllegalArgumentException();
        }
        else {
            StringBuilder song = new StringBuilder();
            while (currentBottles > bottleTakenAtOnce) {
                song.append(currentBottles).
                        append(" bottles of beer on the wall, ").
                        append(currentBottles).
                        append(" bottles of beer.\n");
                song.append("Take ").
                        append(intToString(bottleTakenAtOnce)).
                        append(" down and pass around, ").
                        append(currentBottles -= bottleTakenAtOnce).
                        append(" bottles of beer on the wall.\n");
            }
            if (currentBottles == 1) {
                song.deleteCharAt(song.lastIndexOf("s"));
                song.append(currentBottles).
                        append(" bottle of beer on the wall, ").
                        append(currentBottles).
                        append(" bottle of beer.\n");
            }
            else {
                song.append(currentBottles).
                        append(" bottles of beer on the wall, ").
                        append(currentBottles).
                        append(" bottles of beer.\n");
            }
            song.append("Take ").
                    append(intToString(currentBottles)).
                    append(" down and pass around, no more bottles of beer on the wall.\n").
                    append("No more bottles of beer on the wall, no more bottles of beer.\n").
                    append("Go to the store and buy some more, 99 bottles of beer on the wall.\n");
            return song.toString();
        }
    }
}
