package com.example.EthansPlayground.katas.gildedRose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
  public GildedRose getGildedRose(Item[] items) {
    return new GildedRose2(items);
  }

  @Test
  void testItemUpdatesDownBy1() {
    Item[] items = new Item[] {
      new Item("Vest", 10, 20)
    };

    GildedRose gildedRose = getGildedRose(items);

    gildedRose.updateQuality();
    compareItems(items, new Item("Vest", 9, 19));
  }

  @Test
  void testItemUpdatesDownBy2() {
    Item[] items = new Item[] {
      new Item("Vest", 10, 20)
    };

    GildedRose gildedRose = getGildedRose(items);

    gildedRose.updateQuality();
    gildedRose.updateQuality();
    compareItems(items, new Item("Vest", 8, 18));
  }

  @Test
  void testItemUpdatesUpBy2() {
    Item[] items = new Item[] {
      new Item("Aged Brie", 10, 20)
    };

    GildedRose gildedRose = getGildedRose(items);

    gildedRose.updateQuality();
    gildedRose.updateQuality();
    compareItems(items, new Item("Aged Brie", 8, 22));
  }

  @Test
  void testBrieUpdatesUpBy2AfterSellOn() {
    Item[] items = new Item[] {
      new Item("Aged Brie", 0, 20)
    };

    GildedRose gildedRose = getGildedRose(items);

    gildedRose.updateQuality();
    compareItems(items, new Item("Aged Brie", -1, 22));
  }

  @Test
  void testItemUpdatesDownCapped() {
    Item[] items = new Item[] {
      new Item("Vest", 10, 0)
    };

    GildedRose gildedRose = getGildedRose(items);
    gildedRose.updateQuality();
    gildedRose.updateQuality();
    compareItems(items, new Item("Vest", 8, 0));
  }

  @Test
  void testItemUpdatesUpCapped() {
    Item[] items = new Item[] {
      new Item("Aged Brie", 10, 50)
    };

    GildedRose gildedRose = getGildedRose(items);
    gildedRose.updateQuality();
    gildedRose.updateQuality();
    compareItems(items, new Item("Aged Brie", 8, 50));
  }

  @Test
  void testItemUpdatesDownExtraAfterSellIn() {
    Item[] items = new Item[] {
      new Item("Vest", 1, 10)
    };

    GildedRose gildedRose = getGildedRose(items);
    gildedRose.updateQuality();
    gildedRose.updateQuality();
    compareItems(items, new Item("Vest", -1, 7));
  }

  @Test
  void testItemUpdatesForConcert() {
    final String itemName = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items = new Item[] {
      new Item(itemName, 6, 10)
    };

    GildedRose gildedRose = getGildedRose(items);
    gildedRose.updateQuality();
    compareItems(items, new Item(itemName, 5, 12));

    gildedRose.updateQuality();
    compareItems(items, new Item(itemName, 4, 15));

    for (int i = 0; i < 5; i++) {
      gildedRose.updateQuality();
    }
    compareItems(items, new Item(itemName, -1, 0));
  }

  @Test
  void testLegendaryItemUpdatesWithoutQualityChange() {
    Item[] items = new Item[] {
      new Item("Sulfuras, Hand of Ragnaros", 10, 80)
    };

    GildedRose gildedRose = getGildedRose(items);
    gildedRose.updateQuality();
    compareItems(items, new Item("Sulfuras, Hand of Ragnaros", 10, 80));
  }

  @Test
  void testMultipleItems() {
    Item[] items = new Item[] {
      new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10),
      new Item("Sulfuras, Hand of Ragnaros", 10, 80),
      new Item("Vest", 6, 10),
      new Item("Aged Brie", 6, 10)
    };

    Item[] expectedItems1 = new Item[] {
      new Item("Backstage passes to a TAFKAL80ETC concert", 0, 27),
      new Item("Sulfuras, Hand of Ragnaros", 10, 80),
      new Item("Vest", 0, 4),
      new Item("Aged Brie", 0, 16)
    };

    GildedRose gildedRose = getGildedRose(items);
    for (int i = 0; i < 6; i++) {
      gildedRose.updateQuality();
    }
    compareItems(items, expectedItems1);

    Item[] expectedItems2 = new Item[] {
      new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
      new Item("Sulfuras, Hand of Ragnaros", 10, 80),
      new Item("Vest", -1, 2),
      new Item("Aged Brie", -1, 18)
    };
    gildedRose.updateQuality();
    compareItems(items, expectedItems2);
  }

  // this just came in the git repo, idrk what its supposed to be testing.
  @Test
  void defaultTest() {
    Item[] items = new Item[]{
      new Item("+5 Dexterity Vest", 10, 20), //
      new Item("Aged Brie", 2, 0), //
      new Item("Elixir of the Mongoose", 5, 7), //
      new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
      new Item("Sulfuras, Hand of Ragnaros", -1, 80),
      new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
      new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
      new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
      // this conjured item does not work properly yet
      new Item("Conjured Mana Cake", 3, 6)};

    GildedRose app = getGildedRose(items);

    int days = 2;

    for (int i = 0; i < days; i++) {
      System.out.println("-------- day " + i + " --------");
      System.out.println("name, sellIn, quality");
      for (Item item : items) {
        System.out.println(item);
      }
      System.out.println();
      app.updateQuality();
    }
  }

  void compareItems(Item[] arr, Item expectedArr) {
    compareItems(arr, new Item[] {expectedArr});
  }

  void compareItems(Item[] arr, Item[] expectedArr) {
    assertEquals(expectedArr.length, arr.length);
    for (int i = 0; i < arr.length; i++) {
      assertEquals(expectedArr[i].name, arr[i].name);
      assertEquals(expectedArr[i].sellIn, arr[i].sellIn);
      assertEquals(expectedArr[i].quality, arr[i].quality);
    }
  }
}
