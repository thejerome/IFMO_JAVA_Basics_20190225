package ru.ifmo.cet.javabasics;

class KeyValuePair implements Comparable<KeyValuePair> {
    private String key;
    private long value;

    KeyValuePair(long value, String key) {
        super();
        this.key = key;
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + " - " + value + "\n";
    }

    @Override
    public int compareTo(KeyValuePair o) {
        return value != o.value ? (int) (o.value - value) : key.compareTo(o.key);
    }
}
