package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class CustomItemFactory {
    private final static Map<String, CustomItem> ITEM_TYPES_LIST = new HashMap<>();
    public final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public final static String AGED_BRIE = "Aged Brie";
    public final static String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    public final static String CONJURED_ITEM = "Conjured";

    public CustomItemFactory(Item item) {
        ITEM_TYPES_LIST.put(SULFURAS, new Sulfuras());
        ITEM_TYPES_LIST.put(AGED_BRIE, new AgedBrie(item));
        ITEM_TYPES_LIST.put(BACKSTAGE_PASSES_ITEM, new BackStagePasses(item));
        ITEM_TYPES_LIST.put(CONJURED_ITEM, new ConjuredItem(item));
    }

    public CustomItem createCustomItem(Item item) {
        if (isCommonItem(item)) {
            return new CommonItem(item);
        }
        return ITEM_TYPES_LIST.get(item.name);
    }

    private boolean isCommonItem(Item item) {
        return !ITEM_TYPES_LIST.containsKey(item.name);
    }
}
