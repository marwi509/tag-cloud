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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeightedWord that = (WeightedWord) o;

        return Double.compare(that.weight, weight) == 0 && word.equals(that.word);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = word.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "WeightedWord{" +
                "word='" + word + '\'' +
                ", weight=" + weight +
                '}';
    }
}
