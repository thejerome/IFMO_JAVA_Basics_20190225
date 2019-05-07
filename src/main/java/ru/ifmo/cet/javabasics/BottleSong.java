package ru.ifmo.cet.javabasics;


public class BottleSong {

  int bottleTakenAtOnce;

  public BottleSong(int bottleTakenAtOnce) {
    // TODO
    this.bottleTakenAtOnce = bottleTakenAtOnce;
  }

  public String getBottleSongLyrics() {
    // TODO
    // throw new UnsupportedOperationException();

    Map<Integer, String> map = new HashMap<Integer, String>();

    map.put(0, "no more");
    map.put(1, "one");
    map.put(2, "two");
    map.put(3, "three");
    map.put(4, "four");
    map.put(5, "five");
    map.put(6, "six");
    map.put(7, "seven");
    map.put(8, "eight");
    map.put(9, "nine");
    map.put(10, "ten");
    map.put(11, "eleven");
    map.put(12, "twelve");
    map.put(13, "thirteen");
    map.put(14, "fourteen");
    map.put(15, "fifteen");
    map.put(16, "sixteen");
    map.put(17, "seventeen");
    map.put(18, "eighteen");
    map.put(19, "nineteen");
    map.put(20, "twenty");
    map.put(30, "thirty");
    map.put(40, "forty");
    map.put(50, "fifty");
    map.put(60, "sixty");
    map.put(70, "seventy");
    map.put(80, "eighty");
    map.put(90, "ninety");

    String a = "";
    int bottles = 99;
    if (bottleTakenAtOnce <= 99 && bottleTakenAtOnce >= 1) {
      int c = bottles % bottleTakenAtOnce;
      while (bottles - bottleTakenAtOnce > 0) {
        a += bottles + " bottles of beer on the wall, " + bottles + " bottles of beer\nTake ";
        String number = "";
        if (map.get(bottleTakenAtOnce) != null){
          number = map.get(bottleTakenAtOnce);
        } else {
          number = map.get(bottleTakenAtOnce - bottleTakenAtOnce%10) + map.get(bottleTakenAtOnce%10);
        }
        a += number + " down, pass it around, " + (bottles - bottleTakenAtOnce) + " bottles of beer\n";
        bottles -= bottleTakenAtOnce;
      }


      if (bottles != 1)
        a += bottles + " bottles of beer on the wall, " + bottles + " bottles of beer\n";
      else
        a += bottles + " bottle of beer on the wall, " + bottles + " bottle of beer\n";

      a += "Take ";

      String number = "";
        if (map.get(bottles) != null){
          number = map.get(bottles);
        } else {
          number = map.get(bottles - bottles%10) + map.get(bottles%10);
        }
        a += number + " down, pass it around, no more bottles of beer on the wall\n";

      a += "No more bottles of beer on the wall, no more bottles of beer\nGo to the store and buy some more, 99 bottles of beer on the wall";
      return a;
    } else
      throw new IllegalArgumentException();

  }


}
