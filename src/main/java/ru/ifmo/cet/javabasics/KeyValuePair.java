package ru.ifmo.cet.javabasics;

class KeyValuePair implements Comparable<KeyValuePair>{
    private String key;
    private int value;

    KeyValuePair(int value, String key) {
        super();
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public int compareTo(KeyValuePair other) {
        if(value != other.value) {
            return other.value - value;
        }
        else {
            return key.compareTo(other.key);
        }
    }
}
