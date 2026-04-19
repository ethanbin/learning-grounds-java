package com.example.EthansPlayground.katas.gildedRose;

public abstract class GildedRose {
    protected final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public abstract void updateQuality();
}
