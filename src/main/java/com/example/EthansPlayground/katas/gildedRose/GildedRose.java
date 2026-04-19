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
      thing(item);

      if (item.name.equals(SPECIAL_SULFURAS)) {
        continue;
      }

      if (item.name.equals(SPECIAL_AGED_BRIE)) {
        if (item.quality < 50) {
          item.quality++;
        }

        item.sellIn--;

        if (item.sellIn < 0) {
          if (item.quality < 50) {
            item.quality++;
          }
        }

        continue;
      }


      if (item.name.equals(SPECIAL_AGED_BRIE)
        || item.name.equals(SPECIAL_BACKSTAGE_PASS)) {
        if (item.quality < 50) {
          item.quality++;

          if (item.name.equals(SPECIAL_BACKSTAGE_PASS)) {
            if (item.sellIn < 11) {
              if (item.quality < 50) {
                item.quality++;
              }
            }

            if (item.sellIn < 6) {
              if (item.quality < 50) {
                item.quality++;
              }
            }
          }
        }
        item.sellIn--;
      }

      if (item.sellIn < 0) {
        if (item.name.equals(SPECIAL_BACKSTAGE_PASS)) {
          item.quality = 0;
        } else if (item.name.equals(SPECIAL_AGED_BRIE)) {
          if (item.quality < 50) {
            item.quality++;
          }
        }
      }
    }
  }

  private void thing(Item item) {
    switch (item.name) {
      case SPECIAL_SULFURAS:
        break;
      case SPECIAL_AGED_BRIE:
        break;
      case SPECIAL_BACKSTAGE_PASS:
        break;
      default:
        int depreciateBy = item.sellIn > 0 ? 1 : 2;
        item.quality -= depreciateBy;
        item.quality = Math.max(0, item.quality);
        item.sellIn--;
        break;
    }
  }
}
