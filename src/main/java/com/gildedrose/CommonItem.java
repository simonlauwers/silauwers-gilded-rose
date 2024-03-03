package com.gildedrose;

public class CommonItem implements CustomItem {
    private final Item item;

    public CommonItem(Item item) {
        this.item = item;
    }

    private void decreaseSellInByOne(){
        item.sellIn -= 1;
    }

    private void decreaseQuality(int amount){
        item.quality -= amount;
    }

    public int decreasingValueForSellInGreaterThanZero() {
        return 1;
    }
    @Override
    public void updateItem() {
        decreaseSellInByOne();
        if(item.sellIn > 0){
            decreaseQuality(decreasingValueForSellInGreaterThanZero());
        }else{
            decreaseQuality(decreasingValueForSellInGreaterThanZero() * 2);
        }
    }
}
