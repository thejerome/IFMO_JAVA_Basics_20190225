package ru.ifmo.cet.javabasics;

public class BottleSong {

    public String[] song;
    boolean isEVERYONEDEAD = false;
    int  currentStr = 0;
    public String getWord(int numb) {
        String word = "";
        if (numb < 20) {
            switch (numb) {
                case 1:
                    return "one ";
                case 2:
                    return "two ";
                case 3:
                    return "three ";
                case 4:
                    return "four ";
                case 5:
                    return "five ";
                case 6:
                    return "six ";
                case 7:
                    return "seven ";
                case 8:
                    return "eight ";
                case 9:
                    return "nine ";
                case 10:
                    return "ten ";
                case 11:
                    return "eleven ";
                case 12:
                    return "twelve ";
                case 13:
                    return "thirteen ";
                case 14:
                    return "fourteen ";
                case 15:
                    return "fifteen ";
                case 16:
                    return "sixteen ";
                case 17:
                    return "seventeen ";
                case 18:
                    return "eighteen ";
                case 19:
                    return "nineteen ";
            }
        } else {
            String first = "", second = "";
            switch (numb / 10) {
                case 2:
                    first = "twenty ";
                    break;
                case 3:
                    first = "thirty ";
                    break;
                case 4:
                    first = "forty ";
                    break;
                case 5:
                    first = "fifty ";
                    break;
                case 6:
                    first = "sixty ";
                    break;
                case 7:
                    first = "seventy ";
                    break;
                case 8:
                    first = "eighty ";
                    break;
                case 9:
                    first = "ninety ";
                    break;
            }
            switch (numb % 10) {
                case 1:
                    second = "one ";
                    break;
                case 2:
                    second = "two ";
                    break;
                case 3:
                    second = "three ";
                    break;
                case 4:
                    second = "four ";
                    break;
                case 5:
                    second = "five ";
                    break;
                case 6:
                    second = "six ";
                    break;
                case 7:
                    second = "seven ";
                    break;
                case 8:
                    second = "eight ";
                    break;
                case 9:
                    second = "nine ";
                    break;
            }
            return first + second;
        }
        return word;
    }

    public BottleSong(int bottleTakenAtOnce) {
        if (bottleTakenAtOnce > 0 && bottleTakenAtOnce < 100) {
            song = new String[205];
            int have = 99;
            while (have >= bottleTakenAtOnce) {
                if(have != 1) {
                    song[currentStr] = have + " bottles of beer on the wall, " + have + " bottles of beer.";
                }
                else{ song[currentStr] = have + " bottle of beer on the wall, " + have + " bottle of beer.";}
                currentStr++;
                have -= bottleTakenAtOnce;
                if(have != 1) {
                    if( have == 0) {
                        song[currentStr] = "Take " + getWord(bottleTakenAtOnce) + "down and pass around, no more bottles of beer on the wall.";
                    }
                    else {
                        song[currentStr] = "Take " + getWord(bottleTakenAtOnce) + "down and pass around, " + have
                                + " bottles of beer on the wall.";
                    }
                }
                else{ song[currentStr] = "Take " + getWord(bottleTakenAtOnce) + "down and pass around, " + have
                        + " bottle of beer on the wall.";}
                currentStr++;
            }
            if(have >0){
                if(have == 1){
                    song[currentStr] = "1 bottle of beer on the wall, 1 bottle of beer.";
                    currentStr++;
                    song[currentStr] = "Take one down and pass around, no more bottles of beer on the wall.";
                    currentStr++;
                }
                else {
                    song[currentStr] = have + " bottles of beer on the wall, " + have + " bottles of beer.";
                    currentStr++;
                    song[currentStr] = "Take " + getWord(have) + "down and pass around, no more bottles of beer on the wall.";
                    currentStr++;
                }
            }


            song[currentStr] = "No more bottles of beer on the wall, no more bottles of beer.";
            currentStr++;
            song[currentStr] = "Go to the store and buy some more, 99 bottles of beer on the wall.";
            currentStr++;
        } else {
            isEVERYONEDEAD = true;
        }
    }

    public String getBottleSongLyrics() {
        if(isEVERYONEDEAD)throw new IllegalArgumentException();
        String SONG = "";
        for (int i = 0; i < currentStr; i++) {
            if (song[i] != null)
                SONG += song[i]+"\n";
        }
        return SONG;
    }
}
