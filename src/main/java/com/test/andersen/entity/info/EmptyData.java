package com.test.andersen.entity.info;

public class EmptyData {
    private double emptyWeight;
    private double length;

    public EmptyData() {
    }

    public EmptyData(double emptyWeight, double length) {
        if (emptyWeight < 0d)
            throw new IllegalArgumentException("Invalid parameter for weight");

        if (length < 0d)
            throw new IllegalArgumentException("Invalid parameter for length");

        this.emptyWeight = emptyWeight;
        this.length = length;
    }

    public double getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(double emptyWeight) {
        if (emptyWeight < 0d)
            throw new IllegalArgumentException("Invalid parameter for weight");

        this.emptyWeight = emptyWeight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length < 0d)
            throw new IllegalArgumentException("Invalid parameter for length");

        this.length = length;
    }
}
