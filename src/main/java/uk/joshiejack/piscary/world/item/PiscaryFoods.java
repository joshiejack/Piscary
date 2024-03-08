package uk.joshiejack.piscary.world.item;

import net.minecraft.world.food.FoodProperties;

public class PiscaryFoods {
    public static final FoodProperties SMALL_FISH = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build();
    public static final FoodProperties MEDIUM_FISH = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties LARGE_FISH = new FoodProperties.Builder().nutrition(3).saturationMod(0.1F).build();
    public static final FoodProperties FISH_FINGERS = new FoodProperties.Builder().nutrition(5).saturationMod(0.3F).fast().build();
    public static final FoodProperties SASHIMI = new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).build();
    public static final FoodProperties FISH_STEW = new FoodProperties.Builder().nutrition(7).saturationMod(0.6F).build();
}
