package com.gildedrose;

public class QualityValues {
    public static int highestValuePossible(Item item) {
        if (item.name.equals(CustomItemFactory.SULFURAS)) {
            return 80;
        }
        return 50;
    }

    public static int lowestQualityValuePossible() {
        return 0;
    }
}
