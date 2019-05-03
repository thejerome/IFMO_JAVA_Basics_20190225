package ru.ifmo.cet.javabasics;
import java.util.HashMap;
import java.util.Map;

public class BottleSong {
    private int bottles = 0;
    public BottleSong(int bottleTakenAtOnce) {
        this.bottles = bottleTakenAtOnce;
    }

    public String getBottleSongLyrics() {
        Map<Integer,String> numbers = new HashMap<>();
        numbers.put(1,"one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        numbers.put(10, "ten");
        numbers.put(11, "eleven");
        numbers.put(12, "twelve");
        numbers.put(13, "thirteen");
        numbers.put(14, "fourteen");
        numbers.put(15, "fifteen");
        numbers.put(16, "sixteen");
        numbers.put(17, "seventeen");
        numbers.put(18, "eighteen");
        numbers.put(19, "nineteen");
        numbers.put(20, "twenty");
        numbers.put(30, "thirty");
        numbers.put(40, "forty");
        numbers.put(50, "fifty");
        numbers.put(60, "sixty");
        numbers.put(70, "seventy");
        numbers.put(80, "eighty");
        numbers.put(90, "ninety");
        String text = "";
        String left_part = "";
        String number_in_word = "";
        String second_number = "";
        if (bottles > 0 && bottles < 100){
            if (bottles < 20){
                number_in_word = numbers.get(bottles);
            }
            else{
                int first_digit = bottles / 10;
                int second_digit = bottles % 10;
                number_in_word = numbers.get(first_digit * 10);
                if (second_digit != 0){
                    number_in_word = number_in_word + " " + numbers.get(second_digit);
                }
            }
            if (99 % bottles < 20){
                second_number = numbers.get(99 % bottles);
            }
            else {
                int first_digit = 99 % bottles / 10;
                int second_digit = 99 % bottles % 10;
                second_number = numbers.get(first_digit * 10);
                if (second_digit != 0){
                    second_number = second_number + " " + numbers.get(second_digit);
                }
            }
            for (int i = 99; i > 0; i -= bottles){
                left_part = Integer.toString(i);
                if (i == 1){
                    text = text + "1 bottle of beer on the wall, 1 bottle of beer.\n" + "Take one down and pass around, no more bottles of beer on the wall.\n";
                }
                else if (i < bottles){
                    text = text + left_part + " bottles of beer on the wall," + " " + left_part + " bottles of beer.\n" +
                            "Take " + second_number + " down and pass around, no more bottles of beer on the wall.\n";

                }
                else if (i == bottles){
                    text = text + left_part + " bottles of beer on the wall, " + left_part + " bottles of beer.\n"
                            + "Take " + number_in_word + " down and pass around, no more bottles of beer on the wall.\n";
                }
                else{
                    text = text + left_part + " bottles of beer on the wall, " +
                            left_part + " bottles of beer.\n";
                    if (i - bottles == 1){
                        text = text + "Take " + number_in_word + " down and pass around, " +
                                Integer.toString(i - bottles) + " bottle of beer on the wall.\n";
                    }
                    else{
                        text = text + "Take " + number_in_word + " down and pass around, " +
                                Integer.toString(i - bottles) + " bottles of beer on the wall.\n";
                    }
                }
                text = text;
            }
        }
        else {
            throw new java.lang.IllegalArgumentException();
        }

        return text + "No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.\n";
    }

}
