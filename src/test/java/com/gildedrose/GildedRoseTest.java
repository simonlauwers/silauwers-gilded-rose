package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        GildedRose app = newGildedRose("foo", 0, 0);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    /**
     * COMMON ITEM TESTS
     */

    // Quality tests
    @Test
    public void commonItemQualityDecreasesByOneIfSellInIsGreaterThanZero(){
        GildedRose app = newGildedRose("Apple", 2, 2);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }
    @Test
    public void commonItemQualityDecreasesByTwoIfSellInIsZeroOrLess(){
        GildedRose app = newGildedRose("Apple", 0, 2);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void commonItemQualityCannotBeBelowZero(){
        GildedRose app = newGildedRose("Apple", 0, 0);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    // SellIn tests

    @Test
    public void commonItemSellInDecreasesByOne(){
        GildedRose app = newGildedRose("Apple", 0, 0);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    /**
     * AGED BRIE TESTS
     */

    // Quality tests
    @Test
    public void agedBrieIncreasesQuality(){
        GildedRose app = newGildedRose(CustomItemFactory.AGED_BRIE, 1, 1);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void agedBrieQualityCannotExceedFifty(){
        GildedRose app = newGildedRose(CustomItemFactory.AGED_BRIE, 0, 50);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    // Sell in
    @Test
    public void agedBrieDecreasesSellInDecreasesByOne(){
        GildedRose app = newGildedRose(CustomItemFactory.AGED_BRIE, 2, 1);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
    }

    /**
     * BACKSTAGE PASSES TESTS
     */

    // Quality tests
    @Test
    public void backStagePassesIncreasesQualityByOneIfSellInGreaterThanEleven(){
        GildedRose app = newGildedRose(CustomItemFactory.BACKSTAGE_PASSES_ITEM, 12, 1);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void backStagePassesIncreasesQualityByTwoIfSellInBetweenTenAndSix(){
        GildedRose app = newGildedRose(CustomItemFactory.BACKSTAGE_PASSES_ITEM, 9, 1);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void backStagePassesQualityDropsToZeroIfSellInIsZeroOrLess(){
        GildedRose app = newGildedRose(CustomItemFactory.BACKSTAGE_PASSES_ITEM, 0, 6);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void backStagePassesQualityCannotExceedFifty(){
        GildedRose app = newGildedRose(CustomItemFactory.BACKSTAGE_PASSES_ITEM, 9, 50);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    // Sell In tests
    @Test
    public void backStagePassesDecreaseSellIn(){
        GildedRose app = newGildedRose(CustomItemFactory.BACKSTAGE_PASSES_ITEM, 9, 1);
        app.updateQuality();
        assertEquals(8, app.items[0].sellIn);
    }

    /**
     * SULFURAS TESTS
     */

    // Quality
    @Test
    public void sulfurasQualityIs80(){
        GildedRose app = newGildedRose(CustomItemFactory.SULFURAS, 1, 80);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void sulfurasValuesCannotBeAltered(){
        GildedRose app = newGildedRose(CustomItemFactory.SULFURAS, 1, 80);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    /**
     * CONJURED ITEMS TEST
     */
    @Test
    public void conjuredItemDecreasesQualityByTwoIfSellInIsGreaterThanZero() {
        GildedRose app = newGildedRose(CustomItemFactory.CONJURED_ITEM, 4, 6);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void conjuredItemDecreasesQualityByFourOnceSellInIsZeroOrLess() {
        GildedRose app = newGildedRose(CustomItemFactory.CONJURED_ITEM,0, 9);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
    }

    @Test
    public void conjuredItemCannotHaveQualityBelowZero() {
        GildedRose app = newGildedRose(CustomItemFactory.CONJURED_ITEM, 0, 0);

        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }


    /**
     * Utils
     */
    private GildedRose newGildedRose(String itemName, int itemSellIn, int itemQuality) {
        Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality)};
        return new GildedRose(items);
    }
}
