package com.gildedrose;

public class ConjuredItem extends CommonItem {
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public int decreasingValueForSellInGreaterThanZero() {
        return 2;
    }
}
