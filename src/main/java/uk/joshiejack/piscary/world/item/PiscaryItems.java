package uk.joshiejack.piscary.world.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.world.block.PiscaryBlocks;

@SuppressWarnings("unused")
public class PiscaryItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Piscary.MODID);
    //Bait
    public static final DeferredItem<Item> BAIT = ITEMS.register("bait", BaitItem::new);
    //Fish
    public static final DeferredItem<Item> ANCHOVY = ITEMS.register("anchovy", () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final DeferredItem<Item> ANGELFISH = ITEMS.register("angelfish", () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final DeferredItem<Item> ANGLERFISH = ITEMS.register("anglerfish", () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final DeferredItem<Item> BASS = ITEMS.register("bass", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> BLUE_TANG = ITEMS.register("blue_tang", () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final DeferredItem<Item> BOWFIN = ITEMS.register("bowfin", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> BUTTERFLYFISH = ITEMS.register("butterflyfish", () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final DeferredItem<Item> CARP = ITEMS.register("carp", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> CATFISH = ITEMS.register("catfish", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> CHUB = ITEMS.register("chub", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> DAMSELFISH = ITEMS.register("damselfish", () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final DeferredItem<Item> ELECTRIC_RAY = ITEMS.register("electric_ray", () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final DeferredItem<Item> GOLDFISH = ITEMS.register("goldfish", () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final DeferredItem<Item> KOI = ITEMS.register("koi", () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final DeferredItem<Item> LAMPREY = ITEMS.register("lamprey", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> LUNGFISH = ITEMS.register("lungfish", () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final DeferredItem<Item> MANTA_RAY = ITEMS.register("manta_ray", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> MINNOW = ITEMS.register("minnow", () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final DeferredItem<Item> NEON_TETRA = ITEMS.register("neon_tetra", () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final DeferredItem<Item> NORTHERN_PIKE = ITEMS.register("northern_pike", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> PERCH = ITEMS.register("perch", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> PICKEREL = ITEMS.register("pickerel", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> PIRANHA = ITEMS.register("piranha", () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final DeferredItem<Item> PUPFISH = ITEMS.register("pupfish", () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final DeferredItem<Item> SARDINE = ITEMS.register("sardine", () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final DeferredItem<Item> SIAMESE_FIGHTING_FISH = ITEMS.register("siamese_fighting_fish", () -> new Item(new Item.Properties().food(PiscaryFoods.SMALL_FISH)));
    public static final DeferredItem<Item> STINGRAY = ITEMS.register("stingray", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> SILVER_STRIPE_BLAASOP = ITEMS.register("silver_stripe_blaasop", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> TROUT = ITEMS.register("trout", () -> new Item(new Item.Properties().food(PiscaryFoods.MEDIUM_FISH)));
    public static final DeferredItem<Item> TUNA = ITEMS.register("tuna", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> WALLEYE = ITEMS.register("walleye", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));
    public static final DeferredItem<Item> WHITEMARGIN_STARGAZER = ITEMS.register("whitemargin_stargazer", () -> new Item(new Item.Properties().food(PiscaryFoods.LARGE_FISH)));

    //Loot
    public static final DeferredItem<Item> FISH_BONES = ITEMS.register("fish_bones", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FISH_FOSSIL = ITEMS.register("fish_fossil", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OLD_BOOT = ITEMS.register("old_boot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> EMPTY_CAN = ITEMS.register("empty_can", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PIRATE_TREASURE = ITEMS.register("pirate_treasure", () -> new TreasureItem(new Item.Properties()));
    //Meals
    public static final DeferredItem<Item> FISH_FINGERS = ITEMS.register("fish_fingers", () -> new Item(new Item.Properties().food(PiscaryFoods.FISH_FINGERS)));
    public static final DeferredItem<Item> SASHIMI = ITEMS.register("sashimi", () -> new Item(new Item.Properties().food(PiscaryFoods.SASHIMI)));
    public static final DeferredItem<Item> FISH_STEW = ITEMS.register("fish_stew", () -> new Item(new Item.Properties().food(PiscaryFoods.FISH_STEW)));
    public static final DeferredItem<Item> FISH_TRAP = ITEMS.register("fish_trap", () -> new FishTrapItem(PiscaryBlocks.FISH_TRAP.get(), new Item.Properties()));
    public static final DeferredItem<Item> HATCHERY = ITEMS.register("hatchery", () -> new HatcheryItem(PiscaryBlocks.HATCHERY.get(), new Item.Properties()));
    public static final DeferredItem<Item> RECYCLER = ITEMS.register("recycler", () -> new BlockItem(PiscaryBlocks.RECYCLER.get(), new Item.Properties()));
}
