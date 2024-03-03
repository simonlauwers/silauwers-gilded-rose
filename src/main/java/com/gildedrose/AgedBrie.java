package com.gildedrose;

public class AgedBrie implements CustomItem{
    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    private void decreaseSellInValueByOne(){
        this.item.sellIn -= 1;
    }

    private void increaseQualityByOne(){
        this.item.quality += 1;
    }

    @Override
    public void updateItem() {
        decreaseSellInValueByOne();
        increaseQualityByOne();
    }
}
