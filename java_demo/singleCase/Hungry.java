package com.framework.singleCase;

public class Hungry {

    public int count = 1;
    private final static Hungry hungry = new Hungry();

    private Hungry() {

    }

    public Hungry Instance() {
        return hungry;
    }
}
