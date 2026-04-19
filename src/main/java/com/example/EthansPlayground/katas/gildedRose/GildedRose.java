package com.example.EthansPlayground.katas.gildedRose;

class GildedRose {
    private final static String SPECIAL_SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final static String SPECIAL_AGED_BRIE = "Aged Brie";
    private final static String SPECIAL_BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            processItem(item);
        }
    }

    private void processItem(Item item) {
        switch (item.name) {
            case SPECIAL_SULFURAS:
                return;
            case SPECIAL_AGED_BRIE:
                processAgedItem(item);
                break;
            case SPECIAL_BACKSTAGE_PASS:
                processBackstagePass(item);
                break;
            default:
                processDefaultItem(item);
                break;
        }
    }

    private void processDefaultItem(Item item) {
        int depreciateBy = item.sellIn > 0 ? 1 : 2;
        item.quality -= depreciateBy;
        item.quality = Math.max(0, item.quality);
        item.sellIn--;
    }

    private void processAgedItem(Item item) {
        item.sellIn--;
        int appreciateBy = item.sellIn >= 0 ? 1 : 2;
        item.quality += appreciateBy;
        item.quality = Math.min(50, item.quality);
    }

    private void processBackstagePass(Item item) {
        int appreciateBy;

        if (item.sellIn <= 5) {
            appreciateBy = 3;
        } else if (item.sellIn <= 10) {
            appreciateBy = 2;
        } else {
            appreciateBy = 1;
        }

        item.quality += appreciateBy;
        item.quality = Math.min(50, item.quality);

        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
