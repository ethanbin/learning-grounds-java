package com.example.EthansPlayground.katas.gildedRose;

class GildedRoseClaude extends GildedRose {
  public GildedRoseClaude(Item[] items) {
      super(items);
  }

  public void updateQuality() {
    for (Item item : items) {
      switch (item.name) {
        case "Sulfuras, Hand of Ragnaros" -> {}
        case "Aged Brie" -> updateAgedBrie(item);
        case "Backstage passes to a TAFKAL80ETC concert" -> updateBackstagePass(item);
        default -> updateNormalItem(item);
      }
    }
  }

  private void updateNormalItem(Item item) {
    decreaseQuality(item, 1);
    item.sellIn--;
    if (item.sellIn < 0) {
      decreaseQuality(item, 1);
    }
  }

  private void updateAgedBrie(Item item) {
    increaseQuality(item, 1);
    item.sellIn--;
    if (item.sellIn < 0) {
      increaseQuality(item, 1);
    }
  }

  private void updateBackstagePass(Item item) {
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

  private void increaseQuality(Item item, int amount) {
    item.quality = Math.min(50, item.quality + amount);
  }

  private void decreaseQuality(Item item, int amount) {
    item.quality = Math.max(0, item.quality - amount);
  }
}
