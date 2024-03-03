package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            getCustomItem(item).updateItem();
            if(isLowestQualityValue(item)){
                item.quality = QualityValues.lowestQualityValuePossible();
            } else if(isHighestQualityValue(item)){
                item.quality = QualityValues.highestValuePossible(item);
            }
        }
    }

    private static boolean isHighestQualityValue(Item item) {
        return item.quality > QualityValues.highestValuePossible(item);
    }

    private static boolean isLowestQualityValue(Item item) {
        return item.quality <= QualityValues.lowestQualityValuePossible();
    }

    private CustomItem getCustomItem(Item item){
        return new CustomItemFactory(item).createCustomItem(item);
    }
}
