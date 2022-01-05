package com.example.limitsservice;

public class LimitConfig {
    private int maximum;
    private int minimum;

    public LimitConfig() {
    }

    public LimitConfig(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public int getMinimum() {
        return minimum;
    }
}
