package ru.ifmo.cet.javabasics;


public class BottleSong {

    int bottleTakenAtOnce;

    public BottleSong(int bottleTakenAtOnce) {
        this.bottleTakenAtOnce = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
         String a = "";
         int bottles = 99;
         if (bottleTakenAtOnce <= 99){
             while (bottles - bottleTakenAtOnce > 0){
                    a += bottles + " bottles of beer on the wall, " + bottles +" bottles of beer\nTake one down, pass it around, " + (bottles - bottleTakenAtOnce) +" bottles of beer\n";  
                    bottles -= bottleTakenAtOnce;  
             }
             if( bottles != 1)
                 a += bottles + " bottles of beer on the wall, "+bottles + " bottles of beer\n";
             else
                 a += bottles + " bottle of beer on the wall, "+bottles + " bottle of beer\n";
             a += "Take one down, pass it around, no more bottles of beer on the wall\nNo more bottles of beer on the wall, no more bottles of beer\nGo to the store and buy some more, 99 bottles of beer on the wall";
             return a;      
         }
         throw new UnsupportedOperationException();
    }

}
