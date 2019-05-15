package ru.ifmo.cet.javabasics;

enum NumberToWord {
    zero, one, two, three, four, five, six, seven, eight, nine, ten,
    eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen,
    twenty, thirty, forty, fifty, sixty, seventy, eighty, ninety;

    private static String convertWithoutSpaces(int number) {
        if (number == 0) {
            return "";
        }
        if (number < 20) {
            return NumberToWord.values()[number].toString();
        }
        else {
            return NumberToWord.values()[number / 10 + 18].toString() + " " + convertWithoutSpaces(number % 10);
        }
    }

    static String convert(int number) {
        String numberInWords = convertWithoutSpaces(number);
        int spacePosition = numberInWords.lastIndexOf(" ");
        if (spacePosition == numberInWords.length()-1) {
            numberInWords = numberInWords.substring(0, numberInWords.length()-1);
        }
        return numberInWords;
    }
}
