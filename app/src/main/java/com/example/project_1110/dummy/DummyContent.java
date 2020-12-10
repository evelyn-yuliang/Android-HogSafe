package com.example.project_1110.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
     ITEMS = itemCreator();
     /*   for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }*/
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), " SUSHI Items " + position,
                makeDetails(position),
                "https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/07_Sushi.jpg",
                "$10","1");
    }

    private static ArrayList<DummyItem> itemCreator (){
        ArrayList arr = new ArrayList<DummyItem>();
        arr.add(new DummyItem("0","Makizushi","Rice cut","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/07_Sushi.jpg","$10","1"));
        arr.add(new DummyItem("1","Gunkan Maki","Sheet of nori seaweed","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/06_Sushi.jpg","$23","1"));
        arr.add(new DummyItem("2","Temaki","Strip of fresh tuna","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/05_Sushi.jpg","$14","1"));
        arr.add(new DummyItem("3","Narezushi","Thicker variety","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/04_Sushi.jpg","$17","1"));
        arr.add(new DummyItem("4","Nigri","Rolled in sesame seeds","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/03_Sushi.jpg","$19","1"));
        arr.add(new DummyItem("5","Oshizushi","Squid","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/02_Sushi.jpg","$30","1"));
        arr.add(new DummyItem("6","Sasazushi","Salmon roe","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/01_Sushi.jpg","$40","1"));
        arr.add(new DummyItem("7","Kokinoha zushi","Kaitenzushi","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/08_Sushi.jpg","$11","1"));
        arr.add(new DummyItem("8","Temari","Vinegared sushi rice","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/09_Sushi.jpg","$13","1"));
        arr.add(new DummyItem("9","Inarizushi","Japanese embroidered ball","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/10_Sushi.jpg","$7","1"));
        arr.add(new DummyItem("10","Makizushi","Cured or cooked seafood","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/11_Sushi.jpg","$8","1"));
        arr.add(new DummyItem("11","Egg prawn zushi","Persimmon (kaki) leaf","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/05_Sushi.jpg","$16","1"));
        arr.add(new DummyItem("12","Chicken zushi","Walnuts, mushrooms, miso","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/04_Sushi.jpg","$23","1"));
        arr.add(new DummyItem("13","Beef zushi","Nagano prefecture","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/03_Sushi.jpg","$31","1"));arr.add(new DummyItem("0","Makizushi","Rice cut","","$10","1"));
        arr.add(new DummyItem("14","Prawns zushi","Uesugi Kenshin","https://gurunavi.com/en/japanfoodie/article/types_of_sushi/img/01_Sushi.jpg","$5","1"));

        return arr;
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;
        public final String thumbnailURL;
        public final String itemCost;
        public String itemQuantity;

        public DummyItem(String id, String content, String details, String thumbnailURL,String itemCost,String itemQuantity) {
            this.id = id;
            this.content = content;
            this.details = details;
            this.thumbnailURL = thumbnailURL;
            this.itemCost = itemCost;
            this.itemQuantity = itemQuantity;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}