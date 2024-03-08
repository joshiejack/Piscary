package uk.joshiejack.piscary.world.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import javax.annotation.Nullable;

public record BiomeTypePredicate(TagKey<Biome> tagKey) {
    public static final Codec<BiomeTypePredicate> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    TagKey.codec(Registries.BIOME).fieldOf("biome_tag").forGetter((BiomeTypePredicate p) -> p.tagKey))
            .apply(instance, BiomeTypePredicate::new));
    public static final BiomeTypePredicate ANY = new BiomeTypePredicate(null);

    public boolean matches(ServerLevel world, double x, double y, double z) {
        if (tagKey == null) return true;
        BlockPos blockpos = BlockPos.containing(x, y, z);
        return world.getBiome(blockpos).is(tagKey);
    }

    public static class Builder {
        private TagKey<Biome> tagKey;

        public static BiomeTypePredicate.Builder type() {
            return new BiomeTypePredicate.Builder();
        }

        public BiomeTypePredicate.Builder setBiomeType(@Nullable TagKey<Biome> tagKey) {
            this.tagKey = tagKey;
            return this;
        }

        public BiomeTypePredicate build() {
            return new BiomeTypePredicate(this.tagKey);
        }
    }
}
