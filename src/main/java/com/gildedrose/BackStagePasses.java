package com.gildedrose;

public class BackStagePasses implements CustomItem {
    private final Item item;

    public BackStagePasses(Item item) {
        this.item = item;
    }

    private void decreaseSellByDayValueByOne() {
        item.sellIn -= 1;
    }

    private void increaseQuality(int amount){
        item.quality += amount;
    }


    @Override
    public void updateItem() {
        decreaseSellByDayValueByOne();
        if (item.sellIn > 10){
            increaseQuality(1);
        } else if (item.sellIn > 5){
            increaseQuality(2);
        } else if (item.sellIn > 0){
            increaseQuality(3);
        } else {
            item.quality = 0;
        }
    }
}
