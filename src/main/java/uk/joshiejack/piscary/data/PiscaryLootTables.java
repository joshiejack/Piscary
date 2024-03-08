package uk.joshiejack.piscary.data;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaFishingLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.AnyOfCondition;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;
import uk.joshiejack.piscary.Piscary;
import uk.joshiejack.piscary.world.block.PiscaryBlocks;
import uk.joshiejack.piscary.world.entity.PiscaryEntities;
import uk.joshiejack.piscary.world.item.PiscaryItems;
import uk.joshiejack.piscary.world.loot.BiomeTagCondition;
import uk.joshiejack.piscary.world.loot.BiomeTypePredicate;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PiscaryLootTables extends LootTableProvider {
    public PiscaryLootTables(PackOutput output) {
        super(output, Set.of(), List.of(new SubProviderEntry(Blocks::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(Entities::new, LootContextParamSets.ENTITY),
                new SubProviderEntry(Fishing::new, LootContextParamSets.FISHING)));
    }


    public static class Entities extends EntityLootSubProvider {
        protected Entities() {
            super(FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected @NotNull Stream<EntityType<?>> getKnownEntityTypes() {
            return PiscaryEntities.ENTITIES.getEntries().stream().map(DeferredHolder::get);
        }

        @Override
        public void generate() {
            this.addFishLootTable(PiscaryEntities.ANCHOVY, PiscaryItems.ANCHOVY, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.ANGELFISH, PiscaryItems.ANGELFISH, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.ANGLERFISH, PiscaryItems.ANGLERFISH, Items.GLOWSTONE_DUST);
            this.addFishLootTable(PiscaryEntities.BASS, PiscaryItems.BASS, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.BLUE_TANG, PiscaryItems.BLUE_TANG, Items.BLUE_DYE);
            this.addFishLootTable(PiscaryEntities.BOWFIN, PiscaryItems.BOWFIN, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.BUTTERFLYFISH, PiscaryItems.BUTTERFLYFISH, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.CARP, PiscaryItems.CARP, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.CATFISH, PiscaryItems.CATFISH, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.CHUB, PiscaryItems.CHUB, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.DAMSELFISH, PiscaryItems.DAMSELFISH, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.ELECTRIC_RAY, PiscaryItems.ELECTRIC_RAY, Items.REDSTONE);
            this.addFishLootTable(PiscaryEntities.GOLDFISH, PiscaryItems.GOLDFISH, Items.GOLD_NUGGET);
            this.addFishLootTable(PiscaryEntities.KOI, PiscaryItems.KOI, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.LAMPREY, PiscaryItems.LAMPREY, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.LUNGFISH, PiscaryItems.LUNGFISH, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.MANTA_RAY, PiscaryItems.MANTA_RAY, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.MINNOW, PiscaryItems.MINNOW, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.NEON_TETRA, PiscaryItems.NEON_TETRA, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.NORTHERN_PIKE, PiscaryItems.NORTHERN_PIKE, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.PERCH, PiscaryItems.PERCH, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.PICKEREL, PiscaryItems.PICKEREL, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.PIRANHA, PiscaryItems.PIRANHA, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.PUPFISH, PiscaryItems.PUPFISH, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.SARDINE, PiscaryItems.SARDINE, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.SIAMESE_FIGHTING_FISH, PiscaryItems.SIAMESE_FIGHTING_FISH, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.WHITEMARGIN_STARGAZER, PiscaryItems.WHITEMARGIN_STARGAZER, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.STINGRAY, PiscaryItems.STINGRAY, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.SILVER_STRIPE_BLAASOP, PiscaryItems.SILVER_STRIPE_BLAASOP, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.TROUT, PiscaryItems.TROUT, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.TUNA, PiscaryItems.TUNA, Items.BONE_MEAL);
            this.addFishLootTable(PiscaryEntities.WALLEYE, PiscaryItems.WALLEYE, Items.BONE_MEAL);
        }

        private <T extends AbstractFish> void addFishLootTable(DeferredHolder<EntityType<?>, EntityType<T>> type, DeferredItem<Item> fish, Item bonus) {
            this.add(type.get(), LootTable.lootTable()
                    .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(fish.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))))
                    .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(bonus)).when(LootItemRandomChanceCondition.randomChance(0.05F))));
        }
    }

    public static class Blocks extends BlockLootSubProvider {
        protected Blocks() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Nonnull
        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return PiscaryBlocks.BLOCKS.getEntries().stream().map(DeferredHolder::value).collect(Collectors.toList());

        }

        @Override
        protected void generate() {
            dropSelf(PiscaryBlocks.RECYCLER.get());
            dropSelf(PiscaryBlocks.HATCHERY.get());
            dropSelf(PiscaryBlocks.FISH_TRAP.get());
        }
    }

    public static class Fishing extends VanillaFishingLoot {
        public static final LootItemCondition.Builder IN_OCEAN_BIOME = BiomeTagCondition.checkBiomeType(BiomeTypePredicate.Builder.type().setBiomeType(BiomeTags.IS_OCEAN));
        public static final LootItemCondition.Builder IN_COLD_BIOME = BiomeTagCondition.checkBiomeType(BiomeTypePredicate.Builder.type().setBiomeType(Tags.Biomes.IS_COLD));
        public static final LootItemCondition.Builder IN_HOT_BIOME = BiomeTagCondition.checkBiomeType(BiomeTypePredicate.Builder.type().setBiomeType(Tags.Biomes.IS_HOT));
        public static final LootItemCondition.Builder IN_SNOWY_BIOME = BiomeTagCondition.checkBiomeType(BiomeTypePredicate.Builder.type().setBiomeType(Tags.Biomes.IS_SNOWY));
        public static final LootItemCondition.Builder IN_RIVER_BIOME = BiomeTagCondition.checkBiomeType(BiomeTypePredicate.Builder.type().setBiomeType(BiomeTags.IS_RIVER));
        public static final LootItemCondition.Builder IN_SWAMPY_BIOME = BiomeTagCondition.checkBiomeType(BiomeTypePredicate.Builder.type().setBiomeType(Tags.Biomes.IS_WET));
        public static final LootItemCondition.Builder IN_JUNGLE_BIOME = BiomeTagCondition.checkBiomeType(BiomeTypePredicate.Builder.type().setBiomeType(BiomeTags.IS_JUNGLE));

        @Override
        public void generate(BiConsumer<ResourceLocation, LootTable.Builder> builder) {
            builder.accept(new ResourceLocation(Piscary.MODID, "gameplay/fishing/fish"), LootTable.lootTable().withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(PiscaryItems.ANCHOVY.get()).setWeight(32).when(IN_OCEAN_BIOME).when(AnyOfCondition.anyOf(IN_HOT_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.ANGELFISH.get()).setWeight(3).when(IN_JUNGLE_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.ANGLERFISH.get()).setWeight(1).when(IN_OCEAN_BIOME).when(IN_SNOWY_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.BASS.get()).setWeight(12).when(InvertedLootItemCondition.invert(AnyOfCondition.anyOf(IN_COLD_BIOME, IN_HOT_BIOME))))
                    .add(LootItem.lootTableItem(PiscaryItems.BLUE_TANG.get()).setWeight(1).when(IN_OCEAN_BIOME).when(IN_HOT_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.BOWFIN.get()).setWeight(3).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)).when(InvertedLootItemCondition.invert(IN_OCEAN_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.BUTTERFLYFISH.get()).setWeight(1).when(IN_OCEAN_BIOME).when(IN_HOT_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.CARP.get()).setWeight(2).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)).when(InvertedLootItemCondition.invert(IN_OCEAN_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.CATFISH.get()).setWeight(3).when(IN_RIVER_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.CHUB.get()).setWeight(54).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)).when(InvertedLootItemCondition.invert(IN_OCEAN_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.DAMSELFISH.get()).setWeight(3).when(IN_OCEAN_BIOME).when(IN_HOT_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.ELECTRIC_RAY.get()).setWeight(1).when(IN_OCEAN_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.GOLDFISH.get()).setWeight(37).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)).when(InvertedLootItemCondition.invert(IN_SWAMPY_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.KOI.get()).setWeight(1).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)).when(InvertedLootItemCondition.invert(IN_SWAMPY_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.LAMPREY.get()).setWeight(4).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)).when(InvertedLootItemCondition.invert(IN_COLD_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.LUNGFISH.get()).setWeight(1).when(InvertedLootItemCondition.invert(IN_COLD_BIOME)).when(InvertedLootItemCondition.invert(IN_OCEAN_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.MANTA_RAY.get()).setWeight(1).when(IN_OCEAN_BIOME).when(InvertedLootItemCondition.invert(IN_SNOWY_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.MINNOW.get()).setWeight(102).when(InvertedLootItemCondition.invert(IN_OCEAN_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.NEON_TETRA.get()).setWeight(2).when(IN_JUNGLE_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.NORTHERN_PIKE.get()).setWeight(1).when(IN_SNOWY_BIOME).when(IN_RIVER_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.PERCH.get()).setWeight(21).when(IN_RIVER_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.PICKEREL.get()).setWeight(2).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)).when(InvertedLootItemCondition.invert(IN_OCEAN_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.PIRANHA.get()).setWeight(1).when(IN_JUNGLE_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.PUPFISH.get()).setWeight(4).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)).when(InvertedLootItemCondition.invert(IN_OCEAN_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.SARDINE.get()).setWeight(30).when(IN_OCEAN_BIOME).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.SIAMESE_FIGHTING_FISH.get()).setWeight(2).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)).when(InvertedLootItemCondition.invert(IN_OCEAN_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.STINGRAY.get()).setWeight(1).when(IN_OCEAN_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.SILVER_STRIPE_BLAASOP.get()).setWeight(1).when(IN_OCEAN_BIOME).when(IN_SNOWY_BIOME))
                    .add(LootItem.lootTableItem(PiscaryItems.TROUT.get()).setWeight(14).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.TUNA.get()).setWeight(2).when(IN_OCEAN_BIOME).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.WALLEYE.get()).setWeight(8).when(InvertedLootItemCondition.invert(IN_HOT_BIOME)).when(InvertedLootItemCondition.invert(IN_COLD_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.WHITEMARGIN_STARGAZER.get()).setWeight(2).when(IN_HOT_BIOME).when(IN_OCEAN_BIOME))
            ));

            builder.accept(new ResourceLocation(Piscary.MODID, "gameplay/fishing/junk"), LootTable.lootTable().withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(PiscaryItems.FISH_BONES.get()).setWeight(17))
                    .add(LootItem.lootTableItem(PiscaryItems.OLD_BOOT.get()).setWeight(14))
                    .add(LootItem.lootTableItem(PiscaryItems.EMPTY_CAN.get()).setWeight(16))
            ));

            builder.accept(new ResourceLocation(Piscary.MODID, "gameplay/fishing/treasure"), LootTable.lootTable().withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(Items.EMERALD).setWeight(5))
                    .add(LootItem.lootTableItem(PiscaryItems.FISH_FOSSIL.get()).setWeight(10).when(IN_OCEAN_BIOME).when(InvertedLootItemCondition.invert(IN_SNOWY_BIOME)))
                    .add(LootItem.lootTableItem(PiscaryItems.PIRATE_TREASURE.get()).setWeight(1).when(IN_OCEAN_BIOME).when(InvertedLootItemCondition.invert(IN_SNOWY_BIOME)))
            ));
        }
    }
}
