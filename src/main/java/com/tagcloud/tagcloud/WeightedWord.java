package com.tagcloud.tagcloud;

public class WeightedWord {

    private final String word;
    private final double weight;

    public WeightedWord(String word, double weight) {
        this.word = word;
        this.weight = weight;
    }

    public String getWord() {
        return word;
    }

    public double getWeight() {
        return weight;
    }
}
