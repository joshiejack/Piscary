package uk.joshiejack.piscary.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.DataMapProvider;
import uk.joshiejack.piscary.world.entity.PiscaryEntities;
import uk.joshiejack.piscary.world.item.crafting.HatcheryEntry;
import uk.joshiejack.piscary.world.item.crafting.PiscaryRegistries;

import java.util.concurrent.CompletableFuture;

public class PiscaryDataMapProvider extends DataMapProvider {
    public PiscaryDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void gather() {
        final var hatchery = builder(PiscaryRegistries.HATCHERY);
        //Vanilla
        hatchery.add(EntityType.COD.getDefaultLootTable(), HatcheryEntry.simple(3), false);
        hatchery.add(EntityType.SALMON.getDefaultLootTable(), HatcheryEntry.simple(3), false);
        hatchery.add(EntityType.PUFFERFISH.getDefaultLootTable(), HatcheryEntry.simple(5), false);
        hatchery.add(EntityType.TROPICAL_FISH.getDefaultLootTable(), HatcheryEntry.simple(5), false);

        //Piscary
        hatchery.add(PiscaryEntities.ANCHOVY.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(PiscaryEntities.ANGELFISH.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.ANGLERFISH.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(PiscaryEntities.BASS.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(PiscaryEntities.BLUE_TANG.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.BOWFIN.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.BUTTERFLYFISH.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.CARP.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(PiscaryEntities.CATFISH.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.CHUB.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(PiscaryEntities.DAMSELFISH.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.ELECTRIC_RAY.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(PiscaryEntities.GOLDFISH.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(PiscaryEntities.KOI.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.LAMPREY.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.LUNGFISH.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(PiscaryEntities.MANTA_RAY.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(PiscaryEntities.NEON_TETRA.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(PiscaryEntities.NORTHERN_PIKE.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.PERCH.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(PiscaryEntities.PICKEREL.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.PIRANHA.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(PiscaryEntities.PUPFISH.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.SARDINE.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(PiscaryEntities.SIAMESE_FIGHTING_FISH.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.SILVER_STRIPE_BLAASOP.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(PiscaryEntities.WHITEMARGIN_STARGAZER.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.STINGRAY.getKey(), HatcheryEntry.simple(7), false);
        hatchery.add(PiscaryEntities.TROUT.getKey(), HatcheryEntry.simple(3), false);
        hatchery.add(PiscaryEntities.TUNA.getKey(), HatcheryEntry.simple(5), false);
        hatchery.add(PiscaryEntities.WALLEYE.getKey(), HatcheryEntry.simple(3), false);

        //Aquaculture
        hatchery.add(new ResourceLocation("aquaculture", "atlantic_cod"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "blackfish"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "pacific_halibut"), HatcheryEntry.simple(7), false);
        hatchery.add(new ResourceLocation("aquaculture", "atlantic_halibut"), HatcheryEntry.simple(7), false);
        hatchery.add(new ResourceLocation("aquaculture", "atlantic_herring"), HatcheryEntry.simple(3), false);
        hatchery.add(new ResourceLocation("aquaculture", "pink_salmon"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "pollock"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "rainbow_trout"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "bayad"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "boulti"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "capitaine"), HatcheryEntry.simple(7), false);
        hatchery.add(new ResourceLocation("aquaculture", "synodontis"), HatcheryEntry.simple(3), false);
        hatchery.add(new ResourceLocation("aquaculture", "smallmouth_bass"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "bluegill"), HatcheryEntry.simple(3), false);
        hatchery.add(new ResourceLocation("aquaculture", "brown_trout"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "carp"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "catfish"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "gar"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "minnow"), HatcheryEntry.simple(4), false);
        hatchery.add(new ResourceLocation("aquaculture", "muskellunge"), HatcheryEntry.simple(7), false);
        hatchery.add(new ResourceLocation("aquaculture", "perch"), HatcheryEntry.simple(3), false);
        hatchery.add(new ResourceLocation("aquaculture", "arapaima"), HatcheryEntry.simple(7), false);
        hatchery.add(new ResourceLocation("aquaculture", "piranha"), HatcheryEntry.simple(7), false);
        hatchery.add(new ResourceLocation("aquaculture", "tambaqui"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "brown_shrooma"), HatcheryEntry.simple(2), false);
        hatchery.add(new ResourceLocation("aquaculture", "red_shrooma"), HatcheryEntry.simple(2), false);
        hatchery.add(new ResourceLocation("aquaculture", "jellyfish"), HatcheryEntry.simple(5), false);
        hatchery.add(new ResourceLocation("aquaculture", "red_grouper"), HatcheryEntry.simple(6), false);
        hatchery.add(new ResourceLocation("aquaculture", "tuna"), HatcheryEntry.simple(7), false);
    }
}