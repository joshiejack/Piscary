package uk.joshiejack.piscary.world.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nonnull;

public record BiomeTagCondition(BiomeTypePredicate predicate) implements LootItemCondition {
    public static final Codec<BiomeTagCondition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BiomeTypePredicate.CODEC.fieldOf("predicate").forGetter(BiomeTagCondition::predicate))
                    .apply(instance, BiomeTagCondition::new));


    @Nonnull
    @Override
    public LootItemConditionType getType() {
        return PiscaryLoot.BIOME_TAG.value();
    }

    @Override
    public boolean test(LootContext ctx) {
        Vec3 v3d = ctx.getParamOrNull(LootContextParams.ORIGIN);
        return v3d != null && this.predicate.matches(ctx.getLevel(), v3d.x, v3d.y, v3d.z);
    }

    public static LootItemCondition.Builder checkBiomeType(BiomeTypePredicate.Builder builder) {
        return () -> new BiomeTagCondition(builder.build());
    }
}
