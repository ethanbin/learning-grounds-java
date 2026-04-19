package com.example.EthansPlayground.katas.gildedRose;

public class GildedRose2 extends GildedRose {
    private final static String AGED_BRIE = "Aged Brie";
    private final static String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private final static String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public GildedRose2(Item[] items) {
        super(items);
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case SULFURAS -> {
                }
                case AGED_BRIE -> processBrie(item);
                case BACKSTAGE_PASS -> processPass(item);
                default -> processNormalItem(item);
            }
        }
    }

    private void processNormalItem(Item item) {
        item.sellIn--;
        decreaseQuality(item, item.sellIn < 0 ? 2 : 1);
    }

    private void processPass(Item item) {
        if (item.sellIn < 6) {
            increaseQuality(item, 3);
        } else if (item.sellIn < 11) {
            increaseQuality(item, 2);
        } else {
            increaseQuality(item, 1);
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void processBrie(Item item) {
        item.sellIn--;
        increaseQuality(item, item.sellIn < 0 ? 2 : 1);
    }

    private void increaseQuality(Item item, int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }

    private void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }
}
