package ru.ifmo.cet.javabasics;
class MyClass implements Comparable<MyClass> {
    private int i;
    private String n;
    public MyClass(int i, String n) {
        this.i = i;
        this.n = n;
    }
    @Override
    public int compareTo(MyClass my) {
        if (this == my) {
            return 0;
        }
        if (i != my.i && i > my.i) {
            return (1);
        } else {
            if (i < my.i) {
                return (-1);
            } else {
                return (my.n.compareTo(n));
            }
        }
    }
    public String getWord(){
        return (n);
    }
    public int getFrequence(){
        return (i);
    }
}