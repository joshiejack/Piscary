package uk.joshiejack.piscary.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.block.PiscaryBlocks;
import uk.joshiejack.piscary.item.PiscaryItems;

public class PiscaryLanguage extends LanguageProvider {
    public PiscaryLanguage(DataGenerator gen) {
        super(gen, Piscary.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.piscary.creativetab", "Piscary");
        addItem(PiscaryItems.FISHING_ROD, "Fishing Rod");
        addItem(PiscaryItems.ANCHOVY, "Anchovy");
        addItem(PiscaryItems.ANGELFISH, "Angelfish");
        addItem(PiscaryItems.ANGLERFISH, "Anglerfish");
        addItem(PiscaryItems.BASS, "Bass");
        addItem(PiscaryItems.BLUE_TANG, "Blue Tang");
        addItem(PiscaryItems.BOWFIN, "Bowfin");
        addItem(PiscaryItems.BUTTERFLYFISH, "Butterflyfish");
        addItem(PiscaryItems.CARP, "Carp");
        addItem(PiscaryItems.CATFISH, "Catfish");
        addItem(PiscaryItems.CHUB, "Chub");
        addItem(PiscaryItems.DAMSELFISH, "Damselfish");
        addItem(PiscaryItems.ELECTRIC_RAY, "Electric Ray");
        addItem(PiscaryItems.GOLDFISH, "Goldfish");
        addItem(PiscaryItems.KOI, "Koi");
        addItem(PiscaryItems.LAMPREY, "Lamprey");
        addItem(PiscaryItems.LUNGFISH, "Lungfish");
        addItem(PiscaryItems.MANTA_RAY, "Manta Ray");
        addItem(PiscaryItems.MINNOW, "Minnow");
        addItem(PiscaryItems.NEON_TETRA, "Neon Tetra");
        addItem(PiscaryItems.NORTHERN_PIKE, "Northern Pike");
        addItem(PiscaryItems.PERCH, "Perch");
        addItem(PiscaryItems.PICKEREL, "Pickerel");
        addItem(PiscaryItems.PIRANHA, "Piranha");
        addItem(PiscaryItems.PUPFISH, "Pupfish");
        addItem(PiscaryItems.SARDINE, "Sardine");
        addItem(PiscaryItems.SIAMESE_FIGHTING_FISH, "Siamese Fighting Fish");
        addItem(PiscaryItems.SILVER_STRIPE_BLAASOP, "Silver-Stripe Blaasop");
        addItem(PiscaryItems.STARGAZER, "Whitemargin Stargazer");
        addItem(PiscaryItems.STINGRAY, "Sting Ray");
        addItem(PiscaryItems.TROUT, "Trout");
        addItem(PiscaryItems.TUNA, "Tuna");
        addItem(PiscaryItems.WALLEYE, "Walleye");
        addItemFromName("anchovy_bucket", "Bucket of Anchovy");
        addItemFromName("angelfish_bucket", "Bucket of Angelfish");
        addItemFromName("anglerfish_bucket", "Bucket of Anglerfish");
        addItemFromName("bass_bucket", "Bucket of Bass");
        addItemFromName("blue_tang_bucket", "Bucket of Blue Tang");
        addItemFromName("bowfin_bucket", "Bucket of Bowfin");
        addItemFromName("butterflyfish_bucket", "Bucket of Butterflyfish");
        addItemFromName("carp_bucket", "Bucket of Carp");
        addItemFromName("catfish_bucket", "Bucket of Catfish");
        addItemFromName("chub_bucket", "Bucket of Chub");
        addItemFromName("damselfish_bucket", "Bucket of Damselfish");
        addItemFromName("electric_ray_bucket", "Bucket of Electric Ray");
        addItemFromName("goldfish_bucket", "Bucket of Goldfish");
        addItemFromName("koi_bucket", "Bucket of Koi");
        addItemFromName("lamprey_bucket", "Bucket of Lamprey");
        addItemFromName("lungfish_bucket", "Bucket of Lungfish");
        addItemFromName("manta_ray_bucket", "Bucket of Manta Ray");
        addItemFromName("minnow_bucket", "Bucket of Minnow");
        addItemFromName("neon_tetra_bucket", "Bucket of Neon Tetra");
        addItemFromName("northern_pike_bucket", "Bucket of Northern Pike");
        addItemFromName("perch_bucket", "Bucket of Perch");
        addItemFromName("pickerel_bucket", "Bucket of Pickerel");
        addItemFromName("piranha_bucket", "Bucket of Piranha");
        addItemFromName("pupfish_bucket", "Bucket of Pupfish");
        addItemFromName("sardine_bucket", "Bucket of Sardine");
        addItemFromName("siamese_fighting_fish_bucket", "Bucket of Siamese Fighting Fish");
        addItemFromName("silver_stripe_blaasop_bucket", "Bucket of Silver-Stripe Blaasop");
        addItemFromName("stargazer_bucket", "Bucket of Whitemargin Stargazer");
        addItemFromName("stingray_bucket", "Bucket of Sting Ray");
        addItemFromName("trout_bucket", "Bucket of Trout");
        addItemFromName("tuna_bucket", "Bucket of Tuna");
        addItemFromName("walleye_bucket", "Bucket of Walleye");
        addItemFromName("anchovy_spawn_egg", "Spawn Anchovy");
        addItemFromName("angelfish_spawn_egg", "Spawn Angelfish");
        addItemFromName("anglerfish_spawn_egg", "Spawn Anglerfish");
        addItemFromName("bass_spawn_egg", "Spawn Bass");
        addItemFromName("blue_tang_spawn_egg", "Spawn Blue Tang");
        addItemFromName("bowfin_spawn_egg", "Spawn Bowfin");
        addItemFromName("butterflyfish_spawn_egg", "Spawn Butterflyfish");
        addItemFromName("carp_spawn_egg", "Spawn Carp");
        addItemFromName("catfish_spawn_egg", "Spawn Catfish");
        addItemFromName("chub_spawn_egg", "Spawn Chub");
        addItemFromName("damselfish_spawn_egg", "Spawn Damselfish");
        addItemFromName("electric_ray_spawn_egg", "Spawn Electric Ray");
        addItemFromName("goldfish_spawn_egg", "Spawn Goldfish");
        addItemFromName("koi_spawn_egg", "Spawn Koi");
        addItemFromName("lamprey_spawn_egg", "Spawn Lamprey");
        addItemFromName("lungfish_spawn_egg", "Spawn Lungfish");
        addItemFromName("manta_ray_spawn_egg", "Spawn Manta Ray");
        addItemFromName("minnow_spawn_egg", "Spawn Minnow");
        addItemFromName("neon_tetra_spawn_egg", "Spawn Neon Tetra");
        addItemFromName("northern_pike_spawn_egg", "Spawn Northern Pike");
        addItemFromName("perch_spawn_egg", "Spawn Perch");
        addItemFromName("pickerel_spawn_egg", "Spawn Pickerel");
        addItemFromName("piranha_spawn_egg", "Spawn Piranha");
        addItemFromName("pupfish_spawn_egg", "Spawn Pupfish");
        addItemFromName("sardine_spawn_egg", "Spawn Sardine");
        addItemFromName("siamese_fighting_fish_spawn_egg", "Spawn Siamese Fighting Fish");
        addItemFromName("silver_stripe_blaasop_spawn_egg", "Spawn Silver-Stripe Blaasop");
        addItemFromName("stargazer_spawn_egg", "Spawn Whitemargin Stargazer");
        addItemFromName("stingray_spawn_egg", "Spawn Sting Ray");
        addItemFromName("trout_spawn_egg", "Spawn Trout");
        addItemFromName("tuna_spawn_egg", "Spawn Tuna");
        addItemFromName("walleye_spawn_egg", "Spawn Walleye");
        addItem(PiscaryItems.FISH_BONES, "Fish Bones");
        addItem(PiscaryItems.OLD_BOOT, "Old Boot");
        addItem(PiscaryItems.TIN_CAN, "Empty Can");
        addItem(PiscaryItems.FOSSIL, "Fish Fossil");
        addItem(PiscaryItems.TREASURE, "Pirate Treasure");
        addItem(PiscaryItems.FISH_FINGERS, "Fish Fingers");
        addItem(PiscaryItems.SASHIMI, "Sashimi");
        addItem(PiscaryItems.FISH_STEW, "Fish Stew");
        addItem(PiscaryItems.BAIT, "Bait");
        addBlock(PiscaryBlocks.HATCHERY, "Hatchery");
        addBlock(PiscaryBlocks.FISH_TRAP, "Fish Trap");
        addBlock(PiscaryBlocks.RECYCLER, "Recycler");
    }

    public void addItemFromName(String name, String text) {
        addItem(()-> ForgeRegistries.ITEMS.getValue(new ResourceLocation(Piscary.MODID, name)), text);
    }
}
