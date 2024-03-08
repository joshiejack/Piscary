package uk.joshiejack.piscary.world.loot;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.joshiejack.piscary.Piscary;

public class PiscaryLoot {
    public static final DeferredRegister<LootItemConditionType> LOOT_CONDITION_TYPES = DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, Piscary.MODID);
    public static final Holder<LootItemConditionType> BIOME_TAG = LOOT_CONDITION_TYPES.register("biome_tag", () -> new LootItemConditionType(BiomeTagCondition.CODEC));

}
